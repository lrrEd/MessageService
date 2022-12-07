package com.citicsf.msgservice.exception;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDefinedException extends RuntimeException{

    private int errorCode;
    private String errorMsg;

}
