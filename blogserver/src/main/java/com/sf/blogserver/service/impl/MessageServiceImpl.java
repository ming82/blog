package com.sf.blogserver.service.impl;

import com.sf.blogserver.bean.Message;
import com.sf.blogserver.bean.User;
import com.sf.blogserver.mapper.CommentMapper;
import com.sf.blogserver.mapper.MessageMapper;
import com.sf.blogserver.mapper.UserMapper;
import com.sf.blogserver.service.MessageService;
import com.sf.blogserver.vo.MessageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserMapper userMapper;
    @Value("${image_url}")
    String IMAGE_URL;

    @Override
    public List<MessageVo> getReadByUserId(Integer userId) {
        return messageToVo(messageMapper.getReadMessages(userId));
    }

    @Override
    public List<MessageVo> getNoreadByUserId(Integer userId) {
        return messageToVo(messageMapper.getNoReadMessages(userId));
    }

    @Override
    public int markRead(List<Integer> list) {
        int flag = 0;
        for (Integer i:list){
            flag = messageMapper.markRead(i);
        }
        return flag;
    }

    @Override
    public int countNoRead(Integer userId) {
        return messageMapper.countNoRead(userId);
    }


    List<MessageVo> messageToVo(List<Message> messages){
        List<MessageVo> messageVos = new ArrayList<>();
        for(Message message:messages){
            MessageVo messageVo = new MessageVo();
            //注入已有属性
            BeanUtils.copyProperties(message,messageVo);
            //获取昵称,头像
            User user = userMapper.selectByPrimaryKey(message.getCommentuserid());
            messageVo.setCommentuserNickName(user.getUserNickname());
            messageVo.setUserPicture(IMAGE_URL+user.getUserPicture());
            //获取评论信息
            if(message.getMessageType()!=1){
                messageVo.setCommentBody(commentMapper.selectByPrimaryKey(message.getCommentId()).getCommentBody());
            }
            messageVos.add(messageVo);
        }

        return messageVos;
    }
}
