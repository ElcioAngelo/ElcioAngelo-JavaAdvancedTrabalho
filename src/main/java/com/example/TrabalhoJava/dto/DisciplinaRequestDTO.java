package com.example.TrabalhoJava.dto;

public record DisciplinaRequestDTO(Integer id, String nome, String codigo, CursoRequestDTO curso, ProfessorRequestDTO professor) {
}
