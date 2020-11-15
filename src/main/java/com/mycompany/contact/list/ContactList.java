/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contact.list;
import java.util.ArrayList; 

/**
 *
 * @author IMASHA
 */
public class ContactList {
    ArrayList<Contact> contacts = new ArrayList<Contact>();
    
    public void addContact(String name,String phoneNo) {
        Contact contact = new Contact();
        contact.name = name;
        contact.phoneNo = phoneNo;
        contacts.add(contact);
    }
    
    public void deleteContact(int index) {
        contacts.remove(index);
    }
    
    public void editConatct(int index,String name,String phoneNo ) {
        System.out.println(index);
         Contact contact = new Contact();
         contact.name = name;
         contact.phoneNo = phoneNo;
         contacts.set(index, contact);
    }
    
    public ArrayList<Contact> DisplayConatct() {
        return contacts;
    }
    
    public void loadConatcts() {
        
    }
    
    public void saveConatcts() {
        
    }
}
