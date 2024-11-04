package fiap.com.br.solutech.repository;

import fiap.com.br.solutech.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByUsername(String username);
}
