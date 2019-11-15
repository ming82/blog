package com.sf.blogserver.util;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUtil {
    private String status;
    private String resMsg;
    private Object data;


    ResponseUtil(String status, String resMsg){
        this.status = status;
        this.resMsg = resMsg;
    }

    ResponseUtil(String status, Object obj){
        this.status = status;
        this.data = obj;
    }

    public static ResponseUtil success(String resMsg, Object obj){
        return new ResponseUtil("success",resMsg,obj);
    }

    public static ResponseUtil success(String resMsg){
        return new ResponseUtil("success",resMsg);
    }

    public static ResponseUtil success(Object obj){return new ResponseUtil("success",obj);}

    public static ResponseUtil fail(String resMsg){
        return new ResponseUtil("error",resMsg);
    }
}
