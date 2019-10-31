package com.sf.blogserver.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 92802
 * @date 2019/10/31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageVo {
    private Integer messageId;

    private Integer userId;

    private String userNickName;

    private Integer articleId;

    private Integer answerId;

    private Integer messageType;

    private Integer messageIsread;

    private Date publishdate;
}
