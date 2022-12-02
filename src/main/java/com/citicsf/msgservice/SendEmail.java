package com.citicsf.msgservice;

import com.citicsf.msgservice.bean.MessageSendLog;
import com.citicsf.msgservice.bean.SendParam;
import com.citicsf.msgservice.repository.MessageSendLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


@Component
public class SendEmail {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MessageSendLogRepository messageSendLogRepository;

    // define the format of timestamp
    private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void send(SendParam sendParam){


        String templateId = sendParam.getTemplateId();
        String[] receivers = sendParam.getMsgParam().getReceiver().split(",");
        Map<String, String> map = sendParam.getMsgParam().getVariables();
        String from = map.get("from");
        String text = map.get("text");
        String subject = map.get("subject");

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();


        for(String receiver:receivers){

            MessageSendLog messageSendLog = new MessageSendLog();
            messageSendLog.setUmpId(templateId);
            messageSendLog.setDate(new Date());
            messageSendLog.setText(text);
            messageSendLog.setTimestamp(df.format(new Date()));
            messageSendLog.setReceiver(receiver);
            messageSendLog.setSender(from);

            if (!receiver.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {

                // 记录异常
                System.out.println("invalid email address-"+receiver);
                messageSendLog.setState("0");
                messageSendLog.setException("invalid email address: "+receiver);
                messageSendLogRepository.save(messageSendLog);
                continue;

            }
            try{
                simpleMailMessage.setFrom(from);
                simpleMailMessage.setTo(receiver);
                simpleMailMessage.setText(text);
                simpleMailMessage.setSubject(subject);
                messageSendLog.setState("1");
                javaMailSender.send(simpleMailMessage);
            }catch(MailException e){
                //记录异常
                e.printStackTrace();
                messageSendLog.setState("0");
                messageSendLog.setException(e.getMessage());
            }finally {
                messageSendLogRepository.save(messageSendLog);
            }
        }

    }








}
