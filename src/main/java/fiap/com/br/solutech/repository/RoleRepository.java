package fiap.com.br.solutech.repository;

import fiap.com.br.solutech.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

}
