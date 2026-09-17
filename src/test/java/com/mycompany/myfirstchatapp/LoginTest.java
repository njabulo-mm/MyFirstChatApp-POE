/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.myfirstchatapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    public void testCheckUserNameCorrect() {

        Login login = new Login(
                "Njl_1",
                "Ch8&se@ke99!",
                "+27838968976",
                "Mike",
                "Pertu"
        );

        assertEquals(true, login.checkUserName());
    }
    
     @Test
    public void testCheckUserNameIncorrect() {

        Login login = new Login(
                "Masungulo123",
                "Nj8&se@ke99!",
                "+27838968976",
                "Mike",
                "Pertu"
        );

        assertEquals(false, login.checkUserName());
    }

    @Test
    public void testPasswordCorrect() {

        Login login = new Login(
                "Njl_1",
                "Ch8&se@ke99!",
                "+27838968976",
                "Mike",
                "Pertu"
        );

        assertEquals(true, login.checkPasswordComplexity());
    }

    @Test
    public void testPasswordIncorrect() {

        Login login = new Login(
                "Njl_1",
                "password",
                "+27838968976",
                "Mike",
                "Pertu"
        );

        assertEquals(false, login.checkPasswordComplexity());
    }

    @Test
    public void testCellPhoneCorrect() {

        Login login = new Login(
                "Njl_1",
                "Nj8&se@ke99!",
                "+278389689761",
                "Mike",
                "Pertu"
        );

        assertEquals(true, login.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneIncorrect() {

        Login login = new Login(
                "Njl_1",
                "Nj8&se@ke99!",
                "08966553",
                "Mike",
                "Pertu"
        );

        assertEquals(false, login.checkCellPhoneNumber());
    }

    @Test
public void testLoginSuccessful() {

    Login login = new Login(
            "Nj1_1",
            "Nj8&se@ke99!",
            "+27838968976",
            "mike",
            "pertu"
    );

    assertEquals(true,
            login.loginUser("Nj1_1", "Nj8&se@ke99!"));
}
    @Test
    public void testLoginFailed() {

        Login login = new Login(
                "Njl_1",
                "Nj8&se@ke99!",
                "+27838968976",
                "Mike",
                "Pertu"
        );

        assertEquals(false,
                login.loginUser("wrong", "password"));
    }
}