package com.sf.blogserver.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 92802
 * @date 2019/11/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerVo {
    private Integer answerId;

    private String mdcontent;

    private String htmlcontent;

    private Integer issueId;

    private Integer userId;

    private String userPicture;

    private Date publishdate;

    private String userNickname;
}
