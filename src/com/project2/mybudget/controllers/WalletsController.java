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
import java.sql.PreparedStatement;
import jdk.nashorn.internal.objects.NativeArray;

/**
 *
 * @author duchv
 */
public class WalletsController {

    public ArrayList<Wallet> wallets;
    private DataHelper data;
    public Connection con = null;
    private Wallet wallet;

    //private Json json;
    public WalletsController() {
        wallets = new ArrayList<>();
        data = new DataHelper();
    }

    //Status: OK
    public List<Wallet> getWallet() throws AppException {
        wallets = new ArrayList<>();
        //AccountID  = App.ACCOUNT.getAccount().getAccountId();
        //Json.DeserializeObject(rs.getString("Info"), Wallet.Info.class))
        //, new String[] {"admin@admin.com"}
        try {
            data.open();
            ResultSet rs = data.query(Constants.sql("GET_WALLETS"), new String[]{"admin@admin.com"});
            System.out.println(rs);
            while (rs.next()) {
                //System.out.println("fdgf");
                wallets.add(new Wallet(Integer.parseInt(rs.getString("WalletId")), rs.getString("AccountId"), rs.getString("Info")));
            }
        } catch (AppException ex) {
            throw new AppException("Error: " + ex.getMessage());
            //Logger.getLogger(WalletsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(WalletsController.class.getName()).log(Level.SEVERE, null, ex);
            throw new AppException("SQL Error: " + ex.getMessage());
        }
        data.close();

        return wallets;
    }

    //Status: OK
    public boolean AddNewWallet(Wallet.Info info) throws SQLException, AppException {
        int result = 0;
        try {
            String jsonInfo = Json.SerializeObject(info);
            con = data.open();
            result = data.nonQuery(Constants.sql("ADD_WALLET"), new String[]{"user@user.com", jsonInfo});

        } catch (AppException ex) {
//            /Logger.getLogger(WalletsController.class.getName()).log(Level.SEVERE, null, ex);
            throw new AppException("Insert Error!." + ex.getMessage());
        } finally {
            con.close();
        }
        con.close();
        return result > 0;
    }

    //Test: OK
    public boolean EditWallet(Wallet.Info info, String walletId) throws AppException, SQLException {
        int result = 0;
        try {
            String jsonInfo = Json.SerializeObject(info);
            con = data.open();
            result = data.nonQuery(Constants.sql("UPDATE_WALLET"), new String[]{jsonInfo, walletId});
        } catch (AppException ex) {
            //Logger.getLogger(WalletsController.class.getName()).log(Level.SEVERE, null, ex);
            throw new AppException("Edit Error: " + ex.getMessage());
        }
         con.close();
        return result > 0;
    }

    public boolean DeleteWallet(int walletId) throws AppException  {
        int result = 0;
        try {
            con = data.open();
            result = data.nonQuery(Constants.sql("DELETE_WALLET"), new String[] {String.valueOf(walletId)});
            con.close();
        } catch (AppException ex) {
            //Logger.getLogger(WalletsController.class.getName()).log(Level.SEVERE, null, ex);
            throw new AppException("Delete Error: " + ex.getMessage());
        } catch (SQLException ex) {
            //Logger.getLogger(WalletsController.class.getName()).log(Level.SEVERE, null, ex);
            throw new AppException("SQL Statement Error: " + ex.getMessage());
            
        }
        
        
        return result > 0;
    }

  public List<Wallet.Info> getWalletInfo() {
     List<Wallet.Info> walletInfo = null;
     List<Wallet> list = null;
     Wallet.Info wInfo;
     
        try {
            list = new WalletsController().getWallet();
            for (Wallet item:list) {
               //walletInfo.add(Json.DeserializeObject(item.getInfo(), Wallet.Info.class));
                wInfo = Json.DeserializeObject(item.getInfo().toString(), Wallet.Info.class);
                walletInfo.add(wInfo);
            }
        } catch (AppException ex) {
            Logger.getLogger(WalletsController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     return walletInfo;
  }
    
    
   
  

//    public static void main(String[] args) {
//        
////        try {
////            boolean result = new WalletsController().DeleteWallet(6);
////            System.out.println("Result " + result);
//            
////        Wallet.Info wif = new Wallet.Info("Wallet", "Cash");
////        boolean result = new WalletsController().EditWallet(wif, "5");
////        System.out.println("Edit Wallet: "+result);
////        WalletsController wc = new WalletsController();
////        List<Wallet> list = null;
////        try {
////            list = wc.getWallet();
////             System.out.println(list.size());
////        } catch (AppException ex) {
////            Logger.getLogger(WalletsController.class.getName()).log(Level.SEVERE, null, ex);
////        }
//////
////       int rs = 0;
////        try {
////            String jsontest = Json.SerializeObject(new Wallet.Info("Wallet 2", "Creadit"));
////            rs = new WalletsController().AddNewWallet(new Wallet.Info("Wallet 2", "Creadit"));
////             System.out.println("Result:  "+rs + "\n" + jsontest);
////        } catch (SQLException ex) {
////            Logger.getLogger(WalletsController.class.getName()).log(Level.SEVERE, null, ex);
////        } catch (AppException ex) {
////            Logger.getLogger(WalletsController.class.getName()).log(Level.SEVERE, null, ex);
////        }
////        } catch (AppException ex) {
////            Logger.getLogger(WalletsController.class.getName()).log(Level.SEVERE, null, ex);
////        }
//    }

}
