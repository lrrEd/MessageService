package com.citicsf.msgservice.controller;

import com.citicsf.msgservice.bean.BatchSendParam;
import com.citicsf.msgservice.exception.ResponseHandler;
import com.citicsf.msgservice.exception.ResultMsg;
import com.citicsf.msgservice.service.BatchSendParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/sendMsg")
public class BatchSendParamController {

    @Autowired
    private BatchSendParamService batchSendParamService;

    @Autowired
    private ResponseHandler responseHandler;

    @PostMapping(path="/batchSend", produces = "application/json;charset=UTF-8")
    public ResultMsg batchSend(@RequestBody BatchSendParam batchSendParam){
        batchSendParamService.bacthSend(batchSendParam);
        return responseHandler.successResponse();
    }

}
