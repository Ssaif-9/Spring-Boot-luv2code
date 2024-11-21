package com.luv2code.springboot.banking.servicr;

import com.luv2code.springboot.banking.dto.EmailDetail;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImp implements EmailService {

    @Value("${spring.mail.username}")
    private String senderEmail;

    private final JavaMailSender javaMailSender;

    @Override
    public void sendEmailAlert(EmailDetail emailDetail) {
        try{
            SimpleMailMessage mailMessage =new SimpleMailMessage();
            mailMessage.setFrom(senderEmail);
            mailMessage.setTo(emailDetail.getRecipient());
            mailMessage.setSubject(emailDetail.getMessageSubject());
            mailMessage.setText(emailDetail.getMessageBody());

            javaMailSender.send(mailMessage);
            System.out.println("Mail sent successfully\n");
        }catch(MailException e){
            throw new RuntimeException(e);
        }
    }
}

