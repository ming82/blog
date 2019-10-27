package com.sf.blogserver.service.impl;

import com.sf.blogserver.bean.Issue;
import com.sf.blogserver.mapper.IssueMapper;
import com.sf.blogserver.mapper.UserMapper;
import com.sf.blogserver.service.IssueService;
import com.sf.blogserver.vo.IssueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Discription
 * @auther Hh
 * @package com.sf.blogserver.service.impl
 * @create 2019/10/26 14:07
 * @Version: 1.0
 */
@Service
public class IssueServiceImlp implements IssueService {

    @Autowired
    IssueMapper issueMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<IssueVo> selectAllIssue() {
        List<IssueVo> issueVos=new ArrayList<>();
        for (Issue issue :issueMapper.selectAll()) {
            //注入已有属性
            IssueVo issueVo=new IssueVo();
            issueVo.setIssueId(issue.getIssueId());
            issueVo.setIssueTitle(issue.getIssueTitle());
            issueVo.setUserId(issue.getUserId());
            issueVo.setPublishdate(issue.getPublishdate());
            issueVo.setIssueAnswers(issue.getIssueAnswers());
            //获取用户昵称
            issueVo.setUserNickname(userMapper.selectByPrimaryKey(issue.getUserId()).getUserNickname());

            issueVos.add(issueVo);
        }
        return issueVos;
    }

    @Override
    public Issue selectIssueByPrimaryKey(Integer issueId) {

        return issueMapper.selectByPrimaryKey(issueId);
    }

    @Override
    public int addNewIssue(Issue issue) {
        issue.setPublishdate(new Date());
        return issueMapper.insertSelective(issue);
    }

    @Override
    public int updateIssue(Issue issue) {

        return issueMapper.updateByPrimaryKey(issue);
    }

    @Override
    public int deleteIssue(Integer issueId) {
        return issueMapper.deleteByPrimaryKey(issueId);
    }
}