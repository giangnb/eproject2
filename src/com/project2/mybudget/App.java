/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget;

import com.project2.mybudget.controllers.AccountsController;
import com.project2.mybudget.controllers.DataController;
import com.project2.mybudget.controllers.DatabaseController;
import com.project2.mybudget.controllers.WalletsController;
import com.project2.mybudget.data.Encrypt;
import com.project2.mybudget.data.FileControl;
import com.project2.mybudget.exception.AppException;
import com.project2.mybudget.exception.ExceptionViewer;
import com.project2.mybudget.properties.Constants;
import com.project2.mybudget.views.StartScreen;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Start-point
 *
 * @author Giang
 */
public class App {

    public static AccountsController ACCOUNT;
    public static WalletsController WALLET;
    public static DataController DATA;
    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static DatabaseController DB;
    public static Image ICON;

    public static void main(String[] args) {
        ACCOUNT = new AccountsController();
        WALLET = new WalletsController();
        DATA = new DataController();

        if (FileControl.isFileExists(Constants.file("DATABASE_CONFIG"))) {
            String database = FileControl.readString(Constants.file("DATABASE_CONFIG"));
            try {
                DB = new DatabaseController(database);
            } catch(Exception e) {
                FileControl.removeFile(Constants.file("DATABASE_CONFIG"));
                ExceptionViewer.view(new AppException("Please restart the application!"));
                exit(1);
            }
        } else {
            DB = null;
        }
        
        try {
            WALLET.getWallet();
        } catch (AppException ex) {
            ExceptionViewer.view(ex);
        }
        try {
            BufferedImage imgBuf = ImageIO.read(new File(Constants.file("ICON_SMALL")));
            ICON = imgBuf;
        } catch (IOException ex) {
            // ignore
            System.out.println("Cannot load icon image >> App continue.");
        }
//        StartScreen.run();
        new StartScreen();
    }

    private App() {
    }
}
