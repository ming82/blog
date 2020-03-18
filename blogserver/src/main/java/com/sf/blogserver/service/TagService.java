package com.sf.blogserver.service;

import com.sf.blogserver.bean.Tag;

import java.util.List;

public interface TagService {

    List<Tag> getAllTag();

    List<Tag> getTagByArticleId(Integer articleId);

    int insertTag(Tag tag);

    int deleteTag(Integer tagId);

    int update(Tag tag);
}
