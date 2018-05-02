package br.com.projetofinal.endpoint;

import br.com.projetofinal.model.Connections;
import br.com.projetofinal.model.Produtos;
import br.com.projetofinal.repository.ConnectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static java.lang.Math.toIntExact;

import java.util.ArrayList;
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

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Connections connection) {

        List<Connections> lista;

        Iterable iterable = connectionsDAO.findAll();

        lista = (List<Connections>) iterable;
        connection.setId(lista.size() + 1);

        ResponseEntity aaaa = new ResponseEntity<>(connectionsDAO.save(connection), HttpStatus.OK);

        /*Criar list das conexões do ponto que está sendo incluído*/
        List<Integer> list = new ArrayList<>();
        for(String c: connection.getConnections().split(",")) {
            if(!c.isEmpty()){
                list.add(Integer.parseInt(c));
            }
        }

        Connections at;
        /*Atualizar as conexões desse ponto para que também tenha o ponto inserido
        * Pois se posso A->B também posso B->A*/
        for(Integer con: list){
            at = connectionsDAO.findById(con.longValue()).get();
            String value = at.getConnections();
            value = value + connection.getId() + ",";
            System.out.println(at.getId());
            System.out.println(at.getConnections());
            System.out.println(value);
            at.setConnections(value);
            connectionsDAO.save(at);
        }

        return aaaa;
    }
}
