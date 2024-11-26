package com.example.TrabalhoJava.dto;

import com.example.TrabalhoJava.model.Aluno;
import com.example.TrabalhoJava.model.Curso;

import java.util.Set;

public record TurmaRequestDTO(Integer id, Integer ano, Integer semestre, com.example.TrabalhoJava.model.Curso cursos, Set<Aluno> alunos)  {
}
