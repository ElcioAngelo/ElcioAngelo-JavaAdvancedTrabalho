package com.example.TrabalhoJava.dto;

import com.example.TrabalhoJava.model.Curso;

public record TurmaRequestDTO(Integer id, Integer ano, Integer semestre, Curso curso) {
}
