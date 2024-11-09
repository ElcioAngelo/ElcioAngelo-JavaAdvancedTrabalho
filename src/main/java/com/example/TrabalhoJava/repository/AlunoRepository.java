package com.example.TrabalhoJava.repository;

import com.example.TrabalhoJava.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    Optional<Aluno> findByEmail(String email);
}
