package test;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import util.Models;
import util.POJO;
import util.SQLConnections;

import java.sql.Connection;

@RestController
public class Controller {
    private SQLConnections sqlConnections = new SQLConnections();

    @CrossOrigin
    @PostMapping(value = "/api", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public POJO test(POJO pojo) {
        pojo.setID(3);
        Models models = new Models();
        Connection conn = sqlConnections.establishConnection();
        String command = "SELECT * FROM TEST_TABLE";
        sqlConnections.executeCommand(command, conn);
        return pojo;
    }
}