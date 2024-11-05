package fiap.com.br.solutech.controller;

import fiap.com.br.solutech.dto.UserForm;
import fiap.com.br.solutech.repository.RoleRepository;
import fiap.com.br.solutech.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("usuario")
public class UsuarioController {


    @Autowired
    private UsuarioService userService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        model.addAttribute("roles", roleRepository.findAll());
        return "usuario/cadastro";
    }


    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userForm") UserForm userForm) {
        userService.saveUser(userForm.getUsername(),
                passwordEncoder.encode(userForm.getPassword()), new ArrayList<>(userForm.getRoles()));
        return "redirect:/login";
    }


}
