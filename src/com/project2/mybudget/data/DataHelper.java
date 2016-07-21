package com.project2.mybudget.data;

import com.project2.mybudget.App;
import com.project2.mybudget.controllers.DatabaseController;
import com.project2.mybudget.exception.AppException;
import com.project2.mybudget.properties.Constants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Database connection and manipulation methods
 *
 * @author Giang
 */
public class DataHelper {

    private Connection con;
    protected PreparedStatement stm;
    protected ResultSet rs;

    /**
     * Open and get database connection object
     *
     * @return Connection Database connection
     * @throws AppException
     */
    public Connection open() throws AppException {
        try {
            Class.forName(Constants.CONNECTION.getString("Driver"));

            if (App.DB != null) {
                con = DriverManager.getConnection(
                        "jdbc:sqlserver://"+App.DB.getInfo().getHost()+":"+App.DB.getInfo().getPort()+";databaseName="+App.DB.getInfo().getName(),
                        App.DB.getInfo().getUser(),
                        App.DB.getInfo().getPass());
                //System.out.println("jdbc:sqlserver://"+App.DB.getInfo().getHost()+":"+App.DB.getInfo().getPort()+";databaseName="+App.DB.getInfo().getName());
            } else {
                con = DriverManager.getConnection(
                        Constants.ConnectionUrl(),
                        Encrypt.decrypt(Constants.CONNECTION.getString("UserId")),
                        Encrypt.decrypt(Constants.CONNECTION.getString("Password")));
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException("Driver error&&" + ex.getMessage());
        } catch (SQLException ex) {
            throw new AppException("Connection error&&" + ex.getMessage());
        }

        return con;
    }

    /**
     * Close all database connection objects
     *
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
     * Execute a query with fixed SQL statement (without custom data or
     * implemented custom data) ! Have to open() and close()
     *
     * @param sql SQL statement
     * @return ResultSet
     * @throws AppException
     */
    public ResultSet query(String sql) throws AppException {
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
        } catch (SQLException ex) {
            throw new AppException("Data manipulation error&&" + ex.getMessage());
        }
        return rs;
    }

    /**
     * Execute a query with SQL statement and data strings ! Have to open() and
     * close()
     *
     * @param sql SQL statement (with '?' marks)
     * @param data Data strings (will replace each '?' mark)
     * @return
     * @throws AppException
     */
    public ResultSet query(String sql, String[] data) throws AppException {
        try {
            for (int i = 0; i < data.length; i++) {
                try {
                    //stm.setString(i, data[i]);
                    sql = sql.replaceFirst("[?]", data[i]);
                } catch (Exception e) {
                    // ignore
                }
            }
            System.out.println(sql);
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
        } catch (SQLException ex) {
            throw new AppException("Data manipulation error&&" + ex.getMessage());
        }
        return rs;
    }

    /**
     * Execute an insert/update/delete query with SQL statement (without custom
     * data or implemented custom data) No need to open() or close()
     *
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
            throw new AppException("Data manipulation error&&" + ex.getMessage());
        } finally {
            close();
        }
        return result;
    }

    /**
     * Execute an insert/update/delete query with SQL statement and data strings
     * No need to open() or close()
     *
     * @param sql SQL statement (with '?' marks)
     * @param data Data strings (will replace each '?' mark)
     * @return
     * @throws AppException
     */
    public int nonQuery(String sql, String[] data) throws AppException {
        int result = 0;
        try {
            open();
            for (int i = 0; i < data.length; i++) {
                try {
                    //stm.setString(i, data[i]);
                    sql = sql.replaceFirst("[?]", data[i]);
                } catch (Exception e) {
                    // ignore
                }
            }
            System.out.println(sql);
            stm = con.prepareStatement(sql);
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException("Data manipulation error&&" + ex.getMessage());
        } finally {
            close();
        }
        return result;
    }

    /**
     * Check if connection is valid
     *
     * @return
     * @throws AppException
     */
    public boolean checkConnection() throws AppException {
        boolean isOk = false;
        open();
        if (con != null) {
            isOk = true;
        }
        close();
        return isOk;
    }

    /**
     * Check a custom connection's validity
     *
     * @param host Host name (URI or IP) with port
     * @param user SQL Server login user ID
     * @param password Password associated with provided account
     * @return
     * @throws AppException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean checkConnection(String host, String user, String password) throws AppException, ClassNotFoundException, SQLException {
        boolean isOk = false;
        Class.forName(Constants.CONNECTION.getString("Driver"));
        Connection connect = DriverManager.getConnection(host, user, password);

        if (connect != null) {
            isOk = true;
        }
        connect.close();
        return isOk;
    }

    /**
     * Check database structure (only table name)
     * @return
     * @throws AppException
     * @throws SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public boolean checkDatabase() throws AppException, SQLException, ClassNotFoundException {
        if (checkConnection()) {
            if (App.DB == null) {
            int tblCount = 0;
                open();

                rs = query("SELECT TABLE_NAME as 'name' FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = 'BASE TABLE'");
                while (rs.next()) {
                    switch (rs.getString("name")) {
                        case "Accounts":
                        case "Wallets":
                        case "Data":
                            tblCount++;
                            break;
                    }
                }

                close();
            return tblCount == 3;
            } else {
                DatabaseController.DatabaseInfo info = App.DB.getInfo();
                checkDatabase(info.getHost(), info.getUser(), info.getPass());
            }
        }
        return false;
    }

    /**
     * Check structure of a custom database
     * @param host
     * @param user
     * @param password
     * @return
     * @throws AppException
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    private boolean checkDatabase(String host, String user, String password) throws AppException, SQLException, ClassNotFoundException {
        int tblCount = 0;
        Class.forName(Constants.CONNECTION.getString("Driver"));
        Connection connect = DriverManager.getConnection(host, user, password);

        stm = connect.prepareStatement("SELECT TABLE_NAME as 'name' FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = 'BASE TABLE'");
        rs = stm.executeQuery();
        while (rs.next()) {
            switch (rs.getString("name")) {
                case "Accounts":
                case "Wallets":
                case "Data":
                    tblCount++;
                    break;
            }
        }

        connect.close();
        close();
        return tblCount == 3;
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
