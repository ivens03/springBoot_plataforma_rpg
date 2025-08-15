package projetos.rpg.domain.model.post;

import jakarta.persistence.*;
import projetos.rpg.domain.model.jogador.JogadorModel;
import projetos.rpg.domain.model.multiMidia.ImgModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade que representa um post feito por um jogador(usuário).
 * Cada post pode conter imagem, texto e está associado a um jogador(usuário).
 * Pode receber curtidas e comentários de outros jogadores.
 */

@Entity
@Table(name = "posts")
public class PostModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_post;

    boolean privado;

    @OneToOne
    @JoinColumn(name = "urlImagem")
    private ImgModel url_imagem;

    private String titulo;
    private String conteudo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private JogadorModel criado_por;

    private LocalDateTime criado_em;
    private String genero_rpg;  /** Tipo do genero do rpg (Fantasia, Cyberpunk, etc...) **/

    @Enumerated(EnumType.STRING)
    private SistemaRpgEnum tipo_sistema_rpg; /** Sistema de RPG (D&D, Tormenta, Etc...) **/

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CurtidasModel> curtidas = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComentariosModel> comentarios = new ArrayList<>();

    // Construtor padrão para JPA

    public PostModel() {}

    // Construtor

    public PostModel(Long id_post, boolean privado, ImgModel url_imagem, String titulo, String conteudo, JogadorModel criado_por, LocalDateTime criado_em, String genero_rpg, SistemaRpgEnum tipo_sistema_rpg, List<CurtidasModel> curtidas, List<ComentariosModel> comentarios) {
        this.id_post = id_post;
        this.privado = privado;
        this.url_imagem = url_imagem;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.criado_por = criado_por;
        this.criado_em = criado_em;
        this.genero_rpg = genero_rpg;
        this.tipo_sistema_rpg = tipo_sistema_rpg;
        this.curtidas = curtidas;
        this.comentarios = comentarios;
    }

    // Getter e Setter

    public Long getId_post() {
        return id_post;
    }

    public void setId_post(Long id_post) {
        this.id_post = id_post;
    }

    public boolean isPrivado() {
        return privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public ImgModel getUrl_imagem() {
        return url_imagem;
    }

    public void setUrl_imagem(ImgModel url_imagem) {
        this.url_imagem = url_imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public JogadorModel getCriado_por() {
        return criado_por;
    }

    public void setCriado_por(JogadorModel criado_por) {
        this.criado_por = criado_por;
    }

    public LocalDateTime getCriado_em() {
        return criado_em;
    }

    public void setCriado_em(LocalDateTime criado_em) {
        this.criado_em = criado_em;
    }

    public String getGenero_rpg() {
        return genero_rpg;
    }

    public void setGenero_rpg(String genero_rpg) {
        this.genero_rpg = genero_rpg;
    }

    public SistemaRpgEnum getTipo_sistema_rpg() {
        return tipo_sistema_rpg;
    }

    public void setTipo_sistema_rpg(SistemaRpgEnum tipo_sistema_rpg) {
        this.tipo_sistema_rpg = tipo_sistema_rpg;
    }

    public List<CurtidasModel> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<CurtidasModel> curtidas) {
        this.curtidas = curtidas;
    }

    public List<ComentariosModel> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentariosModel> comentarios) {
        this.comentarios = comentarios;
    }
}
