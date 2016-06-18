/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.properties;

import com.project2.mybudget.data.Json;
import com.project2.mybudget.exception.AppException;
import com.project2.mybudget.models.Account;

/**
 * Store application's settings
 * @author Giang
 */
public class Settings {
    public Account account = new Account();
    
    public static void Save(Settings s) {
        // TO-DO:
        // Save json to file
        try {
            Json.SerializeObject(s);
        } catch (AppException ex) {
            // ignore
        }
    }
}
