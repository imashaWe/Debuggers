/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contact.list;
import java.util.ArrayList; 
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author IMASHA
 */
public class ContactList {
    ArrayList<Contact> contacts = new ArrayList<Contact>();
    
    public void addContact(String name,String phoneNo) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setPhoneNo(phoneNo);
        contacts.add(contact);
    }
    
    public void deleteContact(int index) {
        contacts.remove(index);
    }
    
    public void editConatct(int index,String name,String phoneNo ) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setPhoneNo(phoneNo);
        System.out.println(contacts.size());
        contacts.set(index, contact);
    }
    
    public ArrayList<Contact> DisplayConatct() {
        return contacts;
    }
    
    public void loadConatcts() {
        Storage storage = new Storage();
        JSONArray localContacts = storage.getAll();
        if (localContacts != null) {
            JSONObject obj;
            Iterator<JSONObject> iterator = localContacts.iterator();
            while (iterator.hasNext()) {
                     obj = iterator.next();
                     String name = (String) obj.get("name");
                     String phoneNO = (String) obj.get("phoneNo");
                     addContact(name,phoneNO);
            }
            System.out.println("load success!");
 
        } else {
            System.out.println("No contacts to load!");
        }
    }
    
    public void saveConatcts() {
        Storage storage = new Storage();
        storage.insertAll(contacts);
        System.out.println("save  success!");
    }
}
