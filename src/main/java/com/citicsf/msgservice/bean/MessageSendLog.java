package com.citicsf.msgservice.bean;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Data
public class MessageSendLog implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String umpId;
    /**
     * Date
     */
    private Date date;
    /**
     * sender
     */
    private String sender;
    /**
     * receiver
     */
    private String receiver;
    /**
     * timestamp
     */
    private String timestamp;
    /**
     * text
     */
    private String text;
    /**
     * state: 0 false 1 success
     */
    private String state;
    /**
     * reason of failure
     */
    private String exception;

}
