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
        this.resMsg = resMsg;
    }

    public static ResponceUtil success(String resMsg,Object obj){
        return new ResponceUtil("success",resMsg,obj);
    }

    public static ResponceUtil success(String resMsg){
        return new ResponceUtil("success",resMsg);
    }

    public static ResponceUtil fail(String resMsg){
        return new ResponceUtil("error",resMsg);
    }
}
