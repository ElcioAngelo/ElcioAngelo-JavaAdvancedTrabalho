package com.example.TrabalhoJava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.AbstractList;

@Entity
@Table(name = "notas")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    @Column
    private BigDecimal nota;

    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public LocalDate getData() {
        return dataLancamento;
    }

    public void setData(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
