package util;
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

    public LoginResult executeCommand(String sqlStr, Connection conn) {
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
        loginResult.setValorDocumentoIdentidad(0);
        return loginResult;
    }
}
