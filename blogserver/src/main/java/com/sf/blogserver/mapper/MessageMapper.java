package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.Message;

import java.util.List;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer messageId);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> getNoReadMessages(Integer userId);

    List<Message> getReadMessages(Integer userId);

    int markRead(Integer messageId);

    int countNoRead(Integer userId);

    Message selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}
