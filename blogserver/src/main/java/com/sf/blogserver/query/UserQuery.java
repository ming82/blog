package com.sf.blogserver.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQuery {
    Integer userId;

    String permit;

    Integer pageNum;

    Integer pageSize;

    String userName;

    String userNickname;

    Integer userStatus;
}
