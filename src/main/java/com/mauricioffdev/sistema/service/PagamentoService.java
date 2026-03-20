package com.mauricioffdev.sistema.service;

import com.mauricioffdev.sistema.model.Pagamento;
import com.mauricioffdev.sistema.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    // Listar todos
    public List<Pagamento> listarTodos() {
        return repository.findAll();
    }

    // Registrar/Salvar (Salva novo ou atualiza se o ID já existir)
    public void registrarPagamento(Pagamento pagamento) {
        repository.save(pagamento);
    }

    // 1. Buscar por ID (Essencial para a Edição)
    public Pagamento buscarPorId(Long id) {
        // O findById retorna um Optional, por isso usamos o .orElse(null)
        // ou lançamos uma exceção se não encontrar.
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Pagamento não encontrado!"));
    }

    // 2. Excluir Pagamento
    public void excluirPagamento(Long id) {
        repository.deleteById(id);
    }
}