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
         while (isRunning) {
            System.out.println("Select an Option\n" +
                    "• Enter 1 to display all contacts\n" +
                    "• Enter 2 to add contact\n" +
                    "• Enter 3 to remove contact\n" +
                    "• Enter 4 to edit a contact\n" +
                    "• Enter 5 to load contacts from a text file.\n" +
                    "• Enter 6 to save contacts to the text file.\n" +
                    "• Enter 7 to exit from the program");
            int input = scanner.nextInt();
            
            switch (input) {
                case 1:
                    showDisplayContact(contactList);
                    break;
                case 2:
                    showAddContact(contactList);
                    break;
                case 3:
                    showDeleteContact(contactList);
                    break;
                case 4:
                    showEditContact(contactList);
                    break;
                case 5:
                    showAddContact(contactList);
                    break;
                case 6:
                    showAddContact(contactList);
                    break;
                case 7:
                    showAddContact(contactList);
                    isRunning = false;
                    break;
                    
            }
         }
        
    }
    
    private static void showAddContact(ContactList contactList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter name:");
        String name = scanner.nextLine();
        System.out.println("Please enter phone:");
        String phoneNo = scanner.nextLine();
        contactList.addContact(name, phoneNo);
        
    }
    private static void showDisplayContact(ContactList contactList) {
        for (Contact contact:contactList.DisplayConatct()) {
            System.out.println(contact.name + " " + contact.phoneNo);
        } 
    }
    
    private static void showDeleteContact(ContactList contactList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter name of the contact that you want to delete");
        String name = scanner.nextLine();
        ArrayList<Contact> contacts = contactList.DisplayConatct();
        int index = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if (name.equals(contacts.get(i).name)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            contactList.deleteContact(index);
             System.out.println("Delete success!");
        }else {
             System.out.println("---");
        }
        
    }
    
    
    private static void showEditContact(ContactList contactList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter name of the contact that you want to change");
        String name = scanner.nextLine();
       
        ArrayList<Contact> contacts = contactList.DisplayConatct();
        int index = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if (name.equals(contacts.get(i).name)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
             contactList.deleteContact(index);
             System.out.println("“Please enter the new phone numbe:");
             String phoneNo = scanner.nextLine();
             contactList.editConatct(index,name,phoneNo);
             System.out.println("Edit success!");
        } else {
             System.out.println("---");
        }
        
    }
}
