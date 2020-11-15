/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contact.list;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author IMASHA
 */
public class Main {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        System.out.println("\t\tContact Managemnt System");
        while (isRunning) {
            System.out.println("Select an Option\n" +
                    "• Enter 1 to display all contacts\n" +
                    "• Enter 2 to add contact\n" +
                    "• Enter 3 to remove contact\n" +
                    "• Enter 4 to edit a contact\n" +
                    "• Enter 5 to load contacts from a text file.\n" +
                    "• Enter 6 to save contacts to the text file.\n" +
                    "• Enter 7 to exit from the program");
            String input = scanner.nextLine();
            
            switch (input) {
                case "1" -> showDisplayContact(contactList);
                case "2" -> showAddContact(contactList);
                case "3" -> showDeleteContact(contactList);
                case "4" -> showEditContact(contactList);
                case "5" -> contactList.loadConatcts();
                case "6" -> contactList.saveConatcts();
                case "7" -> isRunning = false;
                default -> System.out.println("Invalid option!");
                    
            }
         }
        
    }
    
    private static void showAddContact(ContactList contactList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter name:");
        String name = scanner.nextLine();
        System.out.println("Please enter phone number:");
        String phoneNo = scanner.nextLine();
        contactList.addContact(name, phoneNo);
        System.out.println("Add success!");
        
    }
    private static void showDisplayContact(ContactList contactList) {
        ArrayList<Contact> contacts = contactList.DisplayConatct();
        if (contacts.size() > 0) {
            for (Contact contact:contacts) {
                System.out.println(contact.getName() + " " + contact.getphoneNo());
            } 
        
        } else {
            System.out.println("No contacts!");
        }
    }
    
    private static void showDeleteContact(ContactList contactList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter name of the contact that you want to delete:");
        String name = scanner.nextLine();
        ArrayList<Contact> contacts = contactList.DisplayConatct();
        int index = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if (name.equals(contacts.get(i).getName())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            contactList.deleteContact(index);
             System.out.println("Delete success!");
        }else {
             System.out.println("No matting contact!");
        }
        
    }
    
    
    private static void showEditContact(ContactList contactList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter name of the contact that you want to change:");
        String name = scanner.nextLine();
       
        ArrayList<Contact> contacts = contactList.DisplayConatct();
        int index = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if (name.equals(contacts.get(i).getName())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
             System.out.println("Please enter the new phone numbe:");
             String phoneNo = scanner.nextLine();
             contactList.editConatct(index,name,phoneNo);
             System.out.println("Edit success!");
        } else {
             System.out.println("No matting contact!");
        }
        
    }
}
