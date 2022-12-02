package com.citicsf.msgservice.bean;

import java.util.List;

public class BatchSendParam {

    /**
     * templateId
     */
    private String templateId;

    /**
     * msgParam
     */
    private List<MsgParam> msgParam;

    public BatchSendParam(String templateId) {
        this.templateId = templateId;
    }

    public BatchSendParam(String templateId, List<MsgParam> msgParam) {
        this.templateId = templateId;
        this.msgParam = msgParam;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public List<MsgParam> getMsgParam() {
        return msgParam;
    }

    public void setMsgParam(List<MsgParam> msgParam) {
        this.msgParam = msgParam;
    }
}
