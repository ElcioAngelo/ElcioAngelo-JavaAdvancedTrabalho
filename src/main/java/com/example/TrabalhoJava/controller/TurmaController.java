package com.example.TrabalhoJava.controller;

import com.example.TrabalhoJava.dto.CursoRequestDTO;
import com.example.TrabalhoJava.dto.TurmaRequestDTO;
import com.example.TrabalhoJava.model.Curso;
import com.example.TrabalhoJava.model.Matricula;
import com.example.TrabalhoJava.model.Turma;
import com.example.TrabalhoJava.repository.CursoRepository;
import com.example.TrabalhoJava.repository.MatriculaRepository;
import com.example.TrabalhoJava.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private MatriculaRepository matriculaRepository;

    @GetMapping
    public ResponseEntity<List<Turma>> findAll(){
        return ResponseEntity.ok(this.turmaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> findById(@PathVariable Integer id){
        return ResponseEntity.ok(this.turmaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

//    @PostMapping
//    public ResponseEntity<Turma> save(@RequestBody TurmaRequestDTO dto) {
//        Turma turma = new Turma();
//
//        turma.setAno(dto.ano());
//        turma.setAlunos(dto.alunos());
//        turma.setCurso(dto.cursos());
//        turma.setSemestre(dto.semestre());
//        turma.setAno(dto.ano());
//
//        return ResponseEntity.ok(this.turmaRepository.save(turma));
//    }

    @PostMapping("/{id}")
    public ResponseEntity<Turma> update(@RequestBody TurmaRequestDTO dto,
                      @PathVariable Integer id) {

        Curso curso = this.cursoRepository.findById(dto.cursos())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT,"Não foi encontrado nenhum curso.."));
        Turma turma = new Turma();
        turma.setAno(dto.ano());
        //turma.setAlunos(dto.alunos());
        turma.setCurso(curso);
        turma.setSemestre(dto.semestre());
        turma.setAno(dto.ano());

        return ResponseEntity.ok(this.turmaRepository.save(turma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Turma turma = this.turmaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Turma Não encontrada..."));

        List<Matricula> matriculas = matriculaRepository.findTurmaById(id);
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado nenhuma turma"));
        for (Matricula matricula : matriculas) {
            matricula.setTurma(null);  // Desassociar a turma
            matriculaRepository.save(matricula);  // Salvar a alteração
        }

        this.turmaRepository.delete(turma);
        return ResponseEntity.ok("Turma " + id + " Foi deletada..");
    }


}
