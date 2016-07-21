/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.exception;

import com.project2.mybudget.data.FileControl;
import com.project2.mybudget.properties.Constants;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author Giang
 */
public class ExceptionViewer {

    public static void view(Exception ex) {
//        String msg = ex.getMessage();
//        String detail="";
        String msg = ex.getMessage().split("&&")[0];
        String detail = "";
        try {
            detail = ex.getMessage().split("&&")[2];
        } catch (Exception e) {
            // ignore
        }
        if (detail.equals("")) {
            JOptionPane.showMessageDialog(null, msg, "MyBudget - Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, msg+"\n\nDetail: "+detail, "MyBudget - Error", JOptionPane.ERROR_MESSAGE);
        }
        String dateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        FileControl.appendString(Constants.file("ERROR_LOG"), dateTime+" - "+msg+": "+detail+"\n");
    }
}
