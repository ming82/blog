package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Article;
import com.sf.blogserver.bean.Tag;
import com.sf.blogserver.service.ArticleService;
import com.sf.blogserver.util.ResponseUtil;
import com.sf.blogserver.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 92802
 * @date 2019/10/31
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/getAll")
    public ResponseUtil getAllArticles(){
        return ResponseUtil.success("查询成功",articleService.getAllArticle());
    }

    @GetMapping("/getHots")
    public ResponseUtil getHotArticles(){
        return ResponseUtil.success("查询成功",articleService.getHotArticles());
    }

    @GetMapping("/getNews")
    public ResponseUtil getNewArticles(){
        return ResponseUtil.success("查询成功",articleService.getNewArticles());
    }

    @GetMapping("/getByCategoryId")
    public ResponseUtil getArticlesByCategoryId(Integer categoryId){
        return ResponseUtil.success("查询成功",articleService.getArticlesByCategoryId(categoryId));
    }

    @GetMapping("/like")
    public ResponseUtil likeArticle(Integer articleId, Integer userId){
        System.out.println(articleId);
        System.out.println(userId);
        return ResponseUtil.success("已点赞",articleService.likeArticle(articleId,userId));
    }

    @GetMapping("/getByUserId")
    public ResponseUtil getArticlesByUserId(Integer userId){
        return ResponseUtil.success("查询成功",articleService.getArticlesByUserId(userId));
    }

    @GetMapping("/getDrafts")
    public ResponseUtil getDrafts(Integer userId){
        return ResponseUtil.success("查询成功",articleService.getDraft(userId));
    }

    @GetMapping("/{articleId}")
    public ResponseUtil getArticleById(@PathVariable Integer articleId){
        return ResponseUtil.success("查询成功", articleService.getArticleById(articleId));
    }

    @PostMapping("/")
    public ResponseUtil addNewArticle(@RequestBody ArticleVo article){
        int result = articleService.addNewArticle(article);
        if (result == 1) {
            return ResponseUtil.success("文章发表成功");
        } else {
            return ResponseUtil.fail("文章发表失败");
        }
    }

    @PutMapping("/")
    public ResponseUtil editArticle(Article article){
        int result = articleService.updateArticle(article);
        if (result == 1) {
            return ResponseUtil.success("文章更新成功");
        } else {
            return ResponseUtil.fail("文章更新失败");
        }
    }

    @DeleteMapping("/{articleId}")
    public ResponseUtil deleteArticle(@PathVariable Integer articleId){
        int result = articleService.deleteArticle(articleId);
        if (result == 1) {
            return ResponseUtil.success("文章删除成功");
        } else {
            return ResponseUtil.fail("文章删除失败");
        }
    }
}
