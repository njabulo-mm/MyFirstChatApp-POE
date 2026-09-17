/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.myfirstchatapp;

import java.util.Scanner;

public class MyFirstChatApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Registration
        System.out.println("=== Registration ===");

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

        // Create Login object
        Login user = new Login(
                username,
                password,
                cellPhoneNumber,
                firstName,
                lastName
        );

        // Check registration
        System.out.println(user.registerUser());

        // Login
        System.out.println();
        System.out.println("Login");

        System.out.print("Enter username: ");
        String loginUsername = input.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = input.nextLine();

        System.out.println(
                user.returnLoginStatus(loginUsername, loginPassword)
        );
    }
}


         
    

