package projetos.rpg.domain.model.multiMidia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

/** Model para guardar as imagens.
 *  Guardando a String da url.
 * */

@Entity
public class ImgModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_img;

    private String url_imagem;
    private String nome_imagem;
    private Long tamanho_imagem;
    private LocalDateTime data_criacao;

    // Construtor padrão para JPA

    public ImgModel() {}

    // Construtor

    public ImgModel(long id_img, String url_imagem, String nome_imagem, Long tamanho_imagem, LocalDateTime data_criacao) {
        this.id_img = id_img;
        this.url_imagem = url_imagem;
        this.nome_imagem = nome_imagem;
        this.tamanho_imagem = tamanho_imagem;
        this.data_criacao = data_criacao;
    }

    // Getter e Setter

    public long getId_img() {
        return id_img;
    }

    public void setId_img(long id_img) {
        this.id_img = id_img;
    }

    public String getUrl_imagem() {
        return url_imagem;
    }

    public void setUrl_imagem(String url_imagem) {
        this.url_imagem = url_imagem;
    }

    public String getNome_imagem() {
        return nome_imagem;
    }

    public void setNome_imagem(String nome_imagem) {
        this.nome_imagem = nome_imagem;
    }

    public Long getTamanho_imagem() {
        return tamanho_imagem;
    }

    public void setTamanho_imagem(Long tamanho_imagem) {
        this.tamanho_imagem = tamanho_imagem;
    }

    public LocalDateTime getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDateTime data_criacao) {
        this.data_criacao = data_criacao;
    }
}
