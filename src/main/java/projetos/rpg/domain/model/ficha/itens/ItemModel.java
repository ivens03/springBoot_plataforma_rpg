package projetos.rpg.domain.model.ficha.itens;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

// Itens que ficam na ficha do jogador

@Entity
@Table(name = "itens")
@DiscriminatorValue("card_item")
public class ItemModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_itens;

    private String titulo;

    //private String criado_por;

    private BigDecimal valor_item;

    // Construtor padrão para JPA

    public ItemModel() {}

    // Construtor

    public ItemModel(String titulo, BigDecimal valor_item) {
        this.titulo = titulo;
        this.valor_item = valor_item;
    }

    // Getter e Setter

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public BigDecimal getValor_item() {
        return valor_item;
    }

    public void setValor_item(BigDecimal valor_item) {
        this.valor_item = valor_item;
    }
}
