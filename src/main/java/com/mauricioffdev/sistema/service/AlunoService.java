package com.mauricioffdev.sistema.service;

import com.mauricioffdev.sistema.model.Aluno;
import com.mauricioffdev.sistema.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    // Listar todos
    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    // Buscar por ID
    public Optional<Aluno> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // Salvar ou Atualizar
    public Aluno salvar(Aluno aluno) {
        // Aqui você pode colocar regras antes de salvar
        // Ex: verificar se e-mail já existe
        return repository.save(aluno);
    }

    // Deletar
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}