/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.properties;

import com.project2.mybudget.data.Encrypt;
import java.util.ResourceBundle;

/**
 * Provide constants from *.properties files
 * @author Giang
 */
public class Constants {
    public static ResourceBundle CONNECTION = ResourceBundle.getBundle("com.project2.mybudget.properties.Connection");
    private static final ResourceBundle SQL = ResourceBundle.getBundle("com.project2.mybudget.properties.SqlStatements");
    private static final ResourceBundle REGEX = ResourceBundle.getBundle("com.project2.mybudget.properties.RegularExpressions");
    private static final ResourceBundle FILENAME = ResourceBundle.getBundle("com.project2.mybudget.properties.FileName");
    
    public static String ConnectionUrl() {
        return CONNECTION.getString("Host")+";databaseName="+Encrypt.decrypt(CONNECTION.getString("Database"));
    }
    
    public static String sql(String key) {
        try {
            return SQL.getString(key);
        } catch (Exception e) {
            // ignore
            return "";
        }
    }
    
    public static String regex(String key) {
        try {
            return REGEX.getString(key);
        } catch (Exception e) {
            return "";
        }
    }
    
    public static String file(String key) {
        try {
            return FILENAME.getString(key);
        } catch (Exception e) {
            return "";
        }
    }
}
