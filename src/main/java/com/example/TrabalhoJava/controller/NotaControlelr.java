package com.example.TrabalhoJava.controller;

import com.example.TrabalhoJava.model.Nota;
import com.example.TrabalhoJava.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
public class NotaControlelr {

    @Autowired
    private NotaRepository repository;

    @PostMapping
    public ResponseEntity<List<Nota>> findAll(){
        List<Nota> nota = this.repository.findAll();
        if(nota.isEmpty()){

        }
    }
}
