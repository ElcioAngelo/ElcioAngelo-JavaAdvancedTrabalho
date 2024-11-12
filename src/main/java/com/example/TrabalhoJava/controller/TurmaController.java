package com.example.TrabalhoJava.controller;

import com.example.TrabalhoJava.dto.TurmaRequestDTO;
import com.example.TrabalhoJava.model.Turma;
import com.example.TrabalhoJava.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    private String messageNotFoundById(Integer id){
        return "A turma com o id " + id + " Não foi encontrada.";
    }

    @Autowired
    public TurmaRepository repository;

    @GetMapping
    public List<Turma> getAll(){
        if(this.repository.findAll().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"Não foi encontrado nenhuma Turma..");
        }

       return this.repository.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> findById(@PathVariable Integer id){
        Turma turma = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,messageNotFoundById(id)));

        return new ResponseEntity<>(turma,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Turma> save(@RequestBody TurmaRequestDTO dto) {
        Turma turma = new Turma();
        turma.setAno(dto.ano());
        turma.setCurso(dto.curso());
        turma.setSemestre(dto.semestre());

        return new ResponseEntity<>(this.repository.save(turma),HttpStatus.OK);
    }
}
