package com.sf.blogserver.util;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponceUtil {
    private String status;
    private String resMsg;
    private Object data;


    ResponceUtil(String status,String resMsg){
        this.status = status;
        this.status = resMsg;
    }

    public static ResponceUtil success(String resMsg,Object obj){
        return new ResponceUtil("200",resMsg,obj);
    }

    public static ResponceUtil fail(String resMsg){
        return new ResponceUtil("400",resMsg);
    }
}
