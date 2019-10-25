package com.sf.blogserver.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVo {

    private String commentBody;

    private Date publishdate;

    private String commentParentUserNickname;

    private String userNickname;
}
