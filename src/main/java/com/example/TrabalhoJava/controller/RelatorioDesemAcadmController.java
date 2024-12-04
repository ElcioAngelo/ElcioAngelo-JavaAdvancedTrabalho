package com.example.TrabalhoJava.controller;

import com.example.TrabalhoJava.model.Aluno;
import com.example.TrabalhoJava.model.Nota;
import com.example.TrabalhoJava.repository.AlunoRepository;
import com.example.TrabalhoJava.repository.DisciplinaRepository;
import com.example.TrabalhoJava.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/RelatorioAcademico")
public class RelatorioDesemAcadmController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private NotaRepository notaRepository;

//    @GetMapping
//    public ResponseEntity<List<Nota>> findNotaPorAluno(@PathVariable Integer id){
//        List<Nota> notas = this.notaRepository.findByStudentId(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"ALuno com o id " + id +" Não foi encontrado.."));
//        return ResponseEntity.ok(notas);
//    }


}
