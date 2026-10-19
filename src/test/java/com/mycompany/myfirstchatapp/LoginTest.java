/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

package com.mycompany.myfirstchatapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void testCheckUserName() {
        Login user = new Login(
                "nj_1", "Pertunia@3", "+27797030250",
                "Nia", "Test"
        );
        assertTrue(user.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexity() {
        Login user = new Login(
                "nj_1", "Pertunia@3", "+27797030250",
                "Nia", "Test"
        );
        assertTrue(user.checkPasswordComplexity());
    }

    @Test
    public void testCheckCellPhoneNumber() {
        Login user = new Login(
                "nj_1", "Pertunia@3", "+27797030250",
                "Nia", "Test"
        );
        assertTrue(user.checkCellPhoneNumber());
    }

    @Test
    public void testRegisterUser() {
        Login user = new Login(
                "nj_1", "Pertunia@3", "+27797030250",
                "Nia", "Test"
        );
        assertEquals("Registration successful.", user.registerUser());
    }

    @Test
    public void testLoginUser() {
        Login user = new Login(
                "nj_1", "Pertunia@3", "+27797030250",
                "Nia", "Test"
        );
        assertTrue(user.loginUser("nj_1", "Pertunia@3"));
        assertFalse(user.loginUser("wrong", "wrong"));
    }

    @Test
    public void testReturnLoginStatus() {
        Login user = new Login(
                "nj_1", "Pertunia@3", "+27797030250",
                "Nia", "Test"
        );
        assertEquals(
                "Welcome Nia, Test it is great to see you again.",
                user.returnLoginStatus("nj_1", "Pertunia@3")
        );
    }
}
