package com.redamessoudi.emailsreceiver.services;

import com.redamessoudi.emailsreceiver.models.ReceivedEmail;
import org.apache.commons.mail.util.MimeMessageParser;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.InputStream;
import java.util.Properties;

/**
 * Here is an implementation of EmailContentService
 *
 * @author Reda Messoudi
 */
@Service
public class EmailContentServiceImpl implements EmailContentService {

    public EmailContentServiceImpl() {
    }

    @Override
    public MimeMessage convertToMimeMessage(InputStream data) throws MessagingException {
        Session session = Session.getDefaultInstance(new Properties());
        try {
            return new MimeMessage(session, data);
        } catch (MessagingException e) {
            throw new MessagingException();
        }
    }

    @Override
    public ReceivedEmail extractReceivedEmail(InputStream data) throws Exception {
        ReceivedEmail receivedEmail = new ReceivedEmail();
        MimeMessage message;
        try {
            message = this.convertToMimeMessage(data);
            receivedEmail.setSubject(message.getSubject());
            receivedEmail.setSenderAddress(InternetAddress.toString(message.getFrom()));
            InternetAddress[] recipientAddresses = InternetAddress.parse(InternetAddress.toString(message.getAllRecipients()));
            receivedEmail.setRecipientAddress(InternetAddress.toString(recipientAddresses));
            receivedEmail.setRecipientName(recipientAddresses[0].getPersonal());
            receivedEmail.setContentType(message.getContentType());
            // Use here Apache library for parsing
            MimeMessageParser messageParser = new MimeMessageParser(message);
            messageParser.parse(); // very important to parse before getting data
            receivedEmail.setCc(messageParser.getCc().toString());
            receivedEmail.setBcc(messageParser.getBcc().toString());
            receivedEmail.setAttachments(messageParser.getAttachmentList());
            System.out.println(receivedEmail);
            return receivedEmail;
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
