package projetos.rpg.domain.model.ficha.statusBasicos;

import jakarta.persistence.*;
import projetos.rpg.domain.model.post.ImgModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/// Este Model serve para salvar os livros faz a composição de antecedentes, classes, raças e afins

@Entity
@Table(name = "Livros_base_oficial")
public class LivrosReferenciasOficialModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_livro_referencias;

    @OneToOne
    @JoinColumn(name = "urlImagem")
    private ImgModel url_img_capa_livro;

    private String titulo_livro;
    private String resumo;
    private Boolean livro_ativo_DB;
    private Date data_lacamento_livro;
    private LocalDateTime data_lacamento_dentro_sistema_livro;

    // Construtor padrão para JPA

    public LivrosReferenciasOficialModel() {}

    // Construtor

    public LivrosReferenciasOficialModel(Long id_livro_referencias, ImgModel url_img_capa_livro, String titulo_livro, String resumo, Boolean livro_ativo_DB, Date data_lacamento_livro, LocalDateTime data_lacamento_dentro_sistema_livro) {
        this.id_livro_referencias = id_livro_referencias;
        this.url_img_capa_livro = url_img_capa_livro;
        this.titulo_livro = titulo_livro;
        this.resumo = resumo;
        this.livro_ativo_DB = livro_ativo_DB;
        this.data_lacamento_livro = data_lacamento_livro;
        this.data_lacamento_dentro_sistema_livro = data_lacamento_dentro_sistema_livro;
    }

    // Getter e Setter

    public Long getId_livro_referencias() {
        return id_livro_referencias;
    }

    public void setId_livro_referencias(Long id_livro_referencias) {
        this.id_livro_referencias = id_livro_referencias;
    }

    public ImgModel getUrl_img_capa_livro() {
        return url_img_capa_livro;
    }

    public void setUrl_img_capa_livro(ImgModel url_img_capa_livro) {
        this.url_img_capa_livro = url_img_capa_livro;
    }

    public String getTitulo_livro() {
        return titulo_livro;
    }

    public void setTitulo_livro(String titulo_livro) {
        this.titulo_livro = titulo_livro;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Boolean getLivro_ativo_DB() {
        return livro_ativo_DB;
    }

    public void setLivro_ativo_DB(Boolean livro_ativo_DB) {
        this.livro_ativo_DB = livro_ativo_DB;
    }

    public Date getData_lacamento_livro() {
        return data_lacamento_livro;
    }

    public void setData_lacamento_livro(Date data_lacamento_livro) {
        this.data_lacamento_livro = data_lacamento_livro;
    }

    public LocalDateTime getData_lacamento_dentro_sistema_livro() {
        return data_lacamento_dentro_sistema_livro;
    }

    public void setData_lacamento_dentro_sistema_livro(LocalDateTime data_lacamento_dentro_sistema_livro) {
        this.data_lacamento_dentro_sistema_livro = data_lacamento_dentro_sistema_livro;
    }
}
