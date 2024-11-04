package fiap.com.br.solutech.controller;

import fiap.com.br.solutech.model.Agencia;
import fiap.com.br.solutech.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/agencias")
public class AgenciaController {

    @Autowired
    private AgenciaService agenciaService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("agencia", agenciaService.findAll());
        return "agencia/list";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("agencia", new Agencia());
        return "agencia/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Agencia agencia) {
        agenciaService.save(agencia);
        return "redirect:/agencias";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Agencia agencia = agenciaService.findById(id);
        model.addAttribute("livro", agencia);
        return "agencia/form";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        agenciaService.delete(id);
        return "redirect:/agencia";
    }

    @GetMapping("/pesquisa")
    public String pesquisar(@RequestParam(required = false) String nome, Model model) {
        System.out.println("Buscando por nome: " + nome);
        if (nome == null || nome.trim().isEmpty()) {
            return "agencia/pesquisa";
        }
        List<Agencia> resultados = agenciaService.searchByNome(nome);
        System.out.println("Resultados encontrados: " + resultados.size());

        model.addAttribute("resultados", resultados);
        return "livros/pesquisa";
    }

}
