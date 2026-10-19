/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

package com.mycompany.myfirstchatapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTest {

    @Test
    public void testCreateMessageID() {
        Message msg = new Message("0823960540", "Hello mom", 1);
        String id = msg.createMessageID();

        assertNotNull(id);
        assertEquals(10, id.length());
        assertTrue(msg.checkMessageID());
    }

    @Test
    public void testCheckMessageID() {
        Message msg = new Message("0823960540", "Hello", 1);
        msg.createMessageID();

        assertTrue(msg.checkMessageID());
    }

    @Test
    public void testCheckRecipientCellValid() {
        Message msg = new Message("+27823960540", "Hello", 1);

        assertTrue(msg.checkRecipientCell());
    }

    @Test
    public void testCheckRecipientCellInvalid() {
        Message msg = new Message("12345", "Hello", 1);

        assertFalse(msg.checkRecipientCell());
    }

    @Test
    public void testValidateRecipientCell() {
        Message msg = new Message("0823960540", "Hello", 1);

        assertEquals(
                "Cell phone number successfully captured.",
                msg.validateRecipientCell()
        );
    }

    @Test
    public void testCheckMessageLengthValid() {
        Message msg = new Message("0823960540", "Hello mom", 1);

        assertTrue(msg.checkMessageLength());
    }

    @Test
    public void testCheckMessageLengthInvalid() {
        String longMessage = "A".repeat(251);
        Message msg = new Message("0823960540", longMessage, 1);

        assertFalse(msg.checkMessageLength());
    }

    @Test
    public void testCreateMessageHash() {
        Message msg = new Message("0823960540", "Hello mom", 1);
        String id = msg.createMessageID();
        String hash = msg.createMessageHash();

        assertNotNull(hash);
        assertTrue(hash.startsWith(id.substring(0, 2) + ":1:"));
        assertTrue(hash.endsWith("HELLOMOM"));
    }

    @Test
    public void testSentMessage() {
        Message msg = new Message("0823960540", "Hello mom", 1);

        assertEquals(
                "Message successfully sent.",
                msg.SentMessage(1)
        );
        assertEquals("Sent", msg.getMessageStatus());
    }

    @Test
    public void testDisregardMessage() {
        Message msg = new Message("0823960540", "Hello mom", 1);

        assertEquals(
                "Press 0 to delete the message.",
                msg.SentMessage(2)
        );
        assertEquals("Disregarded", msg.getMessageStatus());
    }

    @Test
    public void testGetMessage() {
        Message msg = new Message("0823960540", "Hello mom", 1);

        assertEquals("Hello mom", msg.getMessage());
        assertEquals("0823960540", msg.getRecipientCell());
        assertEquals(1, msg.getMessageCount());
    }
    
    @Test
    public void testMessageLengthExactly250() {
        String messageText = "A".repeat(250);
        Message msg = new Message("0823960540", messageText, 1);

        assertTrue(msg.checkMessageLength());
        assertEquals("Message ready to send.",
                msg.validateMessageLength());
    }

    @Test
    public void testStoreMessage() {
        Message msg = new Message(
                "0823960540", "Hello mom", 1);

        msg.createMessageID();
        msg.createMessageHash();

        assertEquals("Message successfully stored.",
                msg.SentMessage(3));
        assertEquals("Stored", msg.getMessageStatus());
    }

    @Test
    public void testInvalidMessageChoice() {
        Message msg = new Message(
                "0823960540", "Hello mom", 1);

        assertEquals(
                "Invalid choice. Please select 1, 2, or 3.",
                msg.SentMessage(4));
    }

}