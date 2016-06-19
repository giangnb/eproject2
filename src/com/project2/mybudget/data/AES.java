package com.project2.mybudget.data;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * Protected class: Encrypt by AES core
 * @author Giang
 */
class AES {

    private static SecretKeySpec secretKey;
    private static byte[] key;

    private static String decryptedString;
    private static String encryptedString;

    public static void setKey() {
        String myKey = "-.Pv-d+m^:_+_~l_^^v+|:_%%W++;B|m:beWhKy+;!D+-qY:J_%*Uc+;e%tz+O!._c-~rK-;9~;__*9:|_*.=H=NB+U_-^=++.lO.*!R-k.P.X;Gb%xQ=:l:;:%_|^Vj";
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            //System.out.println(key.length);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            //System.out.println(key.length);
            //System.out.println(new String(key, "UTF-8"));
            secretKey = new SecretKeySpec(key, "AES");

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static String getDecryptedString() {
        return decryptedString;
    }

    public static void setDecryptedString(String decryptedString) {
        AES.decryptedString = decryptedString;
    }

    public static String getEncryptedString() {
        return encryptedString;
    }

    public static void setEncryptedString(String encryptedString) {
        AES.encryptedString = encryptedString;
    }

    public static String encrypt(String strToEncrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            setEncryptedString(Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))));

        } catch (Exception e) {

            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;

    }

    public static String decrypt(String strToDecrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");

            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            setDecryptedString(new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt))));

        } catch (Exception e) {

            System.out.println("Error while decrypting: " + e.toString());

        }
        return null;
    }
    
//    public static void main(String args[]) {
//
//        final String strToEncrypt = "My text to encrypt";
//        final String strPssword = "encryptor key";
//
//        setKey();
//        
//        AES.encrypt(strToEncrypt.trim());
//
//        System.out.println("String to Encrypt: " + strToEncrypt);
//        System.out.println("Encrypted: " + AES.getEncryptedString());
//
//        final String strToDecrypt = AES.getEncryptedString();
//        AES.decrypt(strToDecrypt.trim());
//
//        System.out.println("String To Decrypt : " + strToDecrypt);
//        System.out.println("Decrypted : " + AES.getDecryptedString());
//
//    }

}
