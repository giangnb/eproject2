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

    public void setInfo(Info info) {
        this.info = info;
    }

    public void setInfo(String name, String email, Date birthDate) {
        this.info = new Info(name, email, birthDate);
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
    
    public static class Info {
        private String name, email;
        private Date birthDate;
        public int loginFailCount;
        public String tempPassword;
        /* Status: 
        0 : disabled
        1 : enabled
        2 : password change
        3 : new (need auth. code)
        */
        public int status;
        public String activationCode;

        public Info() {
        }

        public Info(String name, String email, Date birthDate) {
            this.name = name;
            this.email = email;
            this.birthDate = birthDate;
        }

        public int getLoginFailCount() {
            return loginFailCount;
        }

        public void setLoginFailCount(int loginFailCount) {
            this.loginFailCount = loginFailCount;
        }

        public String getTempPassword() {
            return tempPassword;
        }

        public void setTempPassword(String tempPassword) {
            this.tempPassword = tempPassword;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getActivationCode() {
            return activationCode;
        }

        public void setActivationCode(String activationCode) {
            this.activationCode = activationCode;
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

        public Date getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
        }
        
        
    }
}
