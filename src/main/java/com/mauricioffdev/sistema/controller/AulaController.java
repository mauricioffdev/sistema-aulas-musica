package com.mauricioffdev.sistema.controller;

import com.mauricioffdev.sistema.model.Aula;
import com.mauricioffdev.sistema.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/aulas")
public class AulaController {

    @Autowired
    private AulaRepository aulaRepository;

    // Página HTML: lista de aulas
    @GetMapping
    public String listarTodas(Model model) {
        List<Aula> aulas = aulaRepository.findAll();
        model.addAttribute("aulas", aulas);
        return "lista-aulas"; // templates/lista-aulas.html
    }

    // Página HTML: formulário para nova aula
    @GetMapping("/nova")
    public String novaAula(Model model) {
        model.addAttribute("aula", new Aula());
        return "formulario-aula"; // templates/formulario-aula.html
    }

    // Salvar (via formulário)
    @PostMapping("/salvar")
    public String salvarAula(@ModelAttribute Aula aula) {
        aulaRepository.save(aula);
        return "redirect:/aulas";
    }

    // Se quiser manter o método de API para JSON:
    @ResponseBody
    @GetMapping("/json")
    public List<Aula> listarJson() {
        return aulaRepository.findAll();
    }
}
