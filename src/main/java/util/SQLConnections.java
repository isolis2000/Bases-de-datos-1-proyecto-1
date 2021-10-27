package util;
import pojo.*;

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
                account.setPass(rs.getString("Password"));
                account.setValorDocumentoIdentidad(rs.getInt("ValorDocumentoIdentidad"));
                account.setEsAdministrador(rs.getInt("EsAdministrador"));
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

    public ArrayList<Beneficiary> getBeneficiaries(String sqlStr, Connection conn) {
        BeneficiaryList bl = new BeneficiaryList();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStr);
            while (rs.next()){
                Beneficiary beneficiary = new Beneficiary();
                beneficiary.setCuentaAsociada(rs.getInt("CuentaAsociada"));
                beneficiary.setNombre(rs.getString("Nombre"));
                beneficiary.setParentezco(rs.getString("Parentezco"));
                beneficiary.setPorcentaje(rs.getInt("Porcentaje"));
                bl.addToBeneficiaries(beneficiary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bl.getBeneficiaries();
    }

    public Percentage getPercentage(String sqlStr, Connection conn){
        Percentage percentage = new Percentage();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStr);
            while (rs.next()) {
                percentage.setPorcentaje(rs.getInt("PorcentajeTotal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return percentage;
    }

    public NumberOfBeneficiaries getNumberOfBeneficiaries(String sqlStr, Connection conn){
        NumberOfBeneficiaries numberOfBeneficiaries = new NumberOfBeneficiaries();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStr);
            while (rs.next()) {
                numberOfBeneficiaries.setCantidadDeBeneficiarios(rs.getInt("NumeroDeBeneficiarios"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numberOfBeneficiaries;
    }

    public ArrayList<SavingsAccountView> savingsTableQuery(String sqlStr, Connection conn){
        SavingsAccountList savingsAccountList = new SavingsAccountList();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStr);
            while (rs.next()){
                SavingsAccountView savingsAccountView = new SavingsAccountView();
                savingsAccountView.setNumeroCuentaAhorro(rs.getInt("NumeroCuentaAhorro"));
                savingsAccountView.setDescripcion(rs.getString("Descripcion"));
                savingsAccountView.setActivado(rs.getInt("Activado"));
                savingsAccountView.setFechaInicio(rs.getString("FechaInicio"));
                savingsAccountView.setFechaFin(rs.getString("FechaFin"));
                savingsAccountList.addToIndividualStatements(savingsAccountView);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return savingsAccountList.getIndividualStatements();
    }

    public ArrayList<AccountStatement> accountStatementsQuery(String sqlStr, Connection conn){
        AccountStatementList asl = new AccountStatementList();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStr);
            while (rs.next()){
                AccountStatement statement = new AccountStatement();
                statement.setFechaInicio(rs.getString("FechaInicio"));
                statement.setFechaFinal(rs.getString("FechaFinal"));
                statement.setSaldoMinimo(rs.getInt("SaldoMinimo"));
                statement.setSaldoInicio(rs.getInt("SaldoInicio"));
                statement.setSaldoFinal(rs.getInt("SaldoFinal"));
                statement.setOperacionesEnATM(rs.getInt("CantidadOperacionesATM"));
                statement.setOperacionEnCajeroHumano(rs.getInt("CantidadOperacionesHumano"));
                statement.setId(rs.getInt("Id"));
                asl.addToAccountsTableResponses(statement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asl.getAccountStatementArrayList();
    }

    public ArrayList<IndividualStatement> individualStatementsQuery(String sqlStr, Connection conn){
        IndividualStatementList isl = new IndividualStatementList();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStr);
            while (rs.next()){
                IndividualStatement statement = new IndividualStatement();
                statement.setDescripcion(rs.getString("Descripcion"));
                statement.setOperacion(rs.getInt("Operacion"));
                statement.setMoneda(rs.getString("Moneda"));
                statement.setVenta(rs.getInt("Venta"));
                statement.setCompra(rs.getInt("Compra"));
                statement.setMontoMonedaMovimiento(rs.getInt("MontoMonedaMovimiento"));
                statement.setMontoMonedaCuenta(rs.getInt("MontoMonedaCuenta"));
                statement.setNuevoSaldo(rs.getInt("NuevoSaldo"));
                statement.setFecha(rs.getString("Fecha"));
                isl.addToIndividualStatements(statement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isl.getIndividualStatements();
    }

    public void postQuery(String sqlStr, Connection conn){

        try {
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sqlStr);
        } catch (SQLException e) {
            System.out.println("query: " + sqlStr);
        }
    }
}
