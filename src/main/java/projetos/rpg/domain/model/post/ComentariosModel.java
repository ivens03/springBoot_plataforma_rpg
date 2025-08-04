package projetos.rpg.domain.model.post;

import jakarta.persistence.*;
import projetos.rpg.domain.model.jogador.JogadorModel;

import java.io.Serializable;

/** Model responsavel pelo os comentarios dos posts dos jogadores **/

@Entity
public class ComentariosModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_comentario;
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "id_jogador")
    private JogadorModel jogador;

    @ManyToOne
    @JoinColumn(name = "id_post")
    private PostModel post;

    // Construtor padrão para JPA

    public ComentariosModel() {}

    // Construtor

    public ComentariosModel(Long id_comentario, String comentario, JogadorModel jogador, PostModel post) {
        this.id_comentario = id_comentario;
        this.comentario = comentario;
        this.jogador = jogador;
        this.post = post;
    }

    // Getter e Setter

    public Long getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(Long id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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
