package fiap.com.br.solutech.service;

import fiap.com.br.solutech.model.Agencia;
import fiap.com.br.solutech.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenciaService {
    @Autowired
    private AgenciaRepository agenciaRepository;

    public List<Agencia> findAll() {
        return agenciaRepository.findAll();
    }

    public Agencia findById(Long id) {
        return agenciaRepository.findById(id).orElse(null);
    }

    public void save(Agencia agencia) {
        agenciaRepository.save(agencia);
    }

    public void delete(Long id) {
        agenciaRepository.deleteById(id);
    }

    public List<Agencia> searchByNome(String nome) {
        return agenciaRepository.findByNomeContaining(nome);
    }
}