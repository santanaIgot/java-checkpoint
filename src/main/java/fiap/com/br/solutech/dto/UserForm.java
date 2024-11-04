package fiap.com.br.solutech.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter@Setter
public class UserForm {
    private String username;
    private String password;
    private Set<String> roles;
}
