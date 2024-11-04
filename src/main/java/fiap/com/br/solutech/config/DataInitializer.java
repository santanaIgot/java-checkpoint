package fiap.com.br.solutech.config;

import fiap.com.br.solutech.model.Role;
import fiap.com.br.solutech.model.Usuario;
import fiap.com.br.solutech.repository.RoleRepository;
import fiap.com.br.solutech.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initDatabase(UsuarioRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Verifica se a role ADMIN já existe
            Role adminRole = roleRepository.findByName("ROLE_ADMIN");
            if (adminRole == null) {
                adminRole = new Role();
                adminRole.setName("ROLE_ADMIN");
                adminRole.setLabel("Admin");
                roleRepository.save(adminRole);
            }

            // Verifica se a role USER já existe
            Role userRole = roleRepository.findByName("ROLE_USER");
            if (userRole == null) {
                userRole = new Role();
                userRole.setName("ROLE_USER");
                userRole.setLabel("User");
                roleRepository.save(userRole);
            }

            // Verifica se o usuário ADMIN já existe
            if (userRepository.findByUsername("admin") == null) {
                Usuario admin = new Usuario();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin"));
                admin.setRoles(Set.of(adminRole));
                userRepository.save(admin);
            }

            // Verifica se o usuário USER já existe
            if (userRepository.findByUsername("user1") == null) {
                Usuario user = new Usuario();
                user.setUsername("user1");
                user.setPassword(passwordEncoder.encode("password"));
                user.setRoles(Set.of(userRole));
                userRepository.save(user);
            }
        };
    }
}
