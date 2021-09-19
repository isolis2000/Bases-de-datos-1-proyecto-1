package util;
import pojo.AccountsTableResponse;
import pojo.LoginResult;

import java.sql.*;

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

    public LoginResult loginCommand(String sqlStr, Connection conn) {
        LoginResult loginResult = new LoginResult();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStr);
            while (rs.next()){
                loginResult.setUsuario(rs.getString("Usuario"));
                loginResult.setPass(rs.getString("Pass"));
                loginResult.setValorDocumentoIdentidad(rs.getInt("ValorDocumentoIdentidad"));
                loginResult.setEsAdministrador(rs.getInt("EsAdministrador"));
                return loginResult;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginResult;
    }

    public AccountsTableResponse accountsCommand(String sqlStr, Connection conn) {
        AccountsTableResponse accountsTableResponse = new AccountsTableResponse();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStr);
            while (rs.next()){
                accountsTableResponse.setMoneda(rs.getString("Moneda"));
                accountsTableResponse.setTipoCuenta(rs.getString("TipoCuenta"));
                accountsTableResponse.setNumCuenta(rs.getInt("NumeroCuenta"));
                accountsTableResponse.setSaldo(rs.getInt("Saldo"));
                return accountsTableResponse;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountsTableResponse;
    }
}
