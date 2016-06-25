/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.controllers;

import com.project2.mybudget.data.DataHelper;
import com.project2.mybudget.data.Encrypt;
import com.project2.mybudget.data.FileControl;
import com.project2.mybudget.data.Json;
import com.project2.mybudget.exception.AppException;
import com.project2.mybudget.models.Account;
import com.project2.mybudget.properties.Constants;
import com.project2.mybudget.views.AccountLogin;
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

    public boolean loginAuto() throws AppException {
        boolean isValid = false;
        String email, authStr;

        String file = FileControl.readString(Constants.file("USER_LOGIN"));
        if (!file.equals("")) {
            String[] s = file.split("&&");
            if (s.length >= 2) {
                email = s[0];
                authStr = s[1];

                boolean isWrongPassword = false;

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
            }
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
            if (count < 5 && !isWrongPassword) {
                count = 0;
            } else {
                count = count < 5 ? count + 1 : 5;
            }
            info.setLoginFailCount(count);
            String infoJson = Json.SerializeObject(info);
            //System.out.println(infoJson);
            data.nonQuery(Constants.sql("UPDATE_LOGIN_FAIL_COUNT"),
                    new String[]{infoJson, email});
        } catch (Exception ex) {
            throw new AppException("Account unavailable");
        }

    }

    /**
     * Logout: Delete info in saved file & refresh data in account object
     */
    public void logout() {
        FileControl.removeFile(Constants.file("USER_LOGIN"));
        account = new Account();
        AccountLogin.run();
    }

    public void updateInfo() throws AppException {
        String infoJson = Json.SerializeObject(account.getInfo());
        data.nonQuery(Constants.sql("UPDATE_LOGIN_FAIL_COUNT"), new String[]{infoJson, account.getAccountId()});
    }

    public boolean passwordChange(String oldPass, String newPass) throws AppException {
        boolean isDone = false;
        String oldAuth = Encrypt.hash(account.getAccountId() + oldPass);
        String newAuth = "";

        data.open();
        ResultSet query = data.query(Constants.sql("VALIDATE_ACCOUNT"),
                new String[]{account.getAccountId(), oldAuth});
        try {
            if (query.next()) {
                if (query.getNString("Authentication").equals(oldAuth)) {
                    newAuth = Encrypt.hash(account.getAccountId() + newPass);
                    isDone = true;
                } else {
                    throw new AppException("Wrong password.");
                }
            }
        } catch (SQLException ex) {
            throw new AppException("Internal error.&&" + ex.getMessage());
        }
        data.close();

        if (isDone) {
            data.nonQuery(Constants.sql("UPDATE_PASSWORD"),
                    new String[]{newAuth, account.getAccountId()});
        }

        return isDone;
    }

    public boolean recoverPassword(String email) throws AppException {
        boolean result = false;
        String auth = Encrypt.hash(email + "12345678");
        int r = data.nonQuery(Constants.sql("UPDATE_PASSWORD"), new String[]{auth, email});
        if (r > 0) {
            result = true;
        }
        return result;
    }
    
    public boolean recoverPasswordValidate(String email) throws AppException {
        boolean isValid = false;
        data.open();
        ResultSet query = data.query(Constants.sql("VALIDATE_ACCOUNT"),
                new String[]{email, ""});
        try {
            if (query.next()) {
                isValid = true;
            }
        } catch (SQLException ex) {
            throw new AppException("Internal error.&&" + ex.getMessage());
        }
        data.close();
        return isValid;
    }
}
