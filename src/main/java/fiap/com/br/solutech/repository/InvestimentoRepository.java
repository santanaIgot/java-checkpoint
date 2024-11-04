package fiap.com.br.solutech.repository;

import fiap.com.br.solutech.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {

}
