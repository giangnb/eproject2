/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project2.mybudget.exception.AppException;
import java.io.IOException;

/**
 * Serialize an object and de-serialize an JSON string
 * @author Giang
 */
public class JsonHelper {
    private static final ObjectMapper mapper = new ObjectMapper();
    
    /**
     * Turn an object to JSON string
     * @param o Misc object
     * @return String JSON
     * @throws AppException 
     */
    public static String SerializeObject(Object o) throws AppException {
        String json = "";
        try {
            json =  mapper.writeValueAsString(o);
        } catch (JsonProcessingException ex) {
            throw new AppException("Data parsing error&&"+ex.getMessage());
        }
        return json;
    }
    
    /**
     * Get an object from JSON string
     * @param <E> Any object type
     * @param json Source JSON string
     * @param c Class type of desired object
     * @return Object with E generic type
     * @throws AppException 
     */
    public static <E> E DeserializeObject(String json, Class<E> c) throws AppException {
        E obj = null;
        try {
            obj = mapper.readValue(json, c);
        } catch (IOException ex) {
            throw new AppException("Object parsing error&&"+ex.getMessage());
        }
        return obj;
    }
    
//    public static void main(String[] args) {
//        Account acc = new Account("1", new Account.Info(), "sabd");
//        String js = "";
//        try {
//            js = SerializeObject(acc);
//            System.out.println(js);
//        } catch (AppException ex) {
//            Logger.getLogger(JsonHelper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        try {
//            Account a = DeserializeObject(js, Account.class);
//            System.out.println(a);
//        } catch (AppException ex) {
//            Logger.getLogger(JsonHelper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
