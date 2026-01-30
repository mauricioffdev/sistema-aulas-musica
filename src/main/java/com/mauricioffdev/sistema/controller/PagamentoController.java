package com.mauricioffdev.sistema.controller;

import com.mauricioffdev.sistema.model.Pagamento;
import com.mauricioffdev.sistema.service.AlunoService;
import com.mauricioffdev.sistema.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Importante: Controller, não RestController
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Mudamos para Controller para aceitar HTML
@RequestMapping("/financeiro")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService; // Injetamos o Service do Pagamento

    @Autowired
    private AlunoService alunoService; // Injetamos o Service do Aluno (para o Dropdown)

    // 1. Tela de Lista de Pagamentos (GET /financeiro)
    @GetMapping
    public String listarPagamentos(Model model) {
        // Usamos a variável 'pagamentoService' (minúsculo), não a classe
        model.addAttribute("pagamentos", pagamentoService.listarTodos());
        return "financeiro-lista";
    }

    // 2. Tela de Novo Pagamento (GET /financeiro/novo)
    @GetMapping("/novo")
    public String novoPagamento(Model model) {
        model.addAttribute("pagamento", new Pagamento());
        // Carrega os alunos para preencher a caixinha de seleção (select)
        model.addAttribute("alunos", alunoService.listarTodos());
        return "financeiro-novo";
    }

    // 3. Salvar o Pagamento (POST /financeiro/salvar)
    @PostMapping("/salvar")
    public String salvarPagamento(Pagamento pagamento) {
        pagamentoService.registrarPagamento(pagamento);
        return "redirect:/financeiro";
    }
}