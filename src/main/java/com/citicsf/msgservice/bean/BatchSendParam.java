package com.citicsf.msgservice.bean;

import lombok.Data;

import java.util.List;

@Data
public class BatchSendParam {

    /**
     * templateId
     */
    private String templateId;

    /**
     * msgParam
     */
    private List<MsgParam> msgParam;

}
