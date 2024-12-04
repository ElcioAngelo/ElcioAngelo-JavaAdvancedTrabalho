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


    @Autowired
    public ProfessorRepository repository;

    @GetMapping
    public ResponseEntity<List<Professor>> findAll() {
        //Caso não encontre nenhum professor, jogue uma nova excessão.
        if(this.repository.findAll().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado nenhum professor..");
        }
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Integer id){
        Professor professor = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado nenhum professor com o id " + id));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping
    public ResponseEntity<Professor> save(@RequestBody ProfessorRequestDTO dto){
        Professor professor = new Professor();
        professor.setNome(dto.nome());
        professor.setEmail(dto.email());
        professor.setTelefone(dto.telefone());
        professor.setEspecialidade(dto.especialidade());

        return ResponseEntity.ok(this.repository.save(professor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Integer id,
                                              @RequestBody ProfessorRequestDTO dto){
       Professor professor =  this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado Nenhum professor.."));

        professor.setNome(dto.nome());
        professor.setEmail(dto.email());
        professor.setTelefone(dto.telefone());
        professor.setEspecialidade(dto.especialidade());

        return ResponseEntity.ok(this.repository.save(professor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable Integer id) {
        Professor professor = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhum professor foi encontrado.."));
        return ResponseEntity.ok("O professor " + professor.getNome() + "Foi deletado com sucesso..");
    }
}
