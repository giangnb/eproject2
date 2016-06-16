/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.properties;

import java.util.ResourceBundle;

/**
 *
 * @author Giang
 */
public class Constants {
    public static final ResourceBundle CONNECTION = ResourceBundle.getBundle("com.project2.mybudget.properties.Connection");
    
    public static String ConnectionUrl() {
        return CONNECTION.getString("Host")+";databaseName="+CONNECTION.getString("Database");
    }
}
