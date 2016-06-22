/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.data;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giang
 */
public class FileControl {

    private static File f;

    /**
     * Write a string to file
     * @param fileName
     * @param content 
     */
    public static void writeString(String fileName, String content) {
        FileWriter out = null;
        try {
            f = new File(fileName);
            out = new FileWriter(f);
            out.write(content);
        } catch (IOException ex) {
            Logger.getLogger(FileControl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(FileControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Read a string from text file
     * @param fileName
     * @return 
     */
    public static String readString(String fileName) {
        String result = "";
        FileReader in = null;
        try {
            f = new File(fileName);
            if (f.exists()) {
                in = new FileReader(f);
                FileInputStream fis = new FileInputStream(f);
                BufferedInputStream bis = new BufferedInputStream(fis);
                byte[] buf = new byte[bis.available()];
                bis.read(buf);
                result = new String(buf);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileControl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                //ignore
            } catch (NullPointerException ex) {
                //ignore
            }
        }
        return result;
    }
    
    /**
     * Delete a file
     * @param fileName 
     */
    public static void removeFile(String fileName) {
        f = new File(fileName);
        if (f.exists()) {
            f.delete();
        }
    }

//    public static void main(String[] args) {
//        writeString("user.cfg", "This is a\nTest file!\n./.");
//        System.out.println(readString("user.cfg"));
//    }
}
