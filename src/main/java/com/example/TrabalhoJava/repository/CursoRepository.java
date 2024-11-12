package com.example.TrabalhoJava.repository;

import com.example.TrabalhoJava.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
