package com.sf.blogserver.service.impl;

import com.sf.blogserver.bean.Message;
import com.sf.blogserver.mapper.MessageMapper;
import com.sf.blogserver.mapper.UserMapper;
import com.sf.blogserver.service.MessageService;
import com.sf.blogserver.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Discription
 * @auther Hh
 * @package com.sf.blogserver.service.impl
 * @create 2019/10/27 20:42
 * @Version: 1.0
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;

    @Autowired
    UserMapper userMapper;

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
            messageVo.setMessageId(message.getMessageId());
            messageVo.setAnswerId(message.getAnswerId());
            messageVo.setArticleId(message.getArticleId());
            messageVo.setCommentuserid(message.getCommentuserid());
            messageVo.setMessageIsread(message.getMessageIsread());
            messageVo.setMessageType(message.getMessageType());
            messageVo.setPublishdate(message.getPublishdate());
            //获取昵称
            messageVo.setCommentuserNickName(userMapper.selectByPrimaryKey(message.getCommentuserid()).getUserNickname());

            messageVos.add(messageVo);
        }


        return messageVos;
    }
}
