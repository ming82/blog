package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.Message;
import com.sf.blogserver.bean.MessageExample;
import java.util.List;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer messageId);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}