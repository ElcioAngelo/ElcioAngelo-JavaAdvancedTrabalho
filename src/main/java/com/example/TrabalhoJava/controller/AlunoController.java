package com.example.TrabalhoJava.controller;

import com.example.TrabalhoJava.dto.AlunoRequestDTO;
import com.example.TrabalhoJava.model.Aluno;
import com.example.TrabalhoJava.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    //Rota para encontrar todos os alunos
    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        //Caso não encontre nenhum aluno, jogue uma nova Excessão.
        if(this.repository.findAll().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Não foi encontrado nenhum aluno, cadastre alguns");
        }
        return ResponseEntity.ok(this.repository.findAll());
    }

    //Rota para encontrar os alunos pelo ID.
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
            Optional<Aluno> aluno = repository.findById(id);
            return aluno.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    //Caso não encontre o aluno, jogue uma nova excessão.
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno não encontrado.."));
    }

    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody AlunoRequestDTO dto) {
            Aluno aluno = new Aluno();
            aluno.setNome(dto.nome());
            aluno.setEmail(dto.email());
            aluno.setData_nascimento(dto.data_nascimento());
            
            return ResponseEntity.ok(this.repository.save(aluno));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Integer id,
                        @RequestBody AlunoRequestDTO dto){
        Aluno aluno = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado.."));

        aluno.setNome(dto.nome());
        aluno.setEmail(dto.email());
        aluno.setData_nascimento(dto.data_nascimento());

        return ResponseEntity.ok(this.repository.save(aluno));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Aluno aluno = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno não encontrado..."));
        this.repository.delete(aluno);
        return ResponseEntity.ok().body("O ALuno " + aluno.getNome() + " Foi deletado com sucesso");
    }

}
