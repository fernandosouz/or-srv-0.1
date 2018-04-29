package br.com.projetofinal.endpoint;

import br.com.projetofinal.model.Connections;
import br.com.projetofinal.repository.ConnectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("connections")
public class ConnectionsEndpoint {

    private final ConnectionsRepository connectionsDAO;

    @Autowired
    public ConnectionsEndpoint(ConnectionsRepository connectionsDAO){
        this.connectionsDAO = connectionsDAO;
    }

    @GetMapping(path="/listall")
    public ResponseEntity list() {
        return new ResponseEntity<>(connectionsDAO.findAll(), HttpStatus.OK);
    }
}
