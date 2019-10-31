package com.sf.blogserver.service;

import com.sf.blogserver.vo.MessageVo;

import java.util.List;

public interface MessageService {

    List<MessageVo> getAllByUserId(Integer userId);

    List<MessageVo> getNoreadByUserId(Integer userId);
}
