/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.models;

/**
 *
 * @author Giang
 */
public class Wallet {
    private int walletId;
    private Account account;
    private Info info;

    public Wallet() {
    }

    public Wallet(Account account, String infoJson) {
        this.account = account;
        // json process
    }

    public Wallet(Account account, Info info) {
        this.account = account;
        this.info = info;
    }

    public Wallet(int walletId, Account account, String infoJson) {
        this.walletId = walletId;
        this.account = account;
        // json process
    }
    
    public static class Info {
        private String name;
        private String type;

        public Info() {
        }

        public Info(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
        
    }
}
