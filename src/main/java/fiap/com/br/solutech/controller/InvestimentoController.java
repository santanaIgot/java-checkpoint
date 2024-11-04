package fiap.com.br.solutech.controller;

import fiap.com.br.solutech.model.Investimento;
import fiap.com.br.solutech.repository.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("investimentos")
public class InvestimentoController {

    @Autowired
    private InvestimentoRepository investimentoRepository;

    @GetMapping("novo")
    public String novo(Model model){
        model.addAttribute("investimento",new Investimento());

        return "investimento/cadastro-investimento";
    }

}
