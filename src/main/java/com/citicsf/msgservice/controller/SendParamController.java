package com.citicsf.msgservice.controller;

import com.citicsf.msgservice.bean.SendParam;
import com.citicsf.msgservice.service.SendParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/send")
public class SendParamController {

    @Autowired
    private SendParamService sendParamService;

    @PostMapping(produces = "application/json;charset=UTF-8")
    public String send(@RequestBody SendParam sendParam){
        return sendParamService.send(sendParam);
    }

}
