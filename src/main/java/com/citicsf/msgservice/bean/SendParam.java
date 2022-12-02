package com.citicsf.msgservice.bean;


public class SendParam{

    /**
     * templateId
     */
    private String templateId;

    /**
     * msgParam
     */
    private MsgParam msgParam;

    public SendParam() {
    }

    public SendParam(String templateId) {
        this.templateId = templateId;
    }

    public SendParam(String templateId, MsgParam msgParam) {
        this.templateId = templateId;
        this.msgParam = msgParam;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public MsgParam getMsgParam() {
        return msgParam;
    }

    public void setMsgParam(MsgParam msgParam) {
        this.msgParam = msgParam;
    }

}
