package projetos.rpg.domain.model.ficha.statusBasicos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class LivrosReferenciasModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_livro_referencias;

    private String img_capa_livro;
    private String titulo_livro;
    private Integer ano_livro;
    private String resumo;
    private Boolean livro_oficial;

    // Construtor padrão para JPA

    public LivrosReferenciasModel() {}

    // Construtor

    public LivrosReferenciasModel(Long id_livro_referencias, String img_capa_livro, String titulo_livro, Integer ano_livro, String resumo, Boolean livro_oficial) {
        this.id_livro_referencias = id_livro_referencias;
        this.img_capa_livro = img_capa_livro;
        this.titulo_livro = titulo_livro;
        this.ano_livro = ano_livro;
        this.resumo = resumo;
        this.livro_oficial = livro_oficial;
    }

    // Getter e Setter

    public Long getId_livro_referencias() {
        return id_livro_referencias;
    }

    public void setId_livro_referencias(Long id_livro_referencias) {
        this.id_livro_referencias = id_livro_referencias;
    }

    public String getImg_capa_livro() {
        return img_capa_livro;
    }

    public void setImg_capa_livro(String img_capa_livro) {
        this.img_capa_livro = img_capa_livro;
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
}
