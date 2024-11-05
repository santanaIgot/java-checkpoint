package fiap.com.br.solutech.service;

import fiap.com.br.solutech.model.Investimento;
import fiap.com.br.solutech.repository.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestimentoService {

    @Autowired
    private InvestimentoRepository investimentoRepository;

    public void save(Investimento investimento) {investimentoRepository.save(investimento);}


}
