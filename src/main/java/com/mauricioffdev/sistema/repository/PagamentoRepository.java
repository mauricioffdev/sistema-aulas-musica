package com.mauricioffdev.sistema.repository;

import com.mauricioffdev.sistema.model.Aluno;
import com.mauricioffdev.sistema.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    // Metodo extra: Buscar pagamentos de UM aluno específico
    List<Pagamento> findByAluno(Aluno aluno);
}
