package com.llx.summer.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: sharps
 * @Date: 19-4-1 16:52
 * @Description:
 */
@Getter
@Setter
//创建统一的JSON返回对象
public class ErrorInfo<T> {
    public static final Integer OK=0;
    public static final Integer ERROR=100;

    //消息类型
    private Integer code;
    //消息内容
    private String message;
    //请求的url
    private String url;
    //请求返回的数据
    private T data;

}
