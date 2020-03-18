package com.sf.blogserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sf.blogserver.bean.*;
import com.sf.blogserver.config.security.UserDetail;
import com.sf.blogserver.mapper.*;
import com.sf.blogserver.query.UserQuery;
import com.sf.blogserver.service.UserService;
import com.sf.blogserver.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    IssueMapper issueMapper;

    @Autowired
    AnswerMapper answerMapper;
    @Value("${image_url}")
    String IMAGE_URL;

    @Override
    public UserDetail getUserByUsername(String userName) {
        User user = userMapper.selectByUsername(userName);
        UserDetail userDetail = new UserDetail();
        BeanUtils.copyProperties(user,userDetail);
        //注入用户角色
        List<Integer> roleIds = userRoleMapper.selectByUserId(user.getUserId());
        List<Role> roles = new ArrayList<>();
        for(Integer roleId:roleIds){
            roles.add(roleMapper.selectByPrimaryKey(roleId));
        }
        userDetail.setRoles(roles);
        return userDetail;
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Transactional
    @Override
    public int register(User user) {
        user.setUserRegistetime(new Date());
        user.setUserPicture("default.jpg");
        int ret1 = userMapper.insertSelective(user);
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getUserId());
        int ret2 = userRoleMapper.insertSelective(userRole);
        return ret1+ret2;
    }

    @Override
    public int nameCheck(String userName,String userNickname) {
        User checkUserName = userMapper.selectByUsername(userName);
        User checkUserNickname = userMapper.selectByUserNickname(userNickname);
        if(checkUserName != null){
            return 1;
        }else if(checkUserNickname != null){
            return 2;
        }else
            return 0;
    }

    @Override
    public int nickNameCheck(String userNickname) {
        User checkUserNickname = userMapper.selectByUserNickname(userNickname);
        if(checkUserNickname == null){
            return 1;
        }else
            return 0;
    }

    @Override
    public PageInfo getList(UserQuery query) {
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        List<User> users = userMapper.selectByQuery(query);
        List<UserVo> userVos = new ArrayList<>();
        PageInfo pageInfo = new PageInfo<>(users);
        for (User user : users) {
            userVos.add(userToVo(user));
        }
        pageInfo.setList(userVos);
        return pageInfo;
    }

    @Transactional
    @Override
    public int updatePermit(UserQuery user) {
        List<Integer> roleNum = userRoleMapper.selectByUserId(user.getUserId());
        if(user.getPermit().equals("普通用户")){
            if(roleNum.size() == 2){
                return userRoleMapper.deleteByUidRid(user.getUserId(),2);
            } else if(roleNum.size() == 3){
                userRoleMapper.deleteByUidRid(user.getUserId(),2);
                return userRoleMapper.deleteByUidRid(user.getUserId(),3);
            } else {
                return 1;
            }
        } else if(user.getPermit().equals("管理员")){
            if(roleNum.size() == 1){
                UserRole role = new UserRole();
                role.setRoleId(2);
                role.setUserId(user.getUserId());
                return userRoleMapper.insertSelective(role);
            } else if(roleNum.size() == 3){
                return userRoleMapper.deleteByUidRid(user.getUserId(),3);
            } else {
                return 1;
            }
        } else {
            if(roleNum.size() == 1){
                UserRole role1 = new UserRole();
                role1.setRoleId(2);
                role1.setUserId(user.getUserId());
                userRoleMapper.insertSelective(role1);
                UserRole role2 = new UserRole();
                role2.setUserId(user.getUserId());
                role2.setRoleId(3);
                return userRoleMapper.insertSelective(role2);
            } else if(roleNum.size() == 2){
                UserRole role = new UserRole();
                role.setUserId(user.getUserId());
                role.setRoleId(3);
                return userRoleMapper.insertSelective(role);
            } else {
                return 1;
            }
        }
    }

    @Override
    public UserVo getUserInfo(Integer userId) {
        return userToVo(userMapper.selectByPrimaryKey(userId));
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public UserVo userToVo(User user){
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user,userVo);
        List<Article> articles = articleMapper.selectByUserId(user.getUserId());
        List<Issue> issues = issueMapper.selectByUserId(user.getUserId());
        List<Answer> answers = answerMapper.selectByUserId(user.getUserId());
        userVo.setUserPicture(IMAGE_URL+user.getUserPicture());
        userVo.setAnswerNum(answers.size());
        userVo.setArticleNum(articles.size());
        userVo.setIssuesNum(issues.size());
        int likes = 0;
        for(Article article:articles){
            likes += article.getArticleLikes();
        }
        for(Answer answer:answers){
            likes += answer.getAnswerLikes();
        }
        userVo.setLikes(likes);
        //注入用户角色
        List<Integer> roleIds = userRoleMapper.selectByUserId(user.getUserId());
        List<Role> roles = new ArrayList<>();
        for(Integer roleId:roleIds){
            roles.add(roleMapper.selectByPrimaryKey(roleId));
        }
        userVo.setRoles(roles);
        return userVo;
    }
}
