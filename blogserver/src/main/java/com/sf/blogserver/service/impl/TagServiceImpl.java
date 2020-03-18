package com.sf.blogserver.service.impl;

import com.sf.blogserver.bean.Tag;
import com.sf.blogserver.mapper.ArticleTagMapper;
import com.sf.blogserver.mapper.TagMapper;
import com.sf.blogserver.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;

    @Autowired
    ArticleTagMapper articleTagMapper;


    @Override
    public List<Tag> getAllTag() {
        return tagMapper.selectAll();
    }

    @Override
    public List<Tag> getTagByArticleId(Integer articleId) {
        List<Tag> tags=new ArrayList<>();
        for(Integer tagId:articleTagMapper.selectTagIdByArticleId(articleId)){
            tags.add(tagMapper.selectByPrimaryKey(tagId));
        }
        return tags;
    }

    @Override
    public int insertTag(Tag tag) {
        return tagMapper.insertSelective(tag);
    }

    @Override
    public int deleteTag(Integer tagId) {
        if(articleTagMapper.selectByTagId(tagId).size() > 0){
            return -1;
        }else {
            return tagMapper.deleteByPrimaryKey(tagId);
        }
    }

    @Override
    public int update(Tag tag) {
        return tagMapper.updateByPrimaryKeySelective(tag);
    }
}
