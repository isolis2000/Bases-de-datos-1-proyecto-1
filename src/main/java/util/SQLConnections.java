package util;
import pojo.AccountsTableResponse;
import pojo.AccountsTableResponseList;
import pojo.Account;

import java.sql.*;
import java.util.ArrayList;

public class SQLConnections {
    private String dbURL;

    public String getDbURL() {
        return dbURL;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    public Connection establishConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dbURL = "jdbc:sqlserver://localhost;databaseName=basesDB;" +
                    "user=sa;password=Admin123";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null){
                System.out.println("Connected");
                return conn;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account verifyLogin(String sqlStr, Connection conn) {
        Account account = new Account();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStr);
            while (rs.next()){
                account.setUsuario(rs.getString("Usuario"));
                account.setPass(rs.getString("Pass"));
                account.setValorDocumentoIdentidad(rs.getInt("ValorDocumentoIdentidad"));
                account.setEsAdministrador(rs.getInt("EsAdministrador"));
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public ArrayList<AccountsTableResponse> getAccounts(String sqlStr, Connection conn) {
        AccountsTableResponseList actr = new AccountsTableResponseList();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStr);
            while (rs.next()){
                AccountsTableResponse accountsTableResponse = new AccountsTableResponse();
                accountsTableResponse.setMoneda(rs.getString("Moneda"));
                accountsTableResponse.setTipoCuenta(rs.getString("TipoCuenta"));
                accountsTableResponse.setNumCuenta(rs.getInt("NumeroCuenta"));
                accountsTableResponse.setSaldo(rs.getInt("Saldo"));
                actr.addToAccountsTableResponses(accountsTableResponse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actr.getAccountsTableResponses();
    }

//    public ArrayList<Account> getAdminAccounts(String sqlStr, Connection conn) {
//        AccountList accountList = new AccountList();
//        try {
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sqlStr);
//            while (rs.next()){
//                Account account = new Account();
//                account.setMoneda(rs.getString("Moneda"));
//                account.setTipoCuenta(rs.getString("TipoCuenta"));
//                account.setNumCuenta(rs.getInt("NumeroCuenta"));
//                account.setSaldo(rs.getInt("Saldo"));
//                accountList.addToAccounts(account);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return accountList.getAccounts();
//    }
}
