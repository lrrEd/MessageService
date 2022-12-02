package com.citicsf.msgservice.service;

import com.citicsf.msgservice.SendService;
import com.citicsf.msgservice.bean.BatchSendParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BatchSendParamService {

    @Autowired
    private SendService sendService;

    public String bacthSend(BatchSendParam batchSendParam){
        if(checkValidation(batchSendParam)==-1){
            return "invalid input!!";
        }
        sendService.batchSend(batchSendParam); //调用SendServiceAPI的接口
        return "Batch send successfully";
    }

    public int checkValidation(BatchSendParam batchSendParam){
        if(batchSendParam.getTemplateId()==null ||
                batchSendParam.getMsgParam()==null ||
                batchSendParam.getMsgParam().size()<1)
            return -1;

        return 0;
    }
}
