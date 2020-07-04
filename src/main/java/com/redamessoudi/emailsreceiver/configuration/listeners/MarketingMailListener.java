package com.redamessoudi.emailsreceiver.configuration.listeners;

import com.redamessoudi.emailsreceiver.services.EmailContentService;
import org.springframework.context.annotation.Configuration;
import org.subethamail.smtp.helper.SimpleMessageListener;

import java.io.InputStream;

/**
 * Here is an implementation of SimpleMessageListener.
 * Assume we accept only received emails sent to MARKETING department.
 *
 * @author Reda Messoudi
 */
@Configuration
public class MarketingMailListener implements SimpleMessageListener {

    private static final String MARKETING_DOMAIN = "@marketing.company.com";
    private final EmailContentService emailContentService;


    public MarketingMailListener(EmailContentService emailContentService) {
        this.emailContentService = emailContentService;
    }

    /**
     * Check if the received email is for this listener based on business logic (recipient email address)
     *
     * @param from is a the sender email address.
     * @param recipient is a the recipient email address.
     *
     * @return true if the recipient is an address of MARKETING department.
     */
    @Override
    public boolean accept(String from, String recipient) {
        System.out.println("Recipient : "+recipient);
        return recipient != null && recipient.endsWith(MARKETING_DOMAIN);
    }

    @Override
    public void deliver(String from, String recipient, InputStream data) {
        System.out.println("From : "+from);
        System.out.println("Recipient : "+recipient);
        try {
            emailContentService.extractReceivedEmail(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
