package br.com.projetofinal.endpoint;

import br.com.projetofinal.repository.ConnectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("connections")
public class ConnectionsEndpoint {

    private final ConnectionsRepository connectionsDAO;

    @Autowired
    public ConnectionsEndpoint(ConnectionsRepository connectionsDAO){
        this.connectionsDAO = connectionsDAO;
    }
}
