package com.sf.blogserver.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


/**
 * @author 92802
 * @date 2019/10/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentAnswerVo {
    private Integer commentId;

    private String commentBody;

    private Date publishdate;

    private Integer userId;

    private String userNickname;

    private String commentTo;

    private Integer commentToUserId;

    private String userPicture;
}
