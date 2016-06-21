/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget;

import com.project2.mybudget.controllers.AccountsController;
import com.project2.mybudget.views.StartScreen;

/**
 * Start-point
 * @author Giang
 */
public class App {
    public static AccountsController ACCOUNT;
    public static void main(String[] args) {
        ACCOUNT = new AccountsController();
        StartScreen.run();
    }
}
