package com.redamessoudi.emailsreceiver.configuration;

import org.springframework.context.annotation.Configuration;
import org.subethamail.smtp.auth.EasyAuthenticationHandlerFactory;
import org.subethamail.smtp.auth.UsernamePasswordValidator;
import org.subethamail.smtp.helper.SimpleMessageListener;
import org.subethamail.smtp.server.SMTPServer;

/**
 * Custom configuration of SubEtha SMTPServer
 *
 * @author Reda Messoudi
 */
@Configuration
public class SMTPServerConfig {

    private final SMTPServer smtpServer;
    private final SimpleMessageListener marketingMsgListener;
    private final UsernamePasswordValidator authValidator;
    private final EasyAuthenticationHandlerFactory easyAuth;

    public SMTPServerConfig(SimpleMessageListener marketingMsgListener) {
        authValidator = new SimpleAuthValidatorImpl();
        easyAuth = new EasyAuthenticationHandlerFactory(authValidator);
        this.marketingMsgListener = marketingMsgListener;

        this.smtpServer = SMTPServer
                .port(25000)
                .simpleMessageListener(this.marketingMsgListener)
                .requireAuth(true)
                .authenticationHandlerFactory(easyAuth)
                .build();

        this.smtpServer.start();
    }
}
