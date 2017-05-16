package com.laborator2;

import org.apache.commons.net.pop3.POP3Client;
import org.apache.commons.net.pop3.POP3MessageInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;


public class CheckingMails {

    private String userName;
    private String userPassword;

    public CheckingMails(String userName, String password) {
        this.userName = userName;
        this.userPassword = password;
    }

    public void readMail(int messageNr) {
        try {
            POP3Client client = new POP3Client();
            client.connect("192.168.1.11", 110);
            if (client.login(userName, userPassword)) {
                POP3MessageInfo[] messages = client.listMessages();
                System.out.println("Total nr of messages: " + messages.length);
                System.out.println("Message: " + messageNr);
                System.out.println("--------------------------------------------------");

                Reader r = client.retrieveMessage(messages[messageNr].number);
                BufferedReader br = new BufferedReader(r);
                String line;

                while( ( line = br.readLine()) != null )
                {
                    System.out.println(line);
                }
            } else {
                System.out.println("Error on login");
            }
            client.logout();
            client.disconnect();
        } catch (IOException ex) {
            System.out.println("Error on connection");
        }
    }

}