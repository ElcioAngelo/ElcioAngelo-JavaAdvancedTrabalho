package com.example.TrabalhoJava.controller;

import com.example.TrabalhoJava.model.Curso;
import com.example.TrabalhoJava.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private String notFoundMessageId(Integer id){
        return "Nenhum curso com o id " + id + " Foi encontrado..";
    }

    @Autowired
    public CursoRepository repository;

    @GetMapping
    public List<Curso> getAll(){
        if(this.repository.findAll().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhum curso Encontrado..");
        }
    }

}
