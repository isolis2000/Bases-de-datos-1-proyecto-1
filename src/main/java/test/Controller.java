package test;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
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
        String command = "EXEC sp_VerifyLogin"
                + " @Usuario = '" + account.getUsuario()
                + "', @Pass = '" + account.getPass()
                + "', @EsAdministrador = " + account.getEsAdministrador();
        System.out.println(command);
        return ResponseEntity.ok(sqlConnections.verifyLogin(command, conn));
    }

    @CrossOrigin
    @PostMapping(value = "/accountsTable", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccountsTableResponse>> accountsTableRequest(@RequestBody AccountsTableRequest accountsTableRequest){
        Connection conn = sqlConnections.establishConnection();
        String command = "EXEC sp_AccountsTableClient " +
                "@Usuario = '" + accountsTableRequest.getUsuario() + "'";
        System.out.println(command);
        return ResponseEntity.ok(sqlConnections.getAccounts(command, conn));
    }

    @CrossOrigin
    @GetMapping(value = "/adminAccountsTable")
    public ResponseEntity<ArrayList<AccountsTableResponse>> adminAccountsTableRequest() {
        Connection conn = sqlConnections.establishConnection();
        String command = "EXEC sp_AccountsTableAdmin";
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
    public ResponseEntity<ArrayList<Beneficiary>> adminAccountsTableRequest(@RequestBody BeneficiariesPerAccountRequest bpar) {
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
}