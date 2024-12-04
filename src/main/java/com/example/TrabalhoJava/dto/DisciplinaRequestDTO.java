package com.example.TrabalhoJava.dto;

import com.example.TrabalhoJava.model.Curso;
import com.example.TrabalhoJava.model.Professor;

public record DisciplinaRequestDTO(Integer id, String nome, String codigo, Integer curso, Integer professor) {
}
