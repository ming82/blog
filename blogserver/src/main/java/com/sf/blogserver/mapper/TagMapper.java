package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.Tag;

import java.util.List;

public interface TagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer tagId);

    List<Tag> selectAll();

    int selectIdByName(String tagName);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}
