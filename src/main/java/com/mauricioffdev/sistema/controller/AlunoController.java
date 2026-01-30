package com.mauricioffdev.sistema.controller;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import com.mauricioffdev.sistema.model.Aluno;
import com.mauricioffdev.sistema.service.AlunoService; // Não esqueça de importar o Service!
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Mudou de RestController para Controller
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller // Usamos @Controller para poder retornar páginas HTML
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service; // O nome da variável é 'service'

    // --- MÉTODOS DE API (Retornam JSON para o Postman ou React) ---

    @GetMapping("/api") // Mudei a rota para não conflitar
    @ResponseBody // Isso diz: "Não procure um HTML, retorne os dados puros"
    public List<Aluno> listarTodosAPI() {
        return service.listarTodos(); // Use o método do seu Service
    }

    @PostMapping("/api")
    @ResponseBody
    public Aluno criarAPI(@RequestBody Aluno aluno) {
        return service.salvar(aluno);
    }

    @DeleteMapping("/api/{id}")
    @ResponseBody
    public void deletarAPI(@PathVariable Long id) {
        service.deletar(id); // Você precisa criar esse método 'deletar' no Service se não tiver
    }

    // --- MÉTODOS DE TELA (Retornam HTML/Thymeleaf) ---

    @GetMapping // Isso responde na raiz /alunos
    public String listarAlunos(Model model) {
        // Aqui chamamos o SERVICE, não o repository
        List<Aluno> alunos = service.listarTodos();
        model.addAttribute("alunos", alunos);
        return "alunos"; // Vai procurar alunos.html
    }

    @GetMapping("/novo")
    public String mostrarFormularioNovoAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "novo-aluno"; // Vai procurar novo-aluno.html
    }

    @GetMapping("/editar/{id}") // Mudei para /editar para ficar claro
    public String editarAluno(@PathVariable Long id, Model model) {
        // O Service precisa ter um metodo que retorne Optional ou o objeto direto
        Optional<Aluno> alunoOpt = service.buscarPorId(id);

        if (alunoOpt.isPresent()) {
            model.addAttribute("aluno", alunoOpt.get());
            return "novo-aluno";
        } else {
            return "redirect:/alunos"; // Se não achar, volta pra lista
        }
    }

    @GetMapping("/excluir/{id}")
    public String excluirAluno(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/alunos";
    }

    @PostMapping("/salvar")
    public String salvarAluno(@Valid @ModelAttribute("aluno") Aluno aluno, BindingResult result) {

        // Se houver erros, vamos imprimir no console para descobrir quem é!
        if (result.hasErrors()) {
            System.out.println("--------- ERRO DE VALIDAÇÃO DETECTADO ---------");

            // Esse loop imprime cada erro encontrado
            result.getAllErrors().forEach(error -> {
                System.out.println("ERRO: " + error.getDefaultMessage());
                System.out.println("CAMPO/OBJETO: " + error.getObjectName());
            });

            System.out.println("-----------------------------------------------");

            return "novo-aluno"; // Volta para o formulário
        }

        // Se passou, salva e vai pra lista
        service.salvar(aluno);
        return "redirect:/alunos";
    }
}