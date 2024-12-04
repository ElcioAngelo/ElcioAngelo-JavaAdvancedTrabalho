package com.example.TrabalhoJava.controller;

import com.example.TrabalhoJava.dto.MatriculaRequestDTO;
import com.example.TrabalhoJava.model.Aluno;
import com.example.TrabalhoJava.model.Matricula;
import com.example.TrabalhoJava.model.Nota;
import com.example.TrabalhoJava.model.Turma;
import com.example.TrabalhoJava.repository.AlunoRepository;
import com.example.TrabalhoJava.repository.MatriculaRepository;
import com.example.TrabalhoJava.repository.NotaRepository;
import com.example.TrabalhoJava.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaRepository repository;
    @Autowired
    private NotaRepository NotaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;


    @GetMapping
    public ResponseEntity<List<Matricula>> findALl() {
        List<Matricula> matriculas = this.repository.findAll();
        if (matriculas.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Não foi encontrado nenhuma Mátricula");
        }
        return ResponseEntity.ok(matriculas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> findById(@PathVariable Integer id) {
        Matricula matricula = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado nenhuma Matricula.."));
        return ResponseEntity.ok(matricula);
    }

    @PostMapping
    public ResponseEntity<Matricula> create(@RequestBody MatriculaRequestDTO dto) {
        Matricula matricula = new Matricula();
        Turma turma = this.turmaRepository.findById(dto.turma())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado nenhuma turma"));
        Aluno aluno = this.alunoRepository.findById(dto.aluno())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado nenhum aluno"));
        matricula.setTurma(turma);
        matricula.setAluno(aluno);

        return ResponseEntity.ok(matricula);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Matricula> create(@PathVariable Integer id,
                                            @RequestBody MatriculaRequestDTO dto) {
        Matricula matricula = new Matricula();
        Turma turma = this.turmaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado nenhuma turma"));
        Aluno aluno = this.alunoRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado nenhum aluno"));
        matricula.setTurma(turma);
        matricula.setAluno(aluno);

        return ResponseEntity.ok(matricula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        Aluno aluno = this.alunoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado nenhum aluno"));
        Matricula matricula = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado nenhuma Matricula.."));
        this.repository.delete(matricula);
        return ResponseEntity.ok("A matricula do aluno " + aluno.getNome() + " Foi excluida com sucesso!");
    }

}
