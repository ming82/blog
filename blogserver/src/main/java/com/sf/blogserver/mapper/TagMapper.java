package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.Tag;
import com.sf.blogserver.bean.TagExample;
import java.util.List;

public interface TagMapper {
    long countByExample(TagExample example);

    int deleteByPrimaryKey(Integer tagId);

    int insert(Tag record);

    int insertSelective(Tag record);

    List<Tag> selectByExample(TagExample example);

    Tag selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}