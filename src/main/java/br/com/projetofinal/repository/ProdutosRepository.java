package br.com.projetofinal.repository;

import br.com.projetofinal.model.Produtos;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutosRepository extends CrudRepository<Produtos, Long > {
    List<Produtos> findByName(String name);
}
