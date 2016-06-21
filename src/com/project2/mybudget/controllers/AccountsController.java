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
import java.util.logging.Level;
import java.util.logging.Logger;

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
        account = new Account();
    }

    public AccountsController() {
        initController();
    }

    public AccountsController(Account account) {
        initController();
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    /**
     * Login to an account using email and password combination
     *
     * @param email User's email (AccountId)
     * @param password Account password
     * @return Login valid or not (true or false)
     * @throws AppException
     */
    public boolean login(String email, String password) throws AppException {
        boolean isValid = false;
        boolean isWrongPassword = false;
        String authStr = Encrypt.hash(email + password);

        data.open();
        ResultSet query = data.query(Constants.sql("VALIDATE_ACCOUNT"), new String[]{email, authStr});
        try {
            if (query.next()) {
                getAccount(email);
                if (query.getNString("Authentication").equals(authStr)) {
                    isValid = true;
                } else {
                    isWrongPassword = true;
                }
            }
        } catch (SQLException ex) {
            throw new AppException("Internal error.&&" + ex.getMessage());
        }
        data.close();

        updateLoginFailCount(email, isWrongPassword);
        if (isWrongPassword) {
            throw new AppException("Wrong password.");
        }

        return isValid;
    }

    /**
     * Register an account
     *
     * @param a Account object
     * @param auth Authentication string
     * @return Successful or not
     * @throws AppException
     */
    public boolean register(Account a, String auth) throws AppException {
        account = a;

        int result = -1;
        String info = Json.SerializeObject(a.getInfo());
        String[] sqlData = {a.getAccountId(), auth, info};

        result = data.nonQuery(Constants.sql("ADD_ACCOUNT"), sqlData);
        System.out.println(result);
        return result > 0;
    }

    /**
     * Initialize account element in this object
     *
     * @param accountId
     * @throws AppException
     */
    public void getAccount(String accountId) throws AppException {
        account = new Account();
        try {
            ResultSet rs = data.query(Constants.sql("GET_ACCOUNT"),
                    new String[]{accountId});
            if (rs.next()) {
                account.setAccountId(rs.getString("AccountId"));
                account.setInfo(Json.DeserializeObject(rs.getNString("Info"),
                        Account.Info.class));
                account.lastChanged = rs.getDate("LastChange");
            } else {
                throw new AppException("Account unavailable.");
            }
        } catch (AppException ex) {
            throw new AppException("Account unavailable.");
        } catch (SQLException ex) {
            throw new AppException("Data connection error.&&" + ex.getMessage());
        }
    }

    /**
     * Validate account, decide what to do next
     *
     * @return [0]: can login or not; [1]: message
     */
    public String[] validate() {
        if (account.getAccountId() == null
                || account.lastChanged == null
                || account.getInfo() == null) {
            return new String[]{"0", "Not logged in"};
        }

        if (account.getInfo().loginFailCount > 5) {
            return new String[]{"0", "You have entered wrong password too much"};
        }

        switch (account.getInfo().status) {
            case 0:
                return new String[]{"0", "Account disabled"};
            case 2:
                return new String[]{"1", "You need to change password"};
            case 3:
                return new String[]{"1", "Account activation required"};
        }

        return new String[]{"1", ""};
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
    /**
     * Update login fail count in database
     *
     * @param email
     * @param isWrongPassword
     * @throws AppException
     */
    public void updateLoginFailCount(String email, boolean isWrongPassword) throws AppException {
        try {
            Account.Info info = account.getInfo();
            int count = info.loginFailCount;
            if (count<5 && !isWrongPassword) {
                count = 0;
            } else {
                count = count<5 ? count+1 : 5;
            }
            info.setLoginFailCount(count);
            String infoJson = Json.SerializeObject(info);
            System.out.println(infoJson);
            data.nonQuery(Constants.sql("UPDATE_LOGIN_FAIL_COUNT"),
                    new String[]{infoJson, email});
        } catch (Exception ex) {
            throw new AppException("Account unavailable");
        }

    }
}
