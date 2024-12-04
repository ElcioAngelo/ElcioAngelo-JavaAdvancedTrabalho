package com.example.TrabalhoJava.controller;

import com.example.TrabalhoJava.dto.CursoRequestDTO;
import com.example.TrabalhoJava.dto.DisciplinaRequestDTO;
import com.example.TrabalhoJava.model.Curso;
import com.example.TrabalhoJava.model.Disciplina;
import com.example.TrabalhoJava.model.Professor;
import com.example.TrabalhoJava.repository.CursoRepository;
import com.example.TrabalhoJava.repository.DisciplinaRepository;
import com.example.TrabalhoJava.repository.ProfessorRepository;
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
    private CursoRepository repository;

    @Autowired
    private DisciplinaRepository disciRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<List<Curso>> getAll() {
        if (this.repository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum curso Encontrado..");
        }
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Integer id) {
        Optional<Curso> curso = repository.findById(id);
        return curso.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, notFoundMessageId(id)));
    }

    @PostMapping
    public ResponseEntity<Curso> save(@RequestBody CursoRequestDTO dto) {
        Curso curso = new Curso();
        curso.setNome(dto.nome());
        curso.setCodigo(dto.codigo());
        curso.setCarga_horaria(dto.carga_horaria());

        return ResponseEntity.ok(this.repository.save(curso));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Curso> save(@RequestBody CursoRequestDTO dto,
                      @PathVariable Integer id) {

        Curso curso = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, notFoundMessageId(id)));

        curso.setNome(dto.nome());
        curso.setCodigo(dto.codigo());
        curso.setCarga_horaria(dto.carga_horaria());

        return ResponseEntity.ok(this.repository.save(curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> delete(@PathVariable Integer id){
        Curso curso = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,notFoundMessageId(id)));

        this.repository.delete(curso);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/disciplina/{id}")
    public ResponseEntity<Disciplina>  findDisciplina(@PathVariable Integer id){
        Disciplina disciplina = this.disciRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado nenhuma disciplina com o id: " + id));
        return ResponseEntity.ok(disciplina);
    }

    @PostMapping("/disciplina/{id}")
    public ResponseEntity<Disciplina> updateDisciplina(@PathVariable Integer id,
                                                       @RequestBody DisciplinaRequestDTO dto) {
        Disciplina disciplina = this.disciRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado nenhuma disciplina com o id: " + id));
        Professor professor = this.professorRepository.findById(dto.professor())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado nenhum professor com o id: " + dto.professor()));
        Curso curso = this.cursoRepository.findById(dto.curso())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado nenhum Curso com o id: " + dto.curso()));


        disciplina.setCurso(curso);
        disciplina.setNome(dto.nome());
        disciplina.setCodigo(dto.codigo());
        disciplina.setProfessor(professor);

        return ResponseEntity.ok(this.disciRepository.save(disciplina));
    }

    @PostMapping("/disciplina")
    public ResponseEntity<Disciplina> addDisciplina(@RequestBody DisciplinaRequestDTO dto) {
        Disciplina disciplina = new Disciplina();
        Professor professor = this.professorRepository.findById(dto.professor())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado nenhum professor com o id: " + dto.professor()));
        Curso curso = this.cursoRepository.findById(dto.curso())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado nenhum Curso com o id: " + dto.curso()));


        disciplina.setCurso(curso);
        disciplina.setNome(dto.nome());
        disciplina.setCodigo(dto.codigo());
        disciplina.setProfessor(professor);

        return ResponseEntity.ok(this.disciRepository.save(disciplina));
    }

    @DeleteMapping("/disciplina/{id}")
    public ResponseEntity<String> deleteDisciplina(@PathVariable Integer id) {
        Disciplina disciplina = this.disciRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado nenhuma disciplina com o id: " + id));

        this.disciRepository.delete(disciplina);
        return ResponseEntity.ok("Disciplina: " + disciplina.getNome() + " foi deletada com sucesso.");
    }
}


