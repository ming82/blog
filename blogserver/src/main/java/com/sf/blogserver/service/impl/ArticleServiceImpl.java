package com.sf.blogserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sf.blogserver.query.ArticleQuery;
import com.sf.blogserver.bean.Article;
import com.sf.blogserver.bean.ArticleTag;
import com.sf.blogserver.bean.Message;
import com.sf.blogserver.bean.User;
import com.sf.blogserver.mapper.*;
import com.sf.blogserver.service.ArticleService;
import com.sf.blogserver.vo.ArticleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    MessageMapper messageMapper;

    @Deprecated
    CategoryMapper categoryMapper;
    @Value("${image_url}")
    String IMAGE_URL;

    @Override
    public PageInfo getArticles(ArticleQuery query) {
        if(query.getUserId() == null&&query.getUserNickname() != null&&query.getUserNickname() != ""){
            User user = userMapper.selectByUserNickname(query.getUserNickname());
            if(user == null){
                return new PageInfo();
            }else {
                query.setUserId(user.getUserId());
            }
        }
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        List<Article> articles = articleMapper.selectByQuery(query);
        List<ArticleVo> articleVos = new ArrayList<>();
        PageInfo pageInfo = new PageInfo<>(articles);
        for (Article article : articles) {
            articleVos.add(articleToVo(article));
        }
        pageInfo.setList(articleVos);
        return pageInfo;
    }

    @Override
    public List<ArticleVo> getArticlesByCategoryId(Integer categoryId) {
        List<ArticleVo> articleVos = new ArrayList<>();
        for (Article article : articleMapper.selectByCategoryId(categoryId)) {
            articleVos.add(articleToVo(article));
        }
        return articleVos;
    }

    @Override
    public List<ArticleVo> getHotArticles() {
        List<ArticleVo> articleVos = new ArrayList<>();
        for (Article article : articleMapper.getHotArticles()) {
            articleVos.add(articleToVo(article));
        }
        return articleVos;
    }

    @Override
    public List<ArticleVo> getNewArticles() {
        List<ArticleVo> articleVos = new ArrayList<>();
        for (Article article : articleMapper.getNewArticles()) {
            articleVos.add(articleToVo(article));
        }
        return articleVos;
    }

    @Override
    public List<ArticleVo> getArticlesByUserId(Integer userId) {
        List<ArticleVo> articleVos = new ArrayList<>();
        for (Article article : articleMapper.selectByUserId(userId)) {
            articleVos.add(articleToVo(article));
        }
        return articleVos;
    }

    @Override
    public ArticleVo getArticleById(Integer articleId) {
        //增加浏览量
        articleMapper.increasePageview(articleId);
        return articleToVo(articleMapper.selectByPrimaryKey(articleId));
    }

    @Transactional
    @Override
    public int likeArticle(Integer articleId, Integer userId) {
        Message message = new Message();
        message.setArticleId(articleId);
        message.setCommentuserid(userId);
        message.setUserId(articleMapper.selectByPrimaryKey(articleId).getUserId());
        message.setMessageType(1);
        message.setPublishdate(new Date());
        messageMapper.insertSelective(message);
        return articleMapper.increaseLike(articleId);
    }

    @Override
    public int addNewArticle(ArticleVo article) {
        //设置日期
        Date date = new Date();
        article.setPublishdate(date);
        article.setEdittime(date);
        //截取文章
        String stripHtml = stripHtml(article.getHtmlcontent());
        article.setArticleSummary(stripHtml.substring(0, stripHtml.length() > 50 ? 50 : stripHtml.length()));

        int ret = articleMapper.insertSelective(article);
        //建立标签关联
        for (String tagName : article.getTags()) {
            ArticleTag articleTag = new ArticleTag();
            articleTag.setArticleId(article.getArticleId());
            articleTag.setTagId(tagMapper.selectIdByName(tagName));

            articleTagMapper.insertSelective(articleTag);
        }
        return ret;
    }

    public String stripHtml(String content) {
        content = content.replaceAll("<p .*?>", "");
        content = content.replaceAll("<br\\s*/?>", "");
        content = content.replaceAll("\\<.*?>", "");
        return content;
    }

    @Override
    public int updateArticle(ArticleVo article) {
        //设置编辑日期
        Date date = new Date();
        article.setEdittime(date);
        //截取文章
        String stripHtml = stripHtml(article.getHtmlcontent());
        article.setArticleSummary(stripHtml.substring(0, stripHtml.length() > 50 ? 50 : stripHtml.length()));

        int ret = articleMapper.updateByPrimaryKeySelective(article);
        //修改标签关联
        List<ArticleTag> articleTagsOld = articleTagMapper.selectByAid(article.getArticleId());
        for (String tagName : article.getTags()) {
            ArticleTag articleTag = articleTagMapper.selectByAidTid(article.getArticleId(),tagMapper.selectIdByName(tagName));
            if(articleTag == null){
                //如果是新增的关联
                ArticleTag articleTagN = new ArticleTag();
                articleTagN.setArticleId(article.getArticleId());
                articleTagN.setTagId(tagMapper.selectIdByName(tagName));

                articleTagMapper.insertSelective(articleTagN);
            }else {
                //如果是原有的关联
                articleTagsOld.remove(articleTag);
            }
        }
        // 移除删除的关联
        for(ArticleTag articleTag: articleTagsOld){
            articleTagMapper.deleteByPrimaryKey(articleTag.getId());
        }
        return ret;
    }

    @Override
    public int deleteArticle(Integer articleId) {
        return articleMapper.updateToDelete(articleId);
    }

    @Override
    public List<ArticleVo> getDraft(Integer userId) {
        List<ArticleVo> articleVos = new ArrayList<>();
        for (Article article : articleMapper.getDraft(userId)) {
            articleVos.add(articleToVo(article));
        }
        return articleVos;
    }

    @Override
    public List<ArticleVo> searchArticle(String keyword) {
        return null;
    }

    public ArticleVo articleToVo(Article article) {
        ArticleVo articleVo = new ArticleVo();
        //注入已有属性
        BeanUtils.copyProperties(article,articleVo);
        //获取用户昵称,头像
        User user = userMapper.selectByPrimaryKey(article.getUserId());
        articleVo.setUserNickname(user.getUserNickname());
        articleVo.setUserPicture(IMAGE_URL+user.getUserPicture());
        //获取文章标签
        List<String> tags = new ArrayList<>();
        List<Integer> tagIds = articleTagMapper.selectTagIdByArticleId(article.getArticleId());
        for (int tagId : tagIds) {
            tags.add(tagMapper.selectByPrimaryKey(tagId).getTagName());
        }
        articleVo.setTags(tags);

        return articleVo;
    }
}
