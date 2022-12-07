package com.citicsf.msgservice.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SendParam{

    /**
     * templateId
     */
    private String templateId;

    /**
     * msgParam
     */
    private MsgParam msgParam;

//    public SendParam() {
//    }

}
