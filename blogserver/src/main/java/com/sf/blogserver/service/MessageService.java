package com.sf.blogserver.service;

import com.sf.blogserver.bean.Message;

import java.util.List;

public interface MessageService {

    List<Message> selectByUserId(Integer userId);

    int deleteByPrimaryKey(Integer messageId);
}
