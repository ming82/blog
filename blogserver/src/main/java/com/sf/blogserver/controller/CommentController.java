package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Comment;
import com.sf.blogserver.service.CommentService;
import com.sf.blogserver.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/common/getByArticleId")
    public ResponseUtil getCommentByArticleId(Integer articleId){
        return ResponseUtil.success("查询成功",commentService.getCommentByArticleId(articleId));
    }

    @GetMapping("/common/getByAnswerId")
    public ResponseUtil getCommentByAnswerId(Integer answerId){
        return ResponseUtil.success("查询成功",commentService.getCommentByAnswerId(answerId));
    }

    @DeleteMapping("/{commentId}")
    public ResponseUtil deleteComment(@PathVariable Integer commentId){
        int result = commentService.deleteComment(commentId);
        if (result == 1) {
            return ResponseUtil.success("评论删除成功");
        } else {
            return ResponseUtil.fail("评论删除失败");
        }
    }

    @PostMapping("/")
    public ResponseUtil addNewComment(@RequestBody Comment comment){
        int result = commentService.addNewComment(comment);
        if (result == 1) {
            return ResponseUtil.success("评论成功");
        } else {
            return ResponseUtil.fail("评论失败");
        }
    }
}
