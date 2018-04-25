package br.com.projetofinal.endpoint;

import br.com.projetofinal.model.Produtos;
import br.com.projetofinal.model.Student;
import br.com.projetofinal.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("produtos")
public class ProdutosEndpoint {

    private final ProdutosRepository produtosDAO;

    @Autowired
    public ProdutosEndpoint(ProdutosRepository produtosDAO){
        this.produtosDAO = produtosDAO;
    }

    @GetMapping(path="/{id}")
    public ResponseEntity getprodutosById(@PathVariable("id") Long id) {
        return new ResponseEntity(produtosDAO.findByName("Fernando"), HttpStatus.OK);
    }

    @GetMapping(path="/listall")
    public ResponseEntity list() {
        return new ResponseEntity<>(produtosDAO.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Produtos produto) {
        return new ResponseEntity<>(produtosDAO.save(produto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Produtos produto) {
        produtosDAO.save(produto);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
}
