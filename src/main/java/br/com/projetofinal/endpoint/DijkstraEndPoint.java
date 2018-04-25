package br.com.projetofinal.endpoint;

import br.com.projetofinal.Dijkstra;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("dijkstra")
public class DijkstraEndPoint {



    @RequestMapping(value="/{inicio}/{fim}", method= RequestMethod.GET)
    public @ResponseBody
    String searchByVertices(@PathVariable Integer inicio, @PathVariable Integer fim) {

        //Perform logic with foo
        System.out.println("Buscando caminho com início: " + inicio + " e final em: "+fim);
        StringBuilder a;
        a = new Dijkstra().printShortestPath(inicio, fim);
        System.out.println("Resultado: " + a);
        return a.toString();
    }
}
