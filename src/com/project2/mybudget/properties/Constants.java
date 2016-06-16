/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.properties;

import java.util.ResourceBundle;

/**
 * Provide constants from *.properties files
 * @author Giang
 */
public class Constants {
    public static final ResourceBundle CONNECTION = ResourceBundle.getBundle("com.project2.mybudget.properties.Connection");
    private static final ResourceBundle SQL = ResourceBundle.getBundle("com.project2.mybudget.properties.SqlStatements");
    
    public static String ConnectionUrl() {
        return CONNECTION.getString("Host")+";databaseName="+CONNECTION.getString("Database");
    }
    
    public static String sql(String key) {
        try {
            return SQL.getString(key);
        } catch (Exception e) {
            // ignore
            return "";
        }
    }
}
