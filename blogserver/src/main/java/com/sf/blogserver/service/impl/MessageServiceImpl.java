package com.sf.blogserver.service.impl;

import com.sf.blogserver.bean.Message;
import com.sf.blogserver.mapper.MessageMapper;
import com.sf.blogserver.service.MessageService;
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

    @Override
    public List<Message> selectByUserId(Integer userId) {
        return messageMapper.selectByUserId(userId);
    }

    @Override
    public int deleteByPrimaryKey(Integer messageId) {
        return messageMapper.deleteByPrimaryKey(messageId);
    }
}
