package fiap.com.br.solutech.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "TB_CG_USUARIO")
@Getter@Setter
@NoArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "id_user")
    private Long id;
    @Column(name = "nm_user", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false, unique = true)
    private String password;


    //Relação entre a Role e o Usuário (N:M)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "T_USUARIO_ROLE", joinColumns = @JoinColumn(name="id_usuario")
            ,inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles;

}
