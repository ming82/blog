package com.sf.blogserver.vo;


import com.sf.blogserver.bean.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    private Integer userId;

    private String userName;

    private String userNickname;

    private String userPassword;

    private Integer userStatus;

    private String userEmail;

    private String userPicture;

    private Date userRegistetime;

    private String userSignature;

    private Integer likes;

    private Integer articleNum;

    private Integer issuesNum;

    private Integer answerNum;

    private List<Role> roles;

}
