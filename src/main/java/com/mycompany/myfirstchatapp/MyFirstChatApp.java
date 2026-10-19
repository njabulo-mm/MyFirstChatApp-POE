/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


package com.mycompany.myfirstchatapp;

import java.util.Scanner;
import java.util.ArrayList;

public class MyFirstChatApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Message> messages = new ArrayList<>();

        System.out.println("=== Chat App Registration ===");

        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter cellphone number: ");
        String cellPhoneNumber = input.nextLine();

        Login user = new Login(
                username,
                password,
                cellPhoneNumber,
                firstName,
                lastName
        );

        System.out.println();
        System.out.println(user.registerUser());

        System.out.println();
        System.out.println("=== Login ===");

        System.out.print("Enter username: ");
        String loginUsername = input.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = input.nextLine();

        System.out.println();

        if (user.loginUser(loginUsername, loginPassword)) {

            System.out.println(user.returnLoginStatus(
                    loginUsername, loginPassword));
            System.out.println("Welcome to QuickChat.");

            System.out.print("How many messages would you like to enter? ");
            int numberOfMessages = input.nextInt();
            input.nextLine();

            int choice = 0;

            while (choice != 3) {
                System.out.println();
                System.out.println("1. Send Messages");
                System.out.println("2. Show recently sent messages");
                System.out.println("3. Quit");
                System.out.print("Enter your choice: ");

                choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    case 1:

                        for (int i = 0; i < numberOfMessages; i++) {

                            System.out.println("Message " + (i + 1));

                            System.out.print(
                                    "Enter recipient cellphone number: ");
                            String recipient = input.nextLine();

                            System.out.print("Enter your message: ");
                            String messageText = input.nextLine();

                            Message newMessage = new Message(
                                    recipient, messageText, i + 1);

                            newMessage.createMessageID();

                            if (!newMessage.checkRecipientCell()) {
                                System.out.println(
                                        newMessage.validateRecipientCell());
                                i--;
                                continue;
                            }

                            if (!newMessage.checkMessageLength()) {
                                System.out.println(
                                        newMessage.validateMessageLength());
                                i--;
                                continue;
                            }

                            newMessage.createMessageHash();

                            System.out.println("Choose an option:");
                            System.out.println("1. Send Message");
                            System.out.println("2. Disregard Message");
                            System.out.println("3. Store Message");
                            System.out.print("Enter your choice: ");

                            int messageChoice = input.nextInt();
                            input.nextLine();

                            System.out.println(
                                    newMessage.SentMessage(messageChoice));

                            messages.add(newMessage);

                            System.out.println(newMessage.printMessages());
                            System.out.println(
                                    "Total messages sent: "
                                    + newMessage.returnTotalMessagess());
                        }

                        // Prevent entering more than the startup quantity
                        numberOfMessages = 0;
                        break;

                    case 2:
                        System.out.println("Coming Soon.");
                        break;

                    case 3:
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println(
                                "Invalid choice. Please try again.");
                }
            }

        } else {
            System.out.println(
                    "Username or password incorrect, please try again.");
        }

        input.close();
    }
}
