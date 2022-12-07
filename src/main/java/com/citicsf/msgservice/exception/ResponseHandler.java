package com.citicsf.msgservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class ResponseHandler {


    @ResponseStatus(HttpStatus.OK)
    public ResultMsg successResponse(){
        return new ResultMsg(true, ErrorCode.SUCCESS, "send message successfully", null);
    }


    @ExceptionHandler(UserDefinedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultMsg userExceptionResponse(Exception exception){
        return new ResultMsg(true, ((UserDefinedException)exception).getErrorCode(), ((UserDefinedException)exception).getErrorMsg(), null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultMsg systemExceptionResponse(Exception exception){
        if(exception instanceof UserDefinedException){
            return new ResultMsg(true, ((UserDefinedException)exception).getErrorCode(), ((UserDefinedException)exception).getErrorMsg(), null);
        }
        return new ResultMsg(true, ErrorCode.UNKNOWN_EXCEPTION, exception.getMessage(), null);
    }

}
