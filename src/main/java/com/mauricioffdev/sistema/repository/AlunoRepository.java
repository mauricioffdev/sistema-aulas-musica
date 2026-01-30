package com.mauricioffdev.sistema.repository;

import com.mauricioffdev.sistema.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Aluno findByNome(String nome);
}
