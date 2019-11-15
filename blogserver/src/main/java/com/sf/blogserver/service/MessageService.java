package com.sf.blogserver.service;

import com.sf.blogserver.vo.MessageVo;

import java.util.List;

public interface MessageService {

    List<MessageVo> getReadByUserId(Integer userId);

    List<MessageVo> getNoreadByUserId(Integer userId);

    int markRead(List<Integer> list);

    int countNoRead(Integer userId);
}
