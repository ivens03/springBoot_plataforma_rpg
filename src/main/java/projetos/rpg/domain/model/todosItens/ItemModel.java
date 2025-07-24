package projetos.rpg.domain.model.todosItens;

import jakarta.persistence.*;
import projetos.rpg.domain.model.generoJogo.GeneroEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "itens")
public class ItemModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_itens;

    private String titulo;
    private String descricao;

    private String criado_por;
    private LocalDate dataCriacao;

    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

    private BigDecimal valor_item;
}
