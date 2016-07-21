/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget;

import com.project2.mybudget.controllers.DatabaseController;
import com.project2.mybudget.data.Json;
import com.project2.mybudget.exception.AppException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giang
 */
public class Test {
    public static void main(String[] args) {
        try {
            String json = new String("{\"host\":\"localhost\",\"user\":\"sa\",\"name\":\"MyBudget2\",\"pass\":\"giangnb22\",\"prefix\":\"\",\"port\":1433}");
            DatabaseController.DatabaseInfo db = Json.DeserializeObject(json, DatabaseController.DatabaseInfo.class);
        } catch (AppException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
