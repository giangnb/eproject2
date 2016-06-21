package com.project2.mybudget.data;

import com.project2.mybudget.exception.AppException;
import com.project2.mybudget.properties.Constants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Database connection and manipulation methods
 * @author Giang
 */
public class DataHelper {
    private Connection con;
    protected PreparedStatement stm;
    protected ResultSet rs;
    
    /**
     * Open and get database connection object
     * @return Connection Database connection
     * @throws AppException 
     */
    public Connection open() throws AppException {
        try {
            Class.forName(Constants.CONNECTION.getString("Driver"));
            
            con = DriverManager.getConnection(Constants.ConnectionUrl(), 
                    Encrypt.decrypt(Constants.CONNECTION.getString("UserId")),
                    Encrypt.decrypt(Constants.CONNECTION.getString("Password")));
        } catch (ClassNotFoundException ex) {
            throw new AppException("Driver error&&"+ex.getMessage());
        } catch (SQLException ex) {
            throw new AppException("Connection error&&"+ex.getMessage());
        }
        
        return con;
    }
    
    /**
     * Close all database connection objects
     * @throws AppException 
     */
    public void close() throws AppException {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                throw new AppException(ex.getMessage());
            }
        }
        if (stm != null) {
            try {
                stm.close();
            } catch (SQLException ex) {
                throw new AppException(ex.getMessage());
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new AppException(ex.getMessage());
            }
        }
        
        con = null;
        stm = null;
        rs = null;
    }
    
    /**
     * Execute a query with fixed SQL statement
     * (without custom data or implemented custom data)
     * ! Have to open() and close()
     * @param sql SQL statement
     * @return ResultSet
     * @throws AppException 
     */
    public ResultSet query(String sql) throws AppException {
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
        } catch (SQLException ex) {
            throw new AppException("Data manipulation error&&"+ex.getMessage());
        }
        return rs;
    }
    
    /**
     * Execute a query with SQL statement and data strings
     * ! Have to open() and close()
     * @param sql SQL statement (with '?' marks)
     * @param data Data strings (will replace each '?' mark)
     * @return
     * @throws AppException 
     */
    public ResultSet query(String sql, String[] data) throws AppException {
        try {
            stm = con.prepareStatement(sql);
            for (int i = 1; i <= sql.split("[?]").length; i++) {
                try {
                    stm.setString(i, data[i]);
                } catch (Exception e) {
                    // ignore
                }
            }
            rs = stm.executeQuery();
        } catch (SQLException ex) {
            throw new AppException("Data manipulation error&&"+ex.getMessage());
        }
        return rs;
    }
    
    /**
     * Execute an insert/update/delete query with SQL statement
     * (without custom data or implemented custom data)
     * No need to open() or close()
     * @param sql SQL statement (with '?' marks)
     * @return
     * @throws AppException 
     */
    public int nonQuery(String sql) throws AppException {
        int result = 0;
        try {
            open();
            stm = con.prepareStatement(sql);
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException("Data manipulation error&&"+ex.getMessage());
        } finally {
            close();
        }
        return result;
    }
    
    /**
     * Execute an insert/update/delete query with SQL statement and data strings
     * No need to open() or close()
     * @param sql SQL statement (with '?' marks)
     * @param data Data strings (will replace each '?' mark)
     * @return
     * @throws AppException 
     */
    public int nonQuery(String sql, String[] data) throws AppException {
        int result = 0;
        try {
            open();
            stm = con.prepareStatement(sql);
            for (int i = 1; i <= sql.split("[?]").length; i++) {
                try {
                    stm.setString(i, data[i]);
                } catch (Exception e) {
                    // ignore
                }
            }
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException("Data manipulation error&&"+ex.getMessage());
        } finally {
            close();
        }
        return result;
    }
    
//    public static void main(String[] args) {
//        DataHelper dataHelper = new DataHelper();
//        try {
//            System.out.println(dataHelper.open());
//        } catch (AppException ex) {
//            Logger.getLogger(DataHelper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            dataHelper.close();
//        } catch (AppException ex) {
//            Logger.getLogger(DataHelper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
