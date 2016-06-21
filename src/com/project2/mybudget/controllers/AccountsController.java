/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.controllers;

import com.project2.mybudget.data.DataHelper;
import com.project2.mybudget.data.Encrypt;
import com.project2.mybudget.data.Json;
import com.project2.mybudget.exception.AppException;
import com.project2.mybudget.models.Account;
import com.project2.mybudget.properties.Constants;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Account CRUD and authentication
 *
 * @author Giang
 */
public class AccountsController {

    private Account account;
    private DataHelper data;

    private void initController() {
        data = new DataHelper();
    }

    public AccountsController() {
        initController();
    }

    public AccountsController(Account account) {
        initController();
        this.account = account;
    }

    /**
     * Login to an account using email and password combination
     * @param email User's email (AccountId)
     * @param password Account password
     * @return Login valid or not (true or false)
     * @throws AppException
     */
    public boolean login(String email, String password) throws AppException {
        boolean isValid = false;
        try {
            String authStr = Encrypt.hash(email + password);

            data.open();
            ResultSet query = data.query(Constants.sql("VALIDATE_ACCOUNT"), new String[]{email, authStr});
            if (query.next()) {
                isValid = true;
            }
            data.close();

        } catch (AppException ex) {
            throw new AppException("Data connection error&&" + ex.getMessage());
        } catch (SQLException ex) {
            throw new AppException("Internal error&&" + ex.getMessage());
        }
        return isValid;
    }

    /**
     * Register an account
     * @param a Account object
     * @param auth Authentication string
     * @return Successful or not
     * @throws AppException 
     */
    public boolean register(Account a, String auth) throws AppException {
        int result = 0;
        String info = Json.SerializeObject(a.getInfo());
        String[] sqlData = {a.getAccountId(), auth, info};

        result = data.nonQuery(Constants.sql("ADD_ACCOUNT"), sqlData);
        return result > 0;
    }
    
    public void getAccount(String accointId, String auth) throws AppException {
        
    }

//    public static void main(String[] args) {
//        AccountsController ac = new AccountsController();
//        try {
//            boolean x = ac.login("asd", "dgsad==");
//            System.out.println(x);
//        } catch (AppException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
}
