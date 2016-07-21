/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.controllers;

import com.project2.mybudget.App;
import com.project2.mybudget.data.DataHelper;
import com.project2.mybudget.exception.AppException;
import com.project2.mybudget.exception.ExceptionViewer;
import com.project2.mybudget.models.Account;
import com.project2.mybudget.models.Data;
import com.project2.mybudget.models.Wallet;
import com.project2.mybudget.properties.Constants;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BHT
 */
public class DataController {
    private ArrayList<Data> budget;
    private Account account;
    private DataHelper data;

    private void initController() {
        data = new DataHelper();
        account = new Account();
        budget = new ArrayList<>();
    }

    public ArrayList<Data> getBudget() {
        return budget;
    }

    public void setBudget(ArrayList<Data> budget) {
        this.budget = budget;
    }
    
    public DataController() {
        initController();
    }
    
    public void loadData(int amount) {
        try {
            budget.clear();
            data.open();
            ResultSet rs = data.query(Constants.sql("LOAD_DATA"), new String[]{amount+""});
            while (rs.next()) {
                for (Wallet w : App.WALLET.getWallet()) {
                    if (w.getWalletId()==rs.getInt("WalletId")) {
                        budget.add(new Data(w, rs.getString("Reason"), rs.getDouble("Amount"), rs.getString("Description"), rs.getDate("Date_")));
                        break;
                    }
                }
            }
            data.close();
        } catch (AppException | SQLException ex) {
            ExceptionViewer.view(ex);
        }
    }
    
    public void loadDataByDate(Date start, Date end) {
        SimpleDateFormat fmt = new SimpleDateFormat("y-M-d");
        
        try {
            budget.clear();
            data.open();
            ResultSet rs = data.query(Constants.sql("LOAD_DATA_BY_DATE"), new String[]{fmt.format(start), fmt.format(end)});
            while (rs.next()) {
                for (Wallet w : App.WALLET.getWallet()) {
                    if (w.getWalletId()==rs.getInt("WalletId")) {
                        budget.add(new Data(rs.getInt("DataId"), w, rs.getString("Reason"), rs.getDouble("Amount"), rs.getString("Description"), rs.getDate("Date_")));
                        break;
                    }
                }
            }
            data.close();
        } catch (AppException | SQLException ex) {
            ExceptionViewer.view(ex);
        }
    }
    
    public void loadDataByDateAndWallet(Date start, Date end, Wallet wallet) {
        SimpleDateFormat fmt = new SimpleDateFormat("y-M-d");
        
        try {
            budget.clear();
            data.open();
            ResultSet rs = data.query(Constants.sql("GET_DATA_BY_WALLET"), new String[]{fmt.format(start), fmt.format(end), wallet.getWalletId()+""});
            while (rs.next()) {
                budget.add(new Data(rs.getInt("DataId"), wallet, rs.getString("Reason"), rs.getDouble("Amount"), rs.getString("Description"), rs.getDate("Date_")));
            }
            data.close();
        } catch (AppException | SQLException ex) {
            ExceptionViewer.view(ex);
        }
    }
    
    public boolean addIncome(Data d)
    {
        int result = -1;
        String[] sqlData = {d.getWallet().getWalletId()+"",d.getReason(),d.getAmount()+"",d.getDescription()};

        try {
            result = data.nonQuery(Constants.sql("ADD_DATA"), sqlData);
        } catch (AppException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(result);
        return result > 0;
    }

    public boolean addExpense(Data d) {
        int result = -1;
        String[] sqlData = {d.getWallet().getWalletId()+"",d.getReason(),-d.getAmount()+"",d.getDescription()   };

        try {
            result = data.nonQuery(Constants.sql("ADD_DATA"), sqlData);
        } catch (AppException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(result);
        return result > 0;
    }
    
    public boolean editIncome(Data d) {
        int result = -1;
        String[] sqlData = {d.getWallet().getWalletId()+"", d.getReason(), d.getAmount()+"", d.getDescription(), d.getDataId()+""};

        try {
            result = data.nonQuery(Constants.sql("UPDATE_DATA"), sqlData);
        } catch (AppException ex) {
            ExceptionViewer.view(ex);
        }
        System.out.println(result);
        return result > 0;
    }
    
    public boolean editExpense(Data d) {
        int result = -1;
        String[] sqlData = {d.getWallet().getWalletId()+"", d.getReason(), -d.getAmount()+"", d.getDescription(), d.getDataId()+""};

        try {
            result = data.nonQuery(Constants.sql("UPDATE_DATA"), sqlData);
        } catch (AppException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(result);
        return result > 0;
    }
    
    public boolean deleteItem(Data d) {
        int result = -1;
        String[] sqlData = {d.getDataId()+""};

        try {
            result = data.nonQuery(Constants.sql("DELETE_DATA"), sqlData);
        } catch (AppException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(result);
        return result > 0;
    }
    
//    public ArrayList<Data> getData(Date from, Date to) {
//        ArrayList<Data> list = new ArrayList<>();
//        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
//        
//        
//        return list;
//    }
}
