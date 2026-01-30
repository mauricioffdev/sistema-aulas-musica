package com.mauricioffdev.sistema.service;

import com.mauricioffdev.sistema.model.Pagamento;
import com.mauricioffdev.sistema.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

// Classe "Gerente" que grava os pagamentos.

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Transactional
    public void registrarPagamento(Pagamento pagamento) {
        repository.save(pagamento);
    }

    public List<Pagamento> listarTodos() {
        return repository.findAll();
    }
}