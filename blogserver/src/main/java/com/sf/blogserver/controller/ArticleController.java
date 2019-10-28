package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Article;
import com.sf.blogserver.service.ArticleService;
import com.sf.blogserver.service.CommentService;
import com.sf.blogserver.util.ResponceUtil;
import com.sf.blogserver.vo.ArticleVo;
import com.sf.blogserver.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;

    @GetMapping("/test")
    public List<CommentVo> test(){
        return commentService.getCommentByArticleId(1);
    }

    @GetMapping("/selectAllArticle")
    public List<ArticleVo> selectAllArticle(){
        return articleService.selectAllArticle();
    }

    @PostMapping("/addNewArticle")
    public ResponceUtil addNewArticle(Article article){
        int result = articleService.addNewArticle(article);
        if (result == 1) {
            return ResponceUtil.success("文章发表成功",null);
        } else {
            return ResponceUtil.fail("文章发表失败");
        }
    }

    @PostMapping("/updateArticle")
    public ResponceUtil updateArticle(Article article){
        int result = articleService.updateArticle(article);
        if (result == 1) {
            return ResponceUtil.success("文章更新成功",null);
        } else {
            return ResponceUtil.fail("文章更新失败");
        }
    }

    @PostMapping("/deleteArticle")
    public ResponceUtil deleteArticle(Integer articleId){
        int result = articleService.deleteArticle(articleId);
        if (result == 1) {
            return ResponceUtil.success("文章删除成功",null);
        } else {
            return ResponceUtil.fail("文章删除失败");
        }
    }
}
