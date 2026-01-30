package com.mauricioffdev.sistema.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;
    private double valor;
    private String metodo;
    private String status;

    @ManyToOne
    @JoinColumn(name = "aluno_id")  // FK na tabela pagamento
    private Aluno aluno;

    public Pagamento() {
    }

    public Pagamento(LocalDate data, double valor, String metodo, String status) {
        this.data = data;
        this.valor = valor;
        this.metodo = metodo;
        this.status = status;
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "Data: " + data + ", Valor: R$" + valor + ", Método: " + metodo + ", Status: " + status;
    }
}
