/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project2.mybudget.data.Encrypt;
import com.project2.mybudget.data.Json;
import com.project2.mybudget.exception.AppException;
import com.project2.mybudget.exception.ExceptionViewer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giang
 */
public class DatabaseController {
    @JsonProperty("info")
    private DatabaseInfo info;

    public DatabaseController() {
    }

    public DatabaseController(DatabaseInfo info) {
        this.info = info;
    }
    
    public DatabaseController(String infoJsonEncrypted) {
        String infoJson = Encrypt.decrypt(infoJsonEncrypted);
        System.out.println(infoJson);
        try {
            this.info = Json.DeserializeObject(infoJson, DatabaseInfo.class);
        } catch (AppException ex) {
            ExceptionViewer.view(ex);
        }
    }
    
    public DatabaseController getController(String jsonEncrypted) {
        String infoJson = Encrypt.decrypt(jsonEncrypted);
        System.out.println(infoJson);
            DatabaseController info = null;
        try {
            info = Json.DeserializeObject(infoJson, DatabaseController.class);
        } catch (AppException ex) {
            ExceptionViewer.view(ex);
        }
        return info;
    }

    public DatabaseInfo getInfo() {
        return info;
    }

    public void setInfo(DatabaseInfo info) {
        this.info = info;
    }
    
    public void setInfo(String infoJson) {
        try {
            this.info = Json.DeserializeObject(infoJson, DatabaseInfo.class);
        } catch (AppException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static class DatabaseInfo {
        @JsonProperty("host")
        private String host;
        
        @JsonProperty("user")
        private String user;
        
        @JsonProperty("name")
        private String name;
        
        @JsonProperty("pass")
        private String pass;
        
        @JsonProperty("prefix")
        private String prefix;
        
        @JsonProperty("port")
        private int port;

        public DatabaseInfo() {
        }
        
        public DatabaseInfo(String host, String user, String name, String pass, String prefix, int port) {
            this.host = host;
            this.user = user;
            this.name = name;
            this.pass = pass;
            this.prefix = prefix;
            this.port = port;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        
        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }
        
    }
    
    public static void main(String[] args) {
        try {
            DatabaseInfo inf = Json.DeserializeObject("{\"host\":\"localhost\",\"user\":\"sa\",\"name\":\"MyBudget2\",\"pass\":\"giangnb22\",\"prefix\":\"\",\"port\":1433,\"uri\":\"jdbc:sqlserver://localhost:1433;databaseName=MyBudget2\"}", DatabaseInfo.class);
        } catch (AppException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
