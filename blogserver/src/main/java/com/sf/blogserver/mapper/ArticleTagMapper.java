package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.ArticleTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleTagMapper {
    ArticleTag selectByAidTid(@Param("articleId") Integer articleId,@Param("tagId") Integer tagId);

    List<ArticleTag> selectByAid(Integer articleId);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleTag record);

    int insertSelective(ArticleTag record);

    ArticleTag selectByPrimaryKey(Integer id);

    List<Integer> selectTagIdByArticleId(Integer articleId);

    int updateByPrimaryKeySelective(ArticleTag record);

    int updateByPrimaryKey(ArticleTag record);

    List<ArticleTag> selectByTagId(Integer tagId);
}
