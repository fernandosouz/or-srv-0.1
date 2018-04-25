package br.com.projetofinal.endpoint;

import br.com.projetofinal.model.Student;
import br.com.projetofinal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentEndPoint {

    private final StudentRepository studentDAO;

    @Autowired
    public StudentEndPoint(StudentRepository studentDAO){
        this.studentDAO = studentDAO;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(studentDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity getStudentById(@PathVariable("id") Long id) {

        return new ResponseEntity(studentDAO.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<?> findStudentByName(@PathVariable("name") String name){
        List<Student> student = studentDAO.findByName(name);
        return  new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student) {
        return new ResponseEntity<>(studentDAO.save(student), HttpStatus.OK);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        studentDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student) {
        studentDAO.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
