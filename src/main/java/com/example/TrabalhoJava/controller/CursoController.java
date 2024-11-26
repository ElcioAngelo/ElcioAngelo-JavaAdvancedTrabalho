package com.example.TrabalhoJava.controller;

import com.example.TrabalhoJava.dto.CursoRequestDTO;
import com.example.TrabalhoJava.model.Curso;
import com.example.TrabalhoJava.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private String notFoundMessageId(Integer id) {
        return "Nenhum curso com o id " + id + " Foi encontrado..";
    }

    @Autowired
    public CursoRepository repository;

    @GetMapping
    public List<Curso> getAll() {
        if (this.repository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum curso Encontrado..");
        }
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Integer id) {
        Optional<Curso> curso = repository.findById(id);
        return curso.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, notFoundMessageId(id)));
    }

    @PostMapping
    public Curso save(@RequestBody CursoRequestDTO dto) {
        Curso curso = new Curso();
        curso.setNome(dto.nome());
        curso.setCodigo(dto.codigo());
        curso.setCarga_horaria(dto.carga_horaria());

        return this.repository.save(curso);
    }

    @PostMapping("/{id}")
    public Curso save(@RequestBody CursoRequestDTO dto,
                      @PathVariable Integer id) {

        Curso curso = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, notFoundMessageId(id)));

        curso.setNome(dto.nome());
        curso.setCodigo(dto.codigo());
        curso.setCarga_horaria(dto.carga_horaria());

        return this.repository.save(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> delete(@PathVariable Integer id){
        Curso curso = this.repository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,notFoundMessageId(id)));

        this.repository.delete(curso);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
