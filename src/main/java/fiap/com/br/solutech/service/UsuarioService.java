package fiap.com.br.solutech.service;

import fiap.com.br.solutech.model.Role;
import fiap.com.br.solutech.model.Usuario;
import fiap.com.br.solutech.repository.RoleRepository;
import fiap.com.br.solutech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RoleRepository roleRepository;

    public void saveUser(String username, String password, List<String> roles) {
        Usuario user = new Usuario();
        user.setUsername(username);
        user.setPassword(password);
// Adicionar as roles selecionadas ao usuário
        HashSet<Role> userRoles = new HashSet<>();
        for (String roleName : roles) {
            Role role = roleRepository.findByName(roleName);
            if (role != null) {
                userRoles.add(role);
            }
        }
        user.setRoles(userRoles);
        usuarioRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        Set<SimpleGrantedAuthority> authorities = usuario.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
        return new User(
                usuario.getUsername(),
                usuario.getPassword(),
                authorities);
    }
}
