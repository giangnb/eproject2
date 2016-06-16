/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.models;

import java.util.Date;

/**
 *
 * @author Giang
 */
public class Account {
    private String accountId;
    private Info info;
    private String pinCode;
    public Date lastChanged;

    public Account() {
    }

    public Account(String accountId, Info info, String pinCode) {
        this.accountId = accountId;
        this.info = info;
        this.pinCode = pinCode;
    }

    public Account(String accountId, String infoJson, String pinCode) {
        this.accountId = accountId;
        this.pinCode = pinCode;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(String name, String email, String email2, Date birthDate) {
        this.info = new Info(name, email, email2, birthDate);
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
    
    public static class Info {
        private String name, email, email2;
        private Date birthDate;
        public int loginFailCount;
        /* Status: 
        0 : disabled
        1 : enabled
        2 : password change
        */
        public int status;

        public Info() {
        }

        public Info(String name, String email, String email2, Date birthDate) {
            this.name = name;
            this.email = email;
            this.email2 = email2;
            this.birthDate = birthDate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmail2() {
            return email2;
        }

        public void setEmail2(String email2) {
            this.email2 = email2;
        }

        public Date getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
        }
        
        
    }
}
