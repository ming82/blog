package com.sf.blogserver.controller;


import com.sf.blogserver.bean.Favorite;
import com.sf.blogserver.mapper.FavoriteMapper;
import com.sf.blogserver.service.FavoriteService;
import com.sf.blogserver.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    @Autowired
    FavoriteService favoriteService;

    @PostMapping("/")
    public ResponseUtil addToFavorite(@RequestBody Favorite favorite){
        int result = favoriteService.insert(favorite);
        if (result == 1) {
            return ResponseUtil.success("已收藏");
        } else {
            return ResponseUtil.fail("收藏失败");
        }
    }

    @PostMapping("/favorited")
    public ResponseUtil isFavorited(@RequestBody Favorite favorite){
        Favorite favorited = favoriteService.isFavorited(favorite);
        if(favorited == null){
            return ResponseUtil.fail("未收藏");
        }else {
            return ResponseUtil.success("已收藏");
        }
    }
    @PostMapping("/cancel")
    public ResponseUtil cancel(@RequestBody Favorite favorite){
        int res = favoriteService.cancel(favorite);
        if(res == 1){
            return ResponseUtil.success("已取消收藏");
        }else {
            return ResponseUtil.fail("取消失败");
        }
    }

    @GetMapping("/getFavorite")
    public ResponseUtil getFavorite(Integer userId){
        return ResponseUtil.success("查询成功",favoriteService.favoriteArticle(userId));
    }
}
