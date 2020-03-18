package com.sf.blogserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sf.blogserver.bean.Article;
import com.sf.blogserver.bean.Issue;
import com.sf.blogserver.bean.User;
import com.sf.blogserver.mapper.IssueMapper;
import com.sf.blogserver.mapper.UserMapper;
import com.sf.blogserver.query.IssueQuery;
import com.sf.blogserver.service.IssueService;
import com.sf.blogserver.vo.ArticleVo;
import com.sf.blogserver.vo.IssueVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IssueServiceImlp implements IssueService {

    @Autowired
    IssueMapper issueMapper;

    @Autowired
    UserMapper userMapper;
    @Value("${image_url}")
    String IMAGE_URL;

    @Override
    public IssueVo selectIssueById(Integer issueId) {
        return issueToVo(issueMapper.selectByPrimaryKey(issueId));
    }


    @Override
    public List<IssueVo> getNoAnswer() {
        List<IssueVo> issueVos = new ArrayList<>();
        for (Issue issue : issueMapper.selectNoAnswer()) {
            issueVos.add(issueToVo(issue));
        }
        return issueVos;
    }

    @Override
    public List<IssueVo> getHotIssues() {
        List<IssueVo> issueVos = new ArrayList<>();
        for (Issue issue : issueMapper.selectHotIssues()) {
            issueVos.add(issueToVo(issue));
        }
        return issueVos;
    }

    @Override
    public List<IssueVo> getIssuesByUserId(Integer userId) {
        List<IssueVo> issueVos = new ArrayList<>();
        for (Issue issue : issueMapper.selectByUserId(userId)) {
            issueVos.add(issueToVo(issue));
        }
        return issueVos;
    }

    @Override
    public int addNewIssue(Issue issue) {
        issue.setPublishdate(new Date());
        return issueMapper.insertSelective(issue);
    }

    @Override
    public int deleteIssue(Integer issueId) {
        return issueMapper.updateToDelete(issueId);
    }

    @Override
    public PageInfo getIssues(IssueQuery query) {
        if(query.getUserId() == null&&query.getUserNickname() != null&&query.getUserNickname() != ""){
            User user = userMapper.selectByUserNickname(query.getUserNickname());
            if(user == null){
                return new PageInfo();
            }else {
                query.setUserId(user.getUserId());
            }
        }
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        List<Issue> issues = issueMapper.selectByQuery(query);
        List<IssueVo> issueVos = new ArrayList<>();
        PageInfo pageInfo = new PageInfo<>(issues);
        for (Issue issue : issues) {
            issueVos.add(issueToVo(issue));
        }
        pageInfo.setList(issueVos);
        return pageInfo;
    }

    @Override
    public int updateIssue(IssueVo issue) {
        Issue iss = new Issue();
        BeanUtils.copyProperties(issue,iss);
        return issueMapper.updateByPrimaryKeySelective(iss);
    }

    /**
     * 将issue转为issueVo
     *
     * @param issue
     * @return
     */
    IssueVo issueToVo(Issue issue) {
        IssueVo issueVo = new IssueVo();
        BeanUtils.copyProperties(issue,issueVo);
        //获取昵称,头像
        User user = userMapper.selectByPrimaryKey(issue.getUserId());
        issueVo.setUserNickname(user.getUserNickname());
        issueVo.setUserPicture(IMAGE_URL+user.getUserPicture());

        return issueVo;
    }
}
