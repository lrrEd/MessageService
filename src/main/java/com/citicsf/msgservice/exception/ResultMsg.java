package com.citicsf.msgservice.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResultMsg<T> {
    private boolean result;
    private int code;
    private String msg;
    private T data;

    public ResultMsg(boolean result, int code, String msg, T data){
        this.result = result;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
