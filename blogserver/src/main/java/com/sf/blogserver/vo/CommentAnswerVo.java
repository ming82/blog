package com.sf.blogserver.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentAnswerVo {

    private String commentBody;

    private Date publishdate;

    private String commentParentUserNickname;

    private String userNickname;
}
