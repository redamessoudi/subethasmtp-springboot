package com.redamessoudi.emailsreceiver.models;

import javax.activation.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple model to handle the received emails
 *
 * @author Reda Messoudi
 */
public class ReceivedEmail {

    private String subject;
    private String senderAddress;
    private String senderName;
    private String recipientAddress;
    private String recipientName;
    private String cc;
    private String bcc;
    private String contentType;
    private List<DataSource> attachments = new ArrayList<>();

    public ReceivedEmail() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public List<DataSource> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<DataSource> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "ReceivedEmail{" +
                "subject='" + subject + '\'' +
                ", senderAddress='" + senderAddress + '\'' +
                ", senderName='" + senderName + '\'' +
                ", recipientAddress='" + recipientAddress + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", cc='" + cc + '\'' +
                ", bcc='" + bcc + '\'' +
                ", contentType='" + contentType + '\'' +
                ", attachments=" + attachments +
                '}';
    }
}
