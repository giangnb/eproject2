/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.models;

import com.project2.mybudget.models.Wallet.Info;

/**
 *
 * @author Giang
 */
public class Wallet {
    private int walletId;
    private String accountId;
    private Info info;

    public Wallet() {
    }

    public Wallet(String jsonInfo) {
      
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
    
    

    public Wallet(String accountId, String infoJson) {
        this.accountId = accountId;
        // json process
    }

    public Wallet(String accountId, Info info) {
        this.accountId = accountId;
        this.info = info;
    }

    public Wallet(int walletId, Info info) {
        this.walletId = walletId;
        this.info = info;
    }
    

    public Wallet(int walletId, String accountId, String infoJson) {
        this.walletId = walletId;
        this.accountId = accountId;
        // json process
    }

    public int getWalletId() {
        return walletId;
    }

    public String getAccountId() {
        return accountId;
    }

    public Info getInfo() {
        return info;
    }
    
    

    @Override
    public String toString() {
//        return "Wallet{" + "walletId=" + walletId + ", accountId=" + accountId + ", info=" + info + '}';
        return this.info.getName();
    }
    
    

    
    public static class Info {
        private String name;
        private String type;
        //private Info Info;

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

        @Override
        public String toString() {
            return "Info{" + "name=" + name + ", type=" + type + '}';
        }

        
        
    }
}
