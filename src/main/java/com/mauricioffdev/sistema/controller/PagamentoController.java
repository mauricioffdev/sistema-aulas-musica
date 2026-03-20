package com.mauricioffdev.sistema.controller;

import com.mauricioffdev.sistema.model.Pagamento;
import com.mauricioffdev.sistema.service.AlunoService;
import com.mauricioffdev.sistema.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // Importante para o ID na URL
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/financeiro")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private AlunoService alunoService;

    // 1. Listar
    @GetMapping
    public String listarPagamentos(Model model) {
        model.addAttribute("pagamentos", pagamentoService.listarTodos());
        return "financeiro-lista";
    }

    // 2. Novo
    @GetMapping("/novo")
    public String novoPagamento(Model model) {
        model.addAttribute("pagamento", new Pagamento());
        model.addAttribute("alunos", alunoService.listarTodos());
        return "financeiro-novo";
    }

    // 3. Salvar (funciona tanto para criar novo quanto para atualizar)
    @PostMapping("/salvar")
    public String salvarPagamento(Pagamento pagamento) {
        pagamentoService.registrarPagamento(pagamento);
        return "redirect:/financeiro";
    }

    // 4. Editar (Carrega os dados atuais no formulário)
    @GetMapping("/editar/{id}")
    public String editarPagamento(@PathVariable Long id, Model model) {
        // Buscamos o pagamento pelo ID no Service
        Pagamento pagamento = pagamentoService.buscarPorId(id);
        model.addAttribute("pagamento", pagamento);
        model.addAttribute("alunos", alunoService.listarTodos()); // Para o dropdown de alunos
        return "financeiro-novo"; // Reutilizamos a mesma tela de "novo" para editar
    }

    // 5. Deletar
    @GetMapping("/deletar/{id}")
    public String deletarPagamento(@PathVariable Long id) {
        pagamentoService.excluirPagamento(id);
        return "redirect:/financeiro";
    }
}