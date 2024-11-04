package fiap.com.br.solutech.repository;

import fiap.com.br.solutech.model.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
    List<Agencia> findByNomeContaining(String nome);
}