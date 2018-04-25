package br.com.projetofinal.repository;

import br.com.projetofinal.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long > {
    List<Student> findByName(String name);
}
