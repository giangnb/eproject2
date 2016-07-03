/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.controllers;

import com.project2.mybudget.App;
import com.project2.mybudget.data.DataHelper;
import com.project2.mybudget.models.Wallet;
import java.util.ArrayList;
import java.util.List;
import com.project2.mybudget.data.DataHelper;
import com.project2.mybudget.exception.AppException;
import java.sql.ResultSet;
import com.project2.mybudget.properties.Constants;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.project2.mybudget.data.Json;
import java.sql.Connection;
/**
 *
 * @author duchv
 */
public class WalletsController {

    public ArrayList<Wallet> wallets;
    private final DataHelper data;
    public Connection con = null;
    private Wallet wallet;
    private Json json;

   
    public WalletsController() {
        wallets = new ArrayList<>();
        data = new DataHelper();
        
    }

  
    public List<Wallet> getWallet() throws AppException {
        wallets = new ArrayList<>();
        try {
            data.open();
            ResultSet rs = data.query(Constants.sql("GET_WALLETS"), new String[]{App.ACCOUNT.getAccount().getAccountId()});
            System.out.println(rs);
            while (rs.next()) {
                wallets.add(new Wallet(Integer.parseInt(rs.getString("WalletId")), rs.getString("AccountId"), rs.getString("Info")));
            }
        } catch (AppException ex) {
            throw new AppException("Error: " + ex.getMessage());
        } catch (SQLException ex) {
            throw new AppException("SQL Error: " + ex.getMessage());
        }
        data.close();

        return wallets;
    }

  
    public boolean AddNewWallet(Wallet.Info info) throws SQLException, AppException {
        int result = 0;
        try {
            String jsonInfo = Json.SerializeObject(info);
            con = data.open();
            result = data.nonQuery(Constants.sql("ADD_WALLET"), new String[]{"user@user.com", jsonInfo});
        } catch (AppException ex) {
            throw new AppException("Insert Error!." + ex.getMessage());
        } finally {
            con.close();
        }
        con.close();
        return result > 0;
    }

    
    public boolean EditWallet(Wallet.Info info, String walletId) throws AppException, SQLException {
        int result = 0;
        try {
            String jsonInfo = Json.SerializeObject(info);
            con = data.open();
            result = data.nonQuery(Constants.sql("UPDATE_WALLET"), new String[]{jsonInfo, walletId});
        } catch (AppException ex) {
            
            throw new AppException("Edit Error: " + ex.getMessage());
        }
        finally{con.close();}
        
        return result > 0;
    }
     
    public boolean DeleteWallet(int walletId) throws AppException, SQLException {
        int result = 0;
        try {
            con = data.open();
            result = data.nonQuery(Constants.sql("DELETE_WALLET"), new String[]{String.valueOf(walletId)});
            con.close();
        } catch (AppException ex) {
            throw new AppException("Delete Error: " + ex.getMessage());
        } catch (SQLException ex) {
            throw new AppException("SQL Statement Error: " + ex.getMessage());
        }
        finally {con.close();}
        return result > 0;
    }

    /**
     * Get Wallet.Info(Json String[])
     * App.ACCOUNT.getAccount().getAccountId()
     */
    public List<String> getWalletInfo() throws AppException {
        List<String> lstJsonInfo = new ArrayList<>();
        try {
            data.open();
            ResultSet rs = data.query(Constants.sql("GET_WALLETS"), new String[]{App.ACCOUNT.getAccount().getAccountId()});
            System.out.println(rs);
            while (rs.next()) {
                lstJsonInfo.add(rs.getString("Info"));
            }

        } catch (AppException ex) {
            throw new AppException("Error: " + ex.getMessage());
        } catch (SQLException ex) {
            throw new AppException("SQL Error: " + ex.getMessage());
        }
        finally {data.close();}
        

        return lstJsonInfo;
    }

    /**
     * Get Wallet by Wallet ID
     */
    
       public Wallet loadWalletDetail(int id) throws AppException {
           Wallet wallet = null;
        try {
            data.open();
            ResultSet rs = data.query(Constants.sql("GET_WALLET_ID"), new String[] {String.valueOf(id)});
            while (rs.next()) {
               wallet = new Wallet(Integer.parseInt(rs.getString("WalletId")), Json.DeserializeObject(rs.getString("Info"), Wallet.Info.class)); 
            }
        } catch (AppException ex) {
            throw new AppException("Error: " + ex.getMessage());
        } catch (SQLException ex) {
            throw new AppException("SQL Error: " + ex.getMessage());
        }
           return wallet;
       }
    }

