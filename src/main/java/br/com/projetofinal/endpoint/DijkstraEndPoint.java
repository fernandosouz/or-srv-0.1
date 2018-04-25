package br.com.projetofinal.endpoint;
import br.com.projetofinal.Dijkstra;
import br.com.projetofinal.repository.ConnectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("dijkstra")
public class DijkstraEndPoint {

    private final ConnectionsRepository connectionsDAO;

    @Autowired
    public DijkstraEndPoint(ConnectionsRepository connectionsDAO){
        this.connectionsDAO = connectionsDAO;
    }

    @RequestMapping(value="/{inicio}/{fim}", method= RequestMethod.GET)
    public @ResponseBody
    String searchByVertices(@PathVariable Integer inicio, @PathVariable Integer fim) {
        System.out.println("Buscando caminho com início: " + inicio + " e final em: "+fim);
        StringBuilder a;
        a = new Dijkstra(connectionsDAO).printShortestPath(inicio, fim, connectionsDAO);
        System.out.println("Resultado: " + a);
        return a.toString();
    }
}
