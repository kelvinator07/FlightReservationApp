package com.geekykel.flightreservation.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by GeekyKel on 5/28/2019
 */
@Component
public class EmailUtil {

    public static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

    @Value("${com.geekykel.flightreservation.itinerary.email.subject}")
    private String EMAIL_SUBJECT;

    @Value("${com.geekykel.flightreservation.itinerary.email.body}")
    private String EMAIL_BODY;

    @Autowired
    private JavaMailSender sender;

    public void sendItinerary(String toAddress, String filepath) {

        MimeMessage message = sender.createMimeMessage();

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(toAddress);
            messageHelper.setSubject(EMAIL_SUBJECT);
            messageHelper.setText(EMAIL_BODY);
            messageHelper.addAttachment("Itinerary", new File(filepath));
            sender.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
