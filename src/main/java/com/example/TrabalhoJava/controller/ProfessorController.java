package com.example.TrabalhoJava.controller;

import com.example.TrabalhoJava.dto.ProfessorRequestDTO;
import com.example.TrabalhoJava.model.Professor;
import com.example.TrabalhoJava.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

    final String notFoundMessage (Integer id) {
        return "Nenhum professor com o id " + id + " Foi encontrado..";
    }

    @Autowired
    public ProfessorRepository repository;

    @GetMapping
    public List<Professor> findAll() {
        //Caso não encontre nenhum professor, jogue uma nova excessão.
        if(this.repository.findAll().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado nenhum professor..");
        }
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Integer id){
        Optional<Professor> professor = this.repository.findById(id);

        return professor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,notFoundMessage(id)));

    }

    @PostMapping
    public Professor save(@RequestBody ProfessorRequestDTO dto){
        Professor professor = new Professor();
        professor.setNome(dto.nome());
        professor.setEmail(dto.email());
        professor.setTelefone(dto.telefone());
        professor.setEspecialidade(dto.especialidade());

        return this.repository.save(professor);
    }

    @PutMapping("/{id}")
    public Professor findById(@PathVariable Integer id,
                              @RequestBody ProfessorRequestDTO dto){
        Professor professor =  this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,notFoundMessage(id)));

        professor.setNome(dto.nome());
        professor.setEmail(dto.email());
        professor.setTelefone(dto.telefone());
        professor.setEspecialidade(dto.especialidade());

        return this.repository.save(professor);
    }

    @DeleteMapping("/{id}")
    void delete (@PathVariable Integer id) {
        Professor professor = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,notFoundMessage(id)));
        this.repository.delete(professor);
    }
}
