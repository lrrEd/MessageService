package com.citicsf.msgservice.sendmsg;

import com.citicsf.msgservice.bean.MessageSendLog;
import com.citicsf.msgservice.bean.SendParam;
import com.citicsf.msgservice.repository.MessageSendLogRepository;
import com.citicsf.msgservice.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


@Slf4j
public class SendEmail {

    private static JavaMailSender javaMailSender = SpringUtils.getBean(JavaMailSender.class);

    private static MessageSendLogRepository messageSendLogRepository = SpringUtils.getBean("messageSendLogRepository");

    private static String from = "lrr_nk@163.com";

    // define the format of timestamp
    private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void send(SendParam sendParam) throws UnsupportedEncodingException {


        String templateId = sendParam.getTemplateId();
        String[] receivers = sendParam.getMsgParam().getReceiver().split(",");
        Map<String, String> map = sendParam.getMsgParam().getVariables();
        String text = map.get("text");
        String subject = map.get("subject");
        String fromName = map.get("fromName");

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        String fromByte = new String((fromName + " <" + from + ">").getBytes("UTF-8"));
        simpleMailMessage.setFrom(fromByte);

        for(String receiver:receivers){

            MessageSendLog messageSendLog = new MessageSendLog();
            messageSendLog.setUmpId(templateId);
            messageSendLog.setDate(new Date());
            messageSendLog.setText(text);
            messageSendLog.setTimestamp(df.format(new Date()));
            messageSendLog.setReceiver(receiver);
            messageSendLog.setSender(from);

            if (!receiver.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
                log.error("invalid email address: "+receiver);
                // 记录异常
                messageSendLog.setState("0");
                messageSendLog.setException("invalid email address: "+receiver);
                messageSendLogRepository.save(messageSendLog);
                continue;

            }
            try{
                simpleMailMessage.setTo(receiver);
                simpleMailMessage.setText(text);
                simpleMailMessage.setSubject(subject);
                messageSendLog.setState("1");
                javaMailSender.send(simpleMailMessage);
                log.info("send email to "+receiver);
            }catch(MailException e){
                //记录异常
                log.error(e.getMessage());
                messageSendLog.setState("0");
                messageSendLog.setException(e.getMessage());
            }finally {
                messageSendLogRepository.save(messageSendLog);
            }
        }

    }

}
