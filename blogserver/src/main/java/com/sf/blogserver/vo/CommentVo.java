package com.sf.blogserver.vo;

import com.sf.blogserver.bean.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


/**
 * @author 92802
 * @date 2019/10/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVo {
    private Integer commentId;

    private Integer articleId;

    private Integer answerId;

    private String commentBody;

    private Date publishdate;

    private Integer userId;

    private String userNickname;

    private List<CommentAnswerVo> commentAnswers;
}
