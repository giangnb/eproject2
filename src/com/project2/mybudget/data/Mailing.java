/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.data;

import com.project2.mybudget.exception.AppException;
import com.project2.mybudget.exception.ExceptionViewer;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Send email (using default sender credential)
 * @author Giang
 */
public class Mailing extends Thread {

    private String to;
    private String subject;
    private String content;

    public Mailing(String to) {
        this.to = to;

    }

    public Mailing(String to, String subject) {
        this.to = to;
        this.subject = subject;
    }

    public Mailing(String to, String subject, String content) {
        this.to = to;
        this.subject = subject;
        setContent(new StringBuilder(content));
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    /**
     * Add email footer to content
     * @param content 
     */
    public final void setContent(StringBuilder content) {
        content.append("<br/><br/>");
        content.append("<div style='background: rgba(255, 177, 74, 60); color:#000000; padding: 20px 15px'>");
        content.append("<h3>MyBudget developers</h3>");
        content.append("<p>Website: <b>http://giangnb.com</b><br/>Email: <b>mybudget@giangnb.com</b></p>");
        content.append("<p>Thanks for using our software!</p>");
        content.append("</div>");
        this.content = content.toString();
    }
    
    public final void setContent(String content) {
        setContent(new StringBuilder(content));
    }

    @Override
    public void run() {
        send();
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    /**
     * Send email
     */
    private void send() {
        // Sender's email ID needs to be mentioned
        String from = "MyBudget Service <mybudget@giangnb.com>";
        final String username = "mybudget@giangnb.com";//change accordingly
        final String password = "giangnb22";//change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "smtp.yandex.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject(subject == null ? "No subject" : subject);

            // Send the actual HTML message, as big as you like
            message.setContent(
                    content == null ? "<b><i>Message has no content</i></b>" : content,
                    "text/html");

            // Send message
            Transport.send(message);
        } catch (MessagingException e) {
            ExceptionViewer.view(new AppException("Error while sending email", e));
        }
    }

//    public static void main(String[] args) {
//        new Mailing("giangnb@giangnb.com", "This is subject", "Blah blah<br/>Test Email.").start();
//        System.out.println("haha");
//    }
}
