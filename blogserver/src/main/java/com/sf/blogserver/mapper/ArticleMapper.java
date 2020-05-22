package com.sf.blogserver.mapper;

import com.sf.blogserver.query.ArticleQuery;
import com.sf.blogserver.bean.Article;
import com.sf.blogserver.vo.ArticleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 操作文章表接口
 * @author SM
 */
@Mapper
public interface ArticleMapper {
    /**
     * 新增文章
     * @param record 文章实体
     * @return
     */
    int insertSelective(ArticleVo record);

    /**
     * 根据主键修改文章
     * @param record 文章主体
     * @return
     */
    int updateByPrimaryKeySelective(ArticleVo record);

    /**
     * 根据主键查询文章
     * @param articleId 文章ID
     * @return
     */
    Article selectByPrimaryKey(Integer articleId);

    /**
     * 根据查询类查询文章
     * @param query 查询主体
     * @return
     */
    List<Article> selectByQuery(ArticleQuery query);

    /**
     * 根据用户ID查询文章
     * @param userId 用户ID
     * @return
     */
    List<Article> selectByUserId(Integer userId);

    /**
     * 根据用户ID查询其草稿
     * @param userId 用户ID
     * @return
     */
    List<Article> getDraft(Integer userId);

    /**
     * 根据栏目ID查询文章
     * @param categoryId 栏目ID
     * @return
     */
    List<Article> selectByCategoryId(Integer categoryId);

    /**
     * 根据文章ID修改文章状态为删除
     * @param articleId 文章ID
     * @return
     */
    int updateToDelete(Integer articleId);

    /**
     * 增长文章评论数
     * @param articleId 文章ID
     * @return
     */
    int increaseComment(Integer articleId);

    /**
     * 增长文章评论数
     * @param articleId 文章ID
     * @return
     */
    int increaseLike(Integer articleId);

    /**
     * 增长文章浏览量
     * @param articleId 文章ID
     * @return
     */
    int increasePageview(Integer articleId);

    /**
     * 增长文章收藏数
     * @param articleId 文章ID
     * @return
     */
    int increaseFavorite(Integer articleId);

    /**
     * 减少文章收藏数
     * @param articleId 文章ID
     * @return
     */
    int decreaseFavorite(Integer articleId);

    /**
     * 获取热门文章
     * @return
     */
    List<Article> getHotArticles();

    /**
     * 获取最新文章
     * @return
     */
    List<Article> getNewArticles();
}
