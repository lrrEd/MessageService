package com.citicsf.msgservice.bean;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
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

    public String getUmpId() {
        return umpId;
    }

    public void setUmpId(String umpId) {
        this.umpId = umpId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
