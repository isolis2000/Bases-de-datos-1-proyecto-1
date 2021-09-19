package test;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pojo.AccountsTableRequest;
import pojo.AccountsTableResponseList;
import util.Models;
import pojo.LoginResult;
import util.SQLConnections;

import java.sql.Connection;

@RestController()
@RequestMapping(path = "/api", consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {
    private final SQLConnections sqlConnections = new SQLConnections();

    @CrossOrigin
    @PostMapping(value = "/login")
    public ResponseEntity<LoginResult> loginRequest(@RequestBody LoginResult loginResult) {
        Models models = new Models();
        Connection conn = sqlConnections.establishConnection();
        String command = "EXEC sp_VerifyLogin"
                + " @Usuario = '" + loginResult.getUsuario()
                + "', @Pass = '" + loginResult.getPass()
                + "', @EsAdministrador = " + loginResult.getEsAdministrador();
        System.out.println(command);
        return ResponseEntity.ok(sqlConnections.loginCommand(command, conn));
    }

    @CrossOrigin
    @PostMapping(value = "/accountsTable")
    public ResponseEntity<AccountsTableResponseList> accountsTableRequest(@RequestBody AccountsTableRequest accountsTableRequest){
        Connection conn = sqlConnections.establishConnection();
        String command = "EXEC sp_AccountsTableClient " +
                "@Usuario = '" + accountsTableRequest.getUsuario() + "'";
        System.out.println(command);
        return ResponseEntity.ok(sqlConnections.accountsCommand(command, conn));
    }
}