/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myfirstchatapp;

import java.util.Random;


public class Message {
    private static final Random RANDOM = new Random();
    private static int totalMessagesSent = 0;
    
    private String messageID;
    private int messageCount;
    private String recipientCell;
    private String message;
    private String messageHash;
    private String messageStatus;

    public Message(String recipientCell, String message, int messageCount) {
        this.recipientCell = recipientCell;
        this.message = message;
        this.messageCount = messageCount;
        this.messageID = "";
        this.messageHash = "";
        this.messageStatus = "Pending";
    }

    // Checks that the message ID is no more than 10 characters
    public boolean checkMessageID() {
        return messageID != null && messageID.matches("[0-9]{10}");
    }

    // Generates a random 10-digit message ID
    public String createMessageID() {
        messageID = String.valueOf(
                1000000000L + RANDOM.nextInt(900000000)
        );
        return messageID;
    }

    // Checks the recipient cellphone number
    public boolean checkRecipientCell() {
    if (recipientCell == null) {
        return false;
    }

    return recipientCell.matches("\\+27[0-9]{9}")
            || recipientCell.matches("0[0-9]{9}");
}

    // Returns the recipient validation message
    public String validateRecipientCell() {
        if (checkRecipientCell()) {
            return "Cell phone number successfully captured.";
        }

        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }

    // Checks that the message does not exceed 250 characters
    public boolean checkMessageLength() {
        return message != null && message.length() <= 250;
    }

    // Returns the message length validation response
    public String validateMessageLength() {
        if (message == null) {
            return "Please enter a message.";
        }

        if (message.length() > 250) {
            int extraCharacters = message.length() - 250;
            return "Message exceeds 250 characters by "
                    + extraCharacters + "; please reduce the size.";
        }

        return "Message ready to send.";
    }

    // Creates the message hash
    public String createMessageHash() {
        if (messageID == null || messageID.length() < 2
                || message == null || message.trim().isEmpty()) {
            return "";
        }

        String[] words = message.trim().split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        messageHash = (messageID.substring(0, 2) + ":"
                + messageCount + ":"
                + firstWord + lastWord).toUpperCase();

        return messageHash;
    }

    // Allows the user to choose an action for the message
    public String SentMessage(int choice) {
         switch (choice) {
             
        case 1:
          messageStatus = "Sent";
          totalMessagesSent++;
           return "Message successfully sent.";
           
        case 2:
            messageStatus = "Disregarded";
            return "Press 0 to delete the message.";

        case 3:
            messageStatus = "Stored";
            return storeMessage();

        default:
            return "Invalid choice. Please select 1, 2, or 3.";
      
        }
    }

    // Returns the message details
    public String printMessages() {
        return "Message ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipientCell
                + "\nMessage: " + message
                + "\nStatus: " + messageStatus;
    }

    // Returns the message ID
    public String getMessageID() {
        return messageID;
    }

    // Returns the message hash
    public String getMessageHash() {
        return messageHash;
    }

    // Returns the recipient cellphone number
    public String getRecipientCell() {
        return recipientCell;
    }

    // Returns the message text
    public String getMessage() {
        return message;
    }

    // Returns the message count
    public int getMessageCount() {
        return messageCount;
    }

    // Returns the message status
    public String getMessageStatus() {
        return messageStatus;
    }
    public int returnTotalMessagess() {
     return totalMessagesSent;
}

    // Stores the message in JSON format
    
public String storeMessage() {
    String json = "{\n"
            + "  \"messageID\": \"" + escapeJson(messageID) + "\",\n"
            + "  \"messageHash\": \"" + escapeJson(messageHash) + "\",\n"
            + "  \"recipientCell\": \"" + escapeJson(recipientCell) + "\",\n"
            + "  \"message\": \"" + escapeJson(message) + "\",\n"
            + "  \"messageCount\": " + messageCount + ",\n"
            + "  \"messageStatus\": \"" + escapeJson(messageStatus) + "\"\n"
            + "}";

    try {
        java.io.File file = new java.io.File("messages.json");
        String existing = "";

        if (file.exists()) {
            existing = new String(
                    java.nio.file.Files.readAllBytes(file.toPath()),
                    java.nio.charset.StandardCharsets.UTF_8
            ).trim();
        }

        if (existing.isEmpty()) {
            existing = "[]";
        }

        if (!existing.startsWith("[") || !existing.endsWith("]")) {
            return "Existing JSON file needs to be corrected first.";
        }

        String content = existing.substring(1, existing.length() - 1).trim();

        if (!content.isEmpty()) {
            content += ",\n";
        }

        String updated = "[\n" + content + json + "\n]";

        try (java.io.FileWriter writer = new java.io.FileWriter(file, false)) {
            writer.write(updated);
        }

        return "Message successfully stored.";
    } catch (java.io.IOException e) {
        return "Error storing message: " + e.getMessage();
    }
}


    // Escapes special characters for JSON
    private String escapeJson(String value) {
        if (value == null) {
            return "";
        }

        return value.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}

    