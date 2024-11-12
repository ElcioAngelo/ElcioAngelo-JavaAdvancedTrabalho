package com.example.TrabalhoJava.repository;

import com.example.TrabalhoJava.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}

