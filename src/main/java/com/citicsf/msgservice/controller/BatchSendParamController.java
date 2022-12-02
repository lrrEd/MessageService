package com.citicsf.msgservice.controller;

import com.citicsf.msgservice.bean.BatchSendParam;
import com.citicsf.msgservice.service.BatchSendParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/batchSend")
public class BatchSendParamController {

    @Autowired
    private BatchSendParamService batchSendParamService;


    @PostMapping(produces = "application/json;charset=UTF-8")
    public String batchSend(@RequestBody BatchSendParam batchSendParam){
        return batchSendParamService.bacthSend(batchSendParam);
    }

}
