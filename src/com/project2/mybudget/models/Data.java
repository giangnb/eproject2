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
public class Data {
    private int dataId;
    private Wallet wallet;
    private String reason;
    private double amount;
    private String description;
    private Date date;

    public Data() {
    }

    public Data(Wallet wallet, String reason, double amount, String description, Date date) {
        this.wallet = wallet;
        this.reason = reason;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public Data(int dataId, Wallet wallet, String reason, double amount, String description, Date date) {
        this.dataId = dataId;
        this.wallet = wallet;
        this.reason = reason;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
