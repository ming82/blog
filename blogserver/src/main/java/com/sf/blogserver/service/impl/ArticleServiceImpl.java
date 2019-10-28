package com.sf.blogserver.service.impl;

import com.sf.blogserver.bean.Article;
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
    public List<ArticleVo> selectAllArticle() {
        List<ArticleVo> articleVos = new ArrayList<>();
        for(Article article:articleMapper.selectAll()){
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

    @Override
    public List<Article> selectArticlesByCategoryId(Integer categoryId) {

        return articleMapper.selectByCategoryId(categoryId);
    }

    @Override
    public Article selectArticleByPrimaryKey(Integer articleId) {

        return articleMapper.selectByPrimaryKey(articleId);
    }

    @Override
    public int addNewArticle(Article article) {
        article.setPublishdate(new Date());
        //截取文章
        String stripHtml = article.getMdcontent();
        article.setArticleSummary(stripHtml.substring(0, stripHtml.length() > 50 ? 50 : stripHtml.length()));
        return articleMapper.insertSelective(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateByPrimaryKey(article);
    }

    @Override
    public int deleteArticle(Integer articleId) {

        return articleMapper.deleteByPrimaryKey(articleId);
    }
}
