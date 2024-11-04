package fiap.com.br.solutech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_CG_AGENCIA")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agencia {
    @Id
    @GeneratedValue()
    @Column(name = "id_agencia")
    private Long id;
    @Column(name = "nm_nome")
    private String nome;





}
