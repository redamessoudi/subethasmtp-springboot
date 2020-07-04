package com.redamessoudi.emailsreceiver.services;

import com.redamessoudi.emailsreceiver.models.ReceivedEmail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.InputStream;

/**
 * Service to process the received data and convert it to ReceivedEmail
 *
 * @author Reda Messoudi
 */
public interface EmailContentService {

    MimeMessage convertToMimeMessage(InputStream data) throws MessagingException;
    ReceivedEmail extractReceivedEmail(InputStream data) throws Exception;

}
