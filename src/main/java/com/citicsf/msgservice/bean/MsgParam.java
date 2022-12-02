package com.citicsf.msgservice.bean;

import java.util.Map;

public class MsgParam{

    private String receiver;

    private Map<String, String> variables;

    public MsgParam() {
    }

    public MsgParam(String receiver) {
        this.receiver = receiver;
    }

    public MsgParam(String receiver, Map<String, String> variables) {
        this.receiver = receiver;
        this.variables = variables;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Map<String, String> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, String> variables) {
        this.variables = variables;
    }


}
