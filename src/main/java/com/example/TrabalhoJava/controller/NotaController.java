package com.example.TrabalhoJava.controller;
import com.example.TrabalhoJava.model.Nota;
import com.example.TrabalhoJava.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api/notas")
public class NotaController {

    private String notFoundMessage(){
        return "Não foi encontrada nenhuma nota..";
    }

    @Autowired
    private NotaRepository repository;

    @GetMapping
    public ResponseEntity<List<Nota>> findAll(){
        List<Nota> nota = this.repository.findAll();
        if(nota.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,notFoundMessage());
        }

        return ResponseEntity.ok(nota);
    }
}
