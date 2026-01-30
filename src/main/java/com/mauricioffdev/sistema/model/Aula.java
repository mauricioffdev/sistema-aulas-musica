package com.mauricioffdev.sistema.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;
    private String conteudo;
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "aluno_id")  //tabela aula
    private Aluno aluno;

    public Aula() {
    }

    public Aula(LocalDate data, String conteudo, String observacoes) {
        this.data = data;
        this.conteudo = conteudo;
        this.observacoes = observacoes;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "Data: " + data + ", Conteúdo: " + conteudo + ", Observações: " + observacoes;
    }
}
