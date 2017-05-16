package com.laborator2;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

class SendEmail {

    static void writeTo(String destinationEmail, String subject, String content) {
        // Recipient's email ID needs to be mentioned.

        // Sender's email ID needs to be mentioned
        String from = "dragos.lupei@gmail.com";

        // Assuming you are sending email from localhost
        String host = "192.168.1.11";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinationEmail));

            // Set Subject: header field
            message.setSubject(subject);

            // Send the actual HTML message, as big as you like
            message.setText(content);

            // Send message

            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}