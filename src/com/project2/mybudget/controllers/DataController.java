/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.controllers;

import com.project2.mybudget.data.DataHelper;
import com.project2.mybudget.exception.AppException;
import com.project2.mybudget.models.Account;
import com.project2.mybudget.models.Data;
import com.project2.mybudget.models.Wallet;
import com.project2.mybudget.properties.Constants;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BHT
 */
public class DataController {
    private Account account;
    private DataHelper data;

    private void initController() {
        data = new DataHelper();
        account = new Account();
    }

    public DataController() {
        initController();
    }
    public boolean addIncome(Data d)
    {
        int result = -1;
        String[] sqlData = {d.getWallet().getWalletId()+"",d.getReason(),d.getAmount()+"",d.getDescription()   };

        try {
            result = data.nonQuery(Constants.sql("ADD_INCOME"), sqlData);
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
            result = data.nonQuery(Constants.sql("ADD_EXPENSE"), sqlData);
        } catch (AppException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(result);
        return result > 0;
    }
}
