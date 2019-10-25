package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.ArticleTag;
import com.sf.blogserver.bean.ArticleTagExample;
import java.util.List;

public interface ArticleTagMapper {
    long countByExample(ArticleTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleTag record);

    int insertSelective(ArticleTag record);

    List<ArticleTag> selectByExample(ArticleTagExample example);

    ArticleTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleTag record);

    int updateByPrimaryKey(ArticleTag record);
}