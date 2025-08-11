package projetos.rpg.domain.model.post;

import jakarta.persistence.*;
import projetos.rpg.domain.model.jogador.JogadorModel;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "post_salvo")
public class PostSalvoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_post_salvo;

    @ManyToOne(fetch = FetchType.LAZY) // Usar LAZY é crucial para o desempenho
    @JoinColumn(name = "jogador_id", nullable = false)
    private JogadorModel jogador;

    @ManyToOne(fetch = FetchType.LAZY) // Usar LAZY aqui também é recomendado
    @JoinColumn(name = "post_id", nullable = false)
    private PostModel post;

    @Column(name = "salvo_em", nullable = false)
    private LocalDateTime salvoEm;

    public PostSalvoModel() {}

    public PostSalvoModel(Long id_post_salvo, JogadorModel jogador, PostModel post, LocalDateTime salvoEm) {
        this.id_post_salvo = id_post_salvo;
        this.jogador = jogador;
        this.post = post;
        this.salvoEm = salvoEm;
    }

    public Long getId_post_salvo() {
        return id_post_salvo;
    }

    public void setId_post_salvo(Long id_post_salvo) {
        this.id_post_salvo = id_post_salvo;
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

    public LocalDateTime getSalvoEm() {
        return salvoEm;
    }

    public void setSalvoEm(LocalDateTime salvoEm) {
        this.salvoEm = salvoEm;
    }
}
