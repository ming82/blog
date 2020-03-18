package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.Favorite;

import java.util.List;

public interface    FavoriteMapper {
    int deleteByPrimaryKey(Integer favoriteId);

    int insert(Favorite record);

    int insertSelective(Favorite record);

    Favorite selectByPrimaryKey(Integer favoriteId);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);

    Favorite selectByAidUid(Favorite favorite);

    List<Integer> selectByUid(Integer userId);
}
