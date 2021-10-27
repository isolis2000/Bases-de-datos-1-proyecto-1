package test;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pojo.*;
import util.SQLConnections;

import java.sql.Connection;
import java.util.ArrayList;

@RestController()
@RequestMapping(path = "/api")
public class Controller {
    private final SQLConnections sqlConnections = new SQLConnections();

    @CrossOrigin
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> loginRequest(@RequestBody Account account) {
        Connection conn = sqlConnections.establishConnection();
        String command = "EXEC sp_VerificarLogin"
                + " @inUsuario = '" + account.getUsuario()
                + "', @inPass = '" + account.getPass()
                + "', @inEsAdministrador = " + account.getEsAdministrador();
        System.out.println(command);
        return ResponseEntity.ok(sqlConnections.verifyLogin(command, conn));
    }

    @CrossOrigin
    @PostMapping(value = "/accountsTable", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccountsTableResponse>> accountsTableRequest(@RequestBody AccountsTableRequest accountsTableRequest){
        Connection conn = sqlConnections.establishConnection();
        String command = "EXEC sp_TablaCuentas " +
                "@inUsuario = '" + accountsTableRequest.getUsuario() + "'";
        return ResponseEntity.ok(sqlConnections.getAccounts(command, conn));
    }

    @CrossOrigin
    @GetMapping(value = "/adminAccountsTable")
    public ResponseEntity<ArrayList<AccountsTableResponse>> adminAccountsTableRequest() {
        Connection conn = sqlConnections.establishConnection();
        String command = "EXEC sp_TablaCuentasAdmin";
        return ResponseEntity.ok(sqlConnections.getAccounts(command, conn));
    }

    @CrossOrigin
    @PostMapping(value = "/beneficiaries", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<Beneficiary>> adminAccountsTableRequest(@RequestBody BeneficiaryRequest beneficiaryRequest) {
        Connection conn = sqlConnections.establishConnection();
        String command = "Exec sp_Beneficiarios " +
                "@Usuario = '" + beneficiaryRequest.getUsuario() + "'";
        return ResponseEntity.ok(sqlConnections.getBeneficiaries(command, conn));
    }

    @CrossOrigin
    @PostMapping(value = "/beneficiariesForAccount", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<Beneficiary>> adminAccountsTableRequest(@RequestBody AccountRequest bpar) {
        Connection conn = sqlConnections.establishConnection();
        String command = "EXEC sp_BeneficiariosPorCuenta " +
                "@Cuenta = " + bpar.getNumeroCuenta();
        return ResponseEntity.ok(sqlConnections.getBeneficiaries(command, conn));
    }

    @CrossOrigin
    @PostMapping(value = "/addBeneficiary", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBeneficiary(@RequestBody BeneficiaryModifiable bM) {
        Connection conn = sqlConnections.establishConnection();
        String command = "EXEC sp_InsertarBeneficiario " +
                "@NumeroCuenta = " + bM.getNumeroCuenta() +
                ", @ValorDocumentoIdentidadBeneficiario = " + bM.getValorDocumentoIdentidadBeneficiario() +
                ", @ParentezcoId = " + bM.getParentezcoId() +
                ", @Porcentaje = " + bM.getPorcentaje();
        sqlConnections.postQuery(command, conn);
    }

    @CrossOrigin
    @PostMapping(value = "/modifyBeneficiary", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void modifyBeneficiary(@RequestBody BeneficiaryModifiable bM) {
        Connection conn = sqlConnections.establishConnection();
        String command = "EXEC sp_ModificarBeneficiario " +
                "@NumeroCuenta = " + bM.getNumeroCuenta() +
                ", @ValorDocumentoIdentidadBeneficiario = " + bM.getValorDocumentoIdentidadBeneficiario() +
                ", @ParentezcoId = " + bM.getParentezcoId() +
                ", @Porcentaje = " + bM.getPorcentaje();
        sqlConnections.postQuery(command, conn);
    }

    @CrossOrigin
    @PostMapping(value = "/removeBeneficiary", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void adminAccountsTableRequest(@RequestBody BeneficiaryModifiable bM) {
        Connection conn = sqlConnections.establishConnection();
        String command = "EXEC sp_EliminarBeneficiario " +
                "@NumeroCuenta = " + bM.getNumeroCuenta() +
                ", @ValorDocumentoIdentidadBeneficiario = " + bM.getValorDocumentoIdentidadBeneficiario() +
                ", @ParentezcoId = " + bM.getParentezcoId() +
                ", @Porcentaje = " + bM.getPorcentaje();
        sqlConnections.postQuery(command, conn);
    }

    @CrossOrigin
    @PostMapping(value = "/totalPercentage", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Percentage> totalPercentage(@RequestBody AccountRequest accountRequest) {
        Connection conn = sqlConnections.establishConnection();
        String command = "EXEC sp_ObtenerPorcentajeTotalPorCuenta " +
                "@Cuenta = " + accountRequest.getNumeroCuenta();
        return ResponseEntity.ok(sqlConnections.getPercentage(command, conn));
    }

    @CrossOrigin
    @PostMapping(value = "/numberOfBeneficiaries", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NumberOfBeneficiaries> numberOfBeneficiaries(@RequestBody AccountRequest accountRequest) {
        Connection conn = sqlConnections.establishConnection();
        String command = "EXEC sp_ObtenerNumeroBeneficiariosPorCuenta " +
                "@Cuenta = " + accountRequest.getNumeroCuenta();
        return ResponseEntity.ok(sqlConnections.getNumberOfBeneficiaries(command, conn));
    }

    @CrossOrigin
    @PostMapping(value = "/accountStatements", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccountStatement>> accountStatements(@RequestBody AccountStatementRequest accountStatementRequest) {
        Connection conn = sqlConnections.establishConnection();
        String command = "exec sp_ObtenerEstadosDeCuenta " +
                "@inCuenta = " + accountStatementRequest.getCuenta();
        return ResponseEntity.ok(sqlConnections.accountStatementsQuery(command, conn));
    }

    @CrossOrigin
    @PostMapping(value = "/individualStatements", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<IndividualStatement>> individualStatements(@RequestBody IndividualStatementRequest individualStatementRequest) {
        Connection conn = sqlConnections.establishConnection();
        System.out.println("id: " + individualStatementRequest.getId());
        String command = "exec sp_ObtenerMovimientosDeEstadosDeCuenta " +
                "@idEstado = " + individualStatementRequest.getId();
        return ResponseEntity.ok(sqlConnections.individualStatementsQuery(command, conn));
    }

    @CrossOrigin
    @PostMapping(value = "/savingsTable", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<SavingsAccountView>> savingsTable(@RequestBody AccountRequest accountRequest) {
        Connection conn = sqlConnections.establishConnection();
        String command = "exec sp_VerCuentasAhorro " +
                "@inNumeroCuenta = " + accountRequest.getNumeroCuenta();
        return ResponseEntity.ok(sqlConnections.savingsTableQuery(command, conn));
    }

    @CrossOrigin
    @PostMapping(value = "/addSavingsTable", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void addSavingsTable(@RequestBody SavingsAccount savingsAccount) {
        Connection conn = sqlConnections.establishConnection();
        String command = "exec sp_AbrirCuentaAhorro" +
                " @inNumeroCuenta = " + savingsAccount.getNumeroCuenta() +
                " ,@inNumeroCuentaAhorro = " + savingsAccount.getNumeroCuentaAhorro() +
                " ,@inDescripcion = '" + savingsAccount.getDescripcion() +
                "' ,@inActivado = " + savingsAccount.getActivado() +
                " ,@inFechaInicio = '" + savingsAccount.getFechaInicio() +
                "' ,@inFechaFinal = " + savingsAccount.getFechaFinal() + "'";
        sqlConnections.postQuery(command, conn);
    }

    @CrossOrigin
    @PostMapping(value = "/editSavingsTable", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void editSavingsTable(@RequestBody SavingsAccount savingsAccount) {
        Connection conn = sqlConnections.establishConnection();
        String command = "exec sp_ModificarCuentaAhorro" +
                " @inNumeroCuenta = " + savingsAccount.getNumeroCuenta() +
                " ,@inNumeroCuentaAhorro = " + savingsAccount.getNumeroCuentaAhorro() +
                " ,@inDescripcion = '" + savingsAccount.getDescripcion() +
                "' ,@inActivado = " + savingsAccount.getActivado() +
                " ,@inFechaInicio = '" + savingsAccount.getFechaInicio() +
                "' ,@inFechaFinal = " + savingsAccount.getFechaFinal() + "'";
        sqlConnections.postQuery(command, conn);
    }

    @CrossOrigin
    @PostMapping(value = "/deleteSavingsTable", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSavingsTable(@RequestBody SavingsAccount savingsAccount) {
        Connection conn = sqlConnections.establishConnection();
        String command = "exec sp_DesactivarCuentaAhorro" +
                " @inNumeroCuenta = " + savingsAccount.getNumeroCuenta() +
                " ,@inNumeroCuentaAhorro = " + savingsAccount.getNumeroCuentaAhorro();
        sqlConnections.postQuery(command, conn);
    }
}