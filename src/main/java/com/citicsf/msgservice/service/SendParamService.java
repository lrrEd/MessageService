package com.citicsf.msgservice.service;

import com.citicsf.msgservice.exception.ErrorCode;
import com.citicsf.msgservice.exception.UserDefinedException;
import com.citicsf.msgservice.sendmsg.SendService;
import com.citicsf.msgservice.bean.SendParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendParamService {

    @Autowired
    private SendService sendService;

    public void send(SendParam sendParam){

        String res = checkValidation(sendParam);

        if(res!=null) {
            throw new UserDefinedException(ErrorCode.INVALID_INPUT, res);
        }

        sendService.send(sendParam); //调用SendServiceAPI的接口

    }

    public String checkValidation(SendParam sendParam){
        if(sendParam.getTemplateId()==null || sendParam.getTemplateId().length()==0){
            return "wrong template id";
        }
        if(sendParam.getMsgParam().getReceiver()==null || sendParam.getMsgParam().getReceiver().length()==0){
            return "no receiver";
        }
        if(sendParam.getMsgParam().getVariables()==null){
            return "no variable";
        }
        return null;
    }


}
