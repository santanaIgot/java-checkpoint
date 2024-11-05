package fiap.com.br.solutech.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_CG_INVESTIMENTO")
@Getter@Setter
@NoArgsConstructor
public class Investimento {
    @Id
    @GeneratedValue
    @Column(name = "id_investimento")
    private Long id;

    private String nome;

    private String tipo;

    private Double valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agency", nullable = false)
    private Agencia agencia;
}
