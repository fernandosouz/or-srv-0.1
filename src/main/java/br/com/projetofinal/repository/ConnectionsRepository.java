package br.com.projetofinal.repository;

import br.com.projetofinal.model.Connections;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConnectionsRepository extends CrudRepository<Connections, Long> {
}
