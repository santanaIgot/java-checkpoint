package fiap.com.br.solutech.controller;

import fiap.com.br.solutech.model.Investimento;
import fiap.com.br.solutech.repository.InvestimentoRepository;
import fiap.com.br.solutech.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("investimentos")
public class InvestimentoController {

    @Autowired
    private InvestimentoRepository investimentoRepository;

    @Autowired
    private AgenciaService agenciaService;

    @GetMapping("novo")
    public String novo(Model model){
        model.addAttribute("investimento",new Investimento());
        model.addAttribute("agencias", agenciaService.findAll());
        return "investimento/cadastro-investimento";
    }

    @PostMapping("novo")
    public String salvar(@ModelAttribute Investimento investimento){
        investimentoRepository.save(investimento);

        return "investimento/lista-investimentos";
    }



}
