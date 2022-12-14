package com.citicsf.msgservice.sendmsg;

import com.citicsf.msgservice.bean.BatchSendParam;
import com.citicsf.msgservice.bean.SendParam;

public interface SendService {

    void send(SendParam sendParam);

    void batchSend(BatchSendParam sendParam);
}
