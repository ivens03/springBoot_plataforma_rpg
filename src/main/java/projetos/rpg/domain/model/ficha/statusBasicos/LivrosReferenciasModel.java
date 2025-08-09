package projetos.rpg.domain.model.ficha.statusBasicos;

import jakarta.persistence.*;
import projetos.rpg.domain.model.post.ImgModel;

import java.io.Serializable;

@Entity
public class LivrosReferenciasModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_livro_referencias;

    @OneToOne
    @JoinColumn(name = "urlImagem")
    private ImgModel url_img_capa_livro;

    private String titulo_livro;
    private Integer ano_livro;
    private String resumo;
    private Boolean livro_oficial;
    private Boolean livro_ativo_DB;

    // Construtor padrão para JPA

    public LivrosReferenciasModel() {}

    // Construtor

    public LivrosReferenciasModel(Long id_livro_referencias, ImgModel url_img_capa_livro, String titulo_livro, Integer ano_livro, String resumo, Boolean livro_oficial, Boolean livro_ativo_DB) {
        this.id_livro_referencias = id_livro_referencias;
        this.url_img_capa_livro = url_img_capa_livro;
        this.titulo_livro = titulo_livro;
        this.ano_livro = ano_livro;
        this.resumo = resumo;
        this.livro_oficial = livro_oficial;
        this.livro_ativo_DB = livro_ativo_DB;
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

    public Integer getAno_livro() {
        return ano_livro;
    }

    public void setAno_livro(Integer ano_livro) {
        this.ano_livro = ano_livro;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Boolean getLivro_oficial() {
        return livro_oficial;
    }

    public void setLivro_oficial(Boolean livro_oficial) {
        this.livro_oficial = livro_oficial;
    }

    public Boolean getLivro_ativo_DB() {
        return livro_ativo_DB;
    }

    public void setLivro_ativo_DB(Boolean livro_ativo_DB) {
        this.livro_ativo_DB = livro_ativo_DB;
    }
}
