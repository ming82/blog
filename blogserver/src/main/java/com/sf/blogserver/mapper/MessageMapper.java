package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.Message;

import java.util.List;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer messageId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer messageId);

    List<Message> selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}
