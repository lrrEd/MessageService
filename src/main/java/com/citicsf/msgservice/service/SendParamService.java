package com.citicsf.msgservice.service;

import com.citicsf.msgservice.SendService;
import com.citicsf.msgservice.bean.SendParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendParamService {

    @Autowired
    private SendService sendService;

    public String send(SendParam sendParam){

        if(checkValidation(sendParam)==-1) return "wrong input";
        sendService.send(sendParam); //调用SendServiceAPI的接口
        return "send message successfully";

    }

    public int checkValidation(SendParam sendParam){
        if(sendParam.getTemplateId()==null || sendParam.getTemplateId().length()==0){
            return -1;
        }
        if(sendParam.getMsgParam().getReceiver()==null || sendParam.getMsgParam().getReceiver().length()==0){
            return -1;
        }
        if(sendParam.getMsgParam().getVariables()==null){
            return -1;
        }

        return 0;
    }


}
