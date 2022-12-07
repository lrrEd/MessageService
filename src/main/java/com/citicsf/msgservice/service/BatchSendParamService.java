package com.citicsf.msgservice.service;

import com.citicsf.msgservice.exception.ErrorCode;
import com.citicsf.msgservice.exception.UserDefinedException;
import com.citicsf.msgservice.sendmsg.SendService;
import com.citicsf.msgservice.bean.BatchSendParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class BatchSendParamService {

    @Autowired
    private SendService sendService;

    public void bacthSend(BatchSendParam batchSendParam){
        String res = checkValidation(batchSendParam);
        if(res!=null){
            throw new UserDefinedException(ErrorCode.INVALID_INPUT, res);
        }
        sendService.batchSend(batchSendParam); //调用SendServiceAPI的接口
    }

    public String checkValidation(BatchSendParam batchSendParam){
        if(batchSendParam.getTemplateId()==null || batchSendParam.getTemplateId().length()==0){
            log.error("wrong template id:");
            return "wrong template id";
        }


        if(batchSendParam.getMsgParam()==null ||
                batchSendParam.getMsgParam().size()<1){
            log.error("no msgParam");
            return "no msgParam";
        }

        return null;
    }
}
