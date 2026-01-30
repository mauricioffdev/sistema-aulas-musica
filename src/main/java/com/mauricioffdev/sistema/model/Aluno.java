package com.mauricioffdev.sistema.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Max; // Importar
import jakarta.validation.constraints.Min; // Importar
import jakarta.validation.constraints.NotNull; // Importar
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode ficar vazio")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 letras")
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Digite um email válido (ex: nome@site.com)")
    private String email;

    // 1. ATUALIZAÇÃO DO TELEFONE
    @NotBlank(message = "O telefone é obrigatório")
    // Esse regex permite: Números, Espaços, (), - e +.
    // Ex aceitos: "(11) 99999-9999", "+1 555 1234", "999999999"
    @Pattern(regexp = "^[\\d\\s\\(\\)\\-\\+]+$", message = "Telefone inválido (Use apenas números, +, -, ou parênteses)")
    private String telefone;

    private String plano;

    // 2. NOVO CAMPO: DIA DO VENCIMENTO
    // Usamos Integer para poder fazer contas se precisar no futuro
    @NotNull(message = "Informe o dia do vencimento")
    @Min(value = 1, message = "O dia deve ser entre 1 e 31")
    @Max(value = 31, message = "O dia deve ser entre 1 e 31")
    private Integer diaVencimento;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aula> historicoAulas = new ArrayList<>();

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pagamento> pagamentos = new ArrayList<>();

    public Aluno() {
    }

    public Aluno(String nome, String email, String telefone, String plano) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.plano = plano;
    }

    // Getters e setters

    public Integer getDiaVencimento() { return diaVencimento; }

    public void setDiaVencimento(Integer diaVencimento) { this.diaVencimento = diaVencimento; }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public List<Aula> getHistoricoAulas() {
        return historicoAulas;
    }

    public void adicionarAula(Aula aula) {
        this.historicoAulas.add(aula);
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void adicionarPagamento(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
        pagamento.setAluno(this);  // importante manter sincronizado
    }

    public void setId(long id){
        this.id=id;
    }

    @Override
    public String toString() {
        return nome + " | " + plano + " | " + email + " | " + telefone;
    }

    
}
