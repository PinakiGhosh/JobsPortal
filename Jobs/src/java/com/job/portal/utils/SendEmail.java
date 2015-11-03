/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.utils;

/**
 *
 * @author 711638
 */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

    public static boolean sendMail(String sendTo, String sub, String msg) {
        boolean flag = false;
        try {
            Properties prop = new Properties();
            prop.load(SendEmail.class.getResourceAsStream("/mail.properties"));
            final String uname = prop.getProperty("username");
            final String pwd = prop.getProperty("pwd");
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(uname, pwd);
                        }
                    });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(uname));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendTo));
            message.setSubject(sub);
            message.setText(msg);
            Transport.send(message);
            System.out.println("Message is\n" + message);
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
            //e.printStackTrace();
        } finally {
            flag = true;
        }
        return flag;
    }
}
