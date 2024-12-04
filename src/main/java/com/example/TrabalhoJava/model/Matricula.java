package com.example.TrabalhoJava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.text.DecimalFormat;
import java.util.List;

@Entity
@Table(name = "matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "turma_id")
    private Turma turma;

    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Nota> notas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
