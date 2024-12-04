package com.example.TrabalhoJava.dto;

import com.example.TrabalhoJava.model.Aluno;
import com.example.TrabalhoJava.model.Turma;

public record MatriculaRequestDTO(Integer id, Integer aluno, Integer turma) {
}
