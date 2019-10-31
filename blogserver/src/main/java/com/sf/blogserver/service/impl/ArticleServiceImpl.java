package com.sf.blogserver.service.impl;

import com.sf.blogserver.bean.Article;
import com.sf.blogserver.bean.ArticleTag;
import com.sf.blogserver.bean.Tag;
import com.sf.blogserver.mapper.*;
import com.sf.blogserver.service.ArticleService;
import com.sf.blogserver.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Discription
 * @auther Hh
 * @package com.sf.blogserver.service.impl
 * @create 2019/10/25 16:14
 * @Version: 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ArticleTagMapper articleTagMapper;

    @Autowired
    TagMapper tagMapper;

    @Deprecated
    CategoryMapper categoryMapper;

    @Override
    public List<ArticleVo> getAllArticle() {

        return articlesToVo(articleMapper.selectAll());
    }

    @Override
    public List<ArticleVo> getArticlesByCategoryId(Integer categoryId) {

        return articlesToVo(articleMapper.selectByCategoryId(categoryId));
    }

    @Override
    public List<ArticleVo> getHotArticles() {
        return articlesToVo(articleMapper.getHotArticles());
    }

    @Override
    public List<ArticleVo> getNewArticles() {
        return articlesToVo(articleMapper.getNewArticles());
    }

    @Override
    public List<ArticleVo> getArticlesByUserId(Integer userId) {
        return articlesToVo(articleMapper.selectByUserId(userId));
    }

    @Override
    public Article getArticleById(Integer articleId) {
        //增加浏览量
        articleMapper.increasePageview(articleId);
        return articleMapper.selectByPrimaryKey(articleId);
    }

    @Override
    public int addNewArticle(Article article, List<Tag> oldTags, List<String> newTags) {
        Date date = new Date();
        article.setPublishdate(date);
        article.setEdittime(date);
        //截取文章
        String stripHtml = article.getMdcontent();
        article.setArticleSummary(stripHtml.substring(0, stripHtml.length() > 100 ? 100 : stripHtml.length())+"...");
        //新增标签，并建立关联
        for(String tagName:newTags){
            Tag tag = new Tag();
            tag.setTagName(tagName);
            tagMapper.insertSelective(tag);

            ArticleTag articleTag = new ArticleTag();
            articleTag.setArticleId(article.getArticleId());
            articleTag.setTagId(tag.getTagId());

            articleTagMapper.insertSelective(articleTag);
        }
        //建立文章标签关联
        for(Tag tag:oldTags){
            ArticleTag articleTag = new ArticleTag();
            articleTag.setArticleId(article.getArticleId());
            articleTag.setTagId(tag.getTagId());

            articleTagMapper.insertSelective(articleTag);
        }
        return articleMapper.insertSelective(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    public int deleteArticle(Integer articleId) {
        return articleMapper.updateToDelete(articleId);
    }

    public List<ArticleVo> articlesToVo(List<Article> articles){
        List<ArticleVo> articleVos = new ArrayList<>();
        for(Article article:articles){
            ArticleVo articleVo = new ArticleVo();
            //注入已有属性
            articleVo.setArticleId(article.getArticleId());
            articleVo.setArticleTitle(article.getArticleTitle());
            articleVo.setArticleComments(article.getArticleComments());
            articleVo.setArticleLikes(article.getArticleLikes());
            articleVo.setArticlePageviews(article.getArticlePageviews());
            articleVo.setArticleSummary(article.getArticleSummary());
            articleVo.setPublishdate(article.getPublishdate());
            //获取用户昵称
            articleVo.setUserNickname(userMapper.selectByPrimaryKey(article.getUserId()).getUserNickname());
            //获取文章标签
            List<String> tags = new ArrayList<>();
            List<Integer> tagIds = articleTagMapper.selectTagIdByArticleId(article.getArticleId());
            for (int tagId:tagIds){
                tags.add(tagMapper.selectByPrimaryKey(tagId).getTagName());
            }
            articleVo.setTags(tags);


            articleVos.add(articleVo);
        }

        return articleVos;
    }
}
