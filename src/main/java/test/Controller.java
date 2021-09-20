package test;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pojo.AccountsTableRequest;
import pojo.AccountsTableResponse;
import pojo.Account;
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
}