/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package com.mycompany.myfirstchatapp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Student
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.mycompany.myfirstchatapp.MessageTest.class, com.mycompany.myfirstchatapp.MyFirstChatAppTest.class, com.mycompany.myfirstchatapp.LoginTest.class})
public class MyfirstchatappSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
