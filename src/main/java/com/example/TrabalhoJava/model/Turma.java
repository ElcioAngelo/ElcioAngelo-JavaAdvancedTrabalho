package com.example.TrabalhoJava.model;

import com.example.TrabalhoJava.repository.TurmaRepository;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "turmas")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer ano;
    private Integer semestre;

   @ManyToOne
   @JoinColumn(name = "cursos_id")
   private Curso curso;

   @ManyToMany
   @JoinTable(
           name = "matriculas", // Nome da tabela intermediária
           joinColumns = @JoinColumn(name = "turma_id"), // A coluna que referencia a turma
           inverseJoinColumns = @JoinColumn(name = "aluno_id") // A coluna que referencia o aluno
   )
   private Set<Aluno> alunos;

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
