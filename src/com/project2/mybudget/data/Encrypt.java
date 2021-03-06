/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Encrypt data:
 * # Hashing: SHA-256
 * # Encrypt: AES 128-bit (with build-in PK)
 * @author Giang
 */
public class Encrypt {
    /**
     * Encrypt string with AES algorithm and build-in private key
     * @param source Source string
     * @return Encrypted string
     */
    public static String encrypt(String source) {
        AES.setKey();
        AES.encrypt(source.trim());
        return AES.getEncryptedString();
    }
    
    /**
     * Decrypt string with AES algorithm and build-in private key
     * @param source Source string
     * @return String
     */
    public static String decrypt(String source) {
        AES.setKey();
        AES.decrypt(source.trim());
        return AES.getDecryptedString();
    }
    
    /**
     * Hash string with SHA-256 algorithm
     * @param str Source string
     * @return Hash value
     */
    public static String hash(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(str.getBytes());
            
            byte byteData[] = md.digest();
            
            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            
            //System.out.println("Hex format : " + sb.toString());
            
            //convert the byte to hex format method 2
            StringBuffer hexString = new StringBuffer();
            for (int i=0;i<byteData.length;i++) {
                String hex=Integer.toHexString(0xff & byteData[i]);
                if(hex.length()==1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
    
    public static String getRandomCode(int length) {
        String result = "";
        final char[] chars = new char[] {'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M'};
        for (int i = 0; i < length; i++) {
            result += chars[(int)Math.round(Math.random()*chars.length)];
        }
        return result;
    }
    
    /**
     * Get authentication string
     * @param email
     * @param password
     * @return 
     */
    public static String getAuthenticationString(String email, String password) {
        return hash(email+password);
    }
    
    
  
//    public static void main(String[] args) {
//        String[] s = {"MyBudget", "project2", "1234567"};
//        
//        for (String string : s) {
//            System.out.println(encrypt(string));
//        }
//    }
}
