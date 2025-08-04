package projetos.rpg.domain.model.post;

import jakarta.persistence.*;
import projetos.rpg.domain.model.jogador.JogadorModel;

import java.io.Serializable;

/**
 * Entidade para as curtidas dos post;
 * */

@Entity
public class CurtidasModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_curtidas_post;

    @ManyToOne
    @JoinColumn(name = "id_jogador")
    private JogadorModel jogador;

    @ManyToOne
    @JoinColumn(name = "id_post")
    private PostModel post;

    // Construtor padrão para JPA

    public CurtidasModel() {}

    // Construtor

    public CurtidasModel(Long id_curtidas_post, JogadorModel jogador, PostModel post) {
        this.id_curtidas_post = id_curtidas_post;
        this.jogador = jogador;
        this.post = post;
    }

    // Getter e Setter

    public Long getId_curtidas_post() {
        return id_curtidas_post;
    }

    public void setId_curtidas_post(Long id_curtidas_post) {
        this.id_curtidas_post = id_curtidas_post;
    }

    public JogadorModel getJogador() {
        return jogador;
    }

    public void setJogador(JogadorModel jogador) {
        this.jogador = jogador;
    }

    public PostModel getPost() {
        return post;
    }

    public void setPost(PostModel post) {
        this.post = post;
    }
}
