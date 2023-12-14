package com.example.test;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String alternateEmail;
    private String companySuffix = "acompany.com";
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;


    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
     
        System.out.println("EMAIL CREATED FOR: " + this.firstName + " " + this.lastName);

        this.department = setDepartment();


        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);


        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your email is: " + email);

    }

    private String setDepartment(){
        System.out.print("New Employee " + firstName + " Department Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter Department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1){return "sales";}
        else if (depChoice == 2){return "development";}
        else if (depChoice == 3){return "accounting"; }
        else {return "";}
    }

    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*";
        char[] password = new char[length];
        for (int i = 0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);

        }
        return new String(password);
    }

    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "Display Name: " + firstName + " " + lastName +
               "\nCompany Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + " mb" ;
    }
}
