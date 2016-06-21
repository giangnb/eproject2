/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.exception;

import javax.swing.JOptionPane;

/**
 *
 * @author Giang
 */
public class ExceptionViewer {

    public static void view(Exception ex) {
        String msg = ex.getMessage().split("&&")[0];
        String detail = "";
        try {
            detail = ex.getMessage().split("&&")[2];
        } catch (Exception e) {
            // ignore
        }
        JOptionPane.showMessageDialog(null, msg, "MyBudget - Error", JOptionPane.ERROR_MESSAGE);
    }
}
