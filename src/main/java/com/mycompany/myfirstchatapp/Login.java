/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myfirstchatapp;

/**
 *
 * @author Student
 */
public class Login {

    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    // Constructor
    public Login(String username, String password, String cellPhoneNumber,
             String firstName, String lastName) {

    this.username = username;
    this.password = password;
    this.cellPhoneNumber = cellPhoneNumber;
    this.firstName = firstName;
    this.lastName = lastName;
}

    // Checks username
    public boolean checkUserName() {

        return username.contains("_") && username.length() <= 5;
    }

    // Checks password complexity
    public boolean checkPasswordComplexity() {

        return password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[0-9].*")
                && password.matches(".*[^a-zA-Z0-9].*");
    }

    // Checks cellphone number
    public boolean checkCellPhoneNumber() {

        if (cellPhoneNumber == null) {
        return false;
    }

    String regex = "^\\+27[0-9]{9}$";

    return cellPhoneNumber.matches(regex); 
    }

    // Registers the user
    public String registerUser() {

        if (!checkUserName()) {

            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";

        } else if (!checkPasswordComplexity()) {

            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";

        } else if (!checkCellPhoneNumber()) {

            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";

        } else {

            return "Registration successful.";
        }
    }

    // Checks login details
   public boolean loginUser(String enteredUsername, String enteredPassword) {
    return username.equals(enteredUsername)
            && password.equals(enteredPassword);
}

    // Returns login status
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {

        if (loginUser(enteredUsername, enteredPassword)) {

            return "Welcome " + firstName + ", " + lastName
                    + " it is great to see you again.";

        } else {

            return "Username or password incorrect, please try again.";
        }
    }
}
      
      
      

