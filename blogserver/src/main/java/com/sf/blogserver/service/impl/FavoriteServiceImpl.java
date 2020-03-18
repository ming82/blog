package com.sf.blogserver.service.impl;

import com.sf.blogserver.bean.Article;
import com.sf.blogserver.bean.Favorite;
import com.sf.blogserver.mapper.*;
import com.sf.blogserver.service.FavoriteService;
import com.sf.blogserver.vo.ArticleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    FavoriteMapper favoriteMapper;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ArticleTagMapper articleTagMapper;
    @Autowired
    TagMapper tagMapper;

    @Override
    public int insert(Favorite favorite) {
        favorite.setFavoriteDate(new Date());
        articleMapper.increaseFavorite(favorite.getArticleId());
        return favoriteMapper.insertSelective(favorite);
    }

    @Override
    public Favorite isFavorited(Favorite favorite) {
        return favoriteMapper.selectByAidUid(favorite);
    }

    @Override
    public int cancel(Favorite favorite) {
        Favorite favorite1 = favoriteMapper.selectByAidUid(favorite);
        favorite1.setIsValid(0);
        articleMapper.decreaseFavorite(favorite.getArticleId());
        return favoriteMapper.updateByPrimaryKeySelective(favorite1);
    }

    @Override
    public List<ArticleVo> favoriteArticle(Integer userId) {
        List<ArticleVo> articleVos = new ArrayList<>();
        for(Integer articleId: favoriteMapper.selectByUid(userId)){
            Article article = articleMapper.selectByPrimaryKey(articleId);
            if(article.getArticleStatus() == 1){
                ArticleVo articleVo = new ArticleVo();
                //注入已有属性
                BeanUtils.copyProperties(article,articleVo);
                //获取用户昵称
                articleVo.setUserNickname(userMapper.selectByPrimaryKey(article.getUserId()).getUserNickname());
                //获取文章标签
                List<String> tags = new ArrayList<>();
                List<Integer> tagIds = articleTagMapper.selectTagIdByArticleId(article.getArticleId());
                for (int tagId : tagIds) {
                    tags.add(tagMapper.selectByPrimaryKey(tagId).getTagName());
                }
                articleVo.setTags(tags);
                //加入集合
                articleVos.add(articleVo);
            }
        }
        return articleVos;
    }
}
