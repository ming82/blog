package com.sf.blogserver.service;

import com.sf.blogserver.bean.Favorite;
import com.sf.blogserver.vo.ArticleVo;

import java.util.List;

public interface FavoriteService {
    int insert(Favorite favorite);

    Favorite isFavorited(Favorite favorite);

    int cancel(Favorite favorite);

    List<ArticleVo> favoriteArticle(Integer userId);
}
