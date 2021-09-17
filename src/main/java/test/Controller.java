package test;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import util.Models;
import pojo.LoginResult;
import util.SQLConnections;

import java.sql.Connection;

@RestController
public class Controller {
    private final SQLConnections sqlConnections = new SQLConnections();

    @CrossOrigin
    @PostMapping(value = "/api", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResult> test(@RequestBody LoginResult loginResult) {
        Models models = new Models();
        System.out.println("Usuario: " + loginResult.getValorDocumentoIdentidad());
        Connection conn = sqlConnections.establishConnection();
        String command = "SELECT * FROM Usuario WHERE"
                + " Usuario = '" + loginResult.getUsuario()
                + "' AND Pass = '" + loginResult.getPass()
                + "' AND ValorDocumentoIdentidad = " + loginResult.getValorDocumentoIdentidad()
                + " AND EsAdministrador = " + loginResult.getEsAdministrador();
        System.out.println(command);
        return ResponseEntity.ok(sqlConnections.executeCommand(command, conn));
    }
}