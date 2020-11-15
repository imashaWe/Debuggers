/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contact.list;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author IMASHA
 */
public class Storage {
    JSONObject jsondb;
    Storage() {
        jsondb = new JSONObject();
    }
    
    public JSONArray getAll() {
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("storage.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray result = (JSONArray) jsonObject.get("contacts");
            return  result == null ? new JSONArray():result;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void insertAll(ArrayList<Contact> contactList) {
        
        JSONObject stotage = new JSONObject();
        JSONArray recoads = new JSONArray();

        
        for (Contact contact:contactList) {
            JSONObject row = new JSONObject();
            row.put("name",contact.getName());
            row.put("phoneNo",contact.getphoneNo());
            recoads.add(row);
            
        } 
        stotage.put("contacts",recoads);

        try (FileWriter file = new FileWriter("storage.json")) {
            file.write(stotage.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


