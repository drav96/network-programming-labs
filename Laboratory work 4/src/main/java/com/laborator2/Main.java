package com.laborator2;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        printMenu();

    }

    private static void printMenu() {
        System.out.println("Menu");
        System.out.println("1. Write message");
        System.out.println("2. Read latest message");
        System.out.println("3. Read specific message");
        Scanner scanner = new Scanner(System.in);
        CheckingMails checkingMails = new CheckingMails("admin", "admin");
        SendEmail sendEmail = new SendEmail();

        switch (scanner.nextInt()) {
            case 1:
                clearConsole();
                System.out.println("Destination email:\t");
                String destinationEmail = scanner.next();

                System.out.println("Subject:\t ");
                String subject = scanner.next();

                System.out.println("Message:\t ");
                String content = scanner.next();

                sendEmail.writeTo(destinationEmail, subject, content);

                break;
            case 2:
                checkingMails.readMail(0);

                break;
            case 3:
                clearConsole();
                System.out.println("Which message?");
                checkingMails.readMail(scanner.nextInt());

                break;
            default:
                System.out.println("Default choice");
                break;
        }
        return;
    }

    public final static void clearConsole() {
        for (int i = 0; i < 5; i++) {
            System.out.println("");
        }
    }
}