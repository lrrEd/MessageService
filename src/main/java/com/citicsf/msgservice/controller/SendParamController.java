package com.citicsf.msgservice.controller;

import com.citicsf.msgservice.bean.SendParam;
import com.citicsf.msgservice.exception.ResponseHandler;
import com.citicsf.msgservice.exception.ResultMsg;
import com.citicsf.msgservice.service.SendParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/sendMsg")
public class SendParamController {

    @Autowired
    private SendParamService sendParamService;

    @Autowired
    private ResponseHandler responseHandler;

    @PostMapping(path="/send", produces = "application/json;charset=UTF-8")
    public ResultMsg send(@RequestBody SendParam sendParam){
        sendParamService.send(sendParam);
        return responseHandler.successResponse();
    }

}
