package com.example.TrabalhoJava.dto;

import java.time.LocalDate;

public record AlunoRequestDTO(Integer id, String nome, String email, String matricula, LocalDate data_nascimento) {
}

