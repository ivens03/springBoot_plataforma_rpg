package projetos.rpg.domain.model.multiMidia;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Representa a entidade de um documento PDF no banco de dados.
 * <p>
 * Esta classe é mapeada para a tabela "pdf" e armazena os metadados
 * de um livro ou documento, como nome, sinopse e datas de lançamento e envio.
 * Ela serve como o modelo de dados para todas as operações relacionadas a um PDF
 * dentro do sistema.
 */

@Entity
@Table(name = "pdf")
public class PdfModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_pdf;

    @OneToOne
    @JoinColumn(name = "urlImagem")
    private ImgModel url_img_capa_livro;

    private String nome_pdf;
    private String sinopse;
    private LocalDateTime data_envio_pdf;
    private Date data_lancamento_pdf;

    private PdfModel () {}

    public PdfModel(Long id_pdf, ImgModel url_img_capa_livro, String nome_pdf, String sinopse, LocalDateTime data_envio_pdf, Date data_lancamento_pdf) {
        this.id_pdf = id_pdf;
        this.url_img_capa_livro = url_img_capa_livro;
        this.nome_pdf = nome_pdf;
        this.sinopse = sinopse;
        this.data_envio_pdf = data_envio_pdf;
        this.data_lancamento_pdf = data_lancamento_pdf;
    }

    public Long getId_pdf() {
        return id_pdf;
    }

    public void setId_pdf(Long id_pdf) {
        this.id_pdf = id_pdf;
    }

    public ImgModel getUrl_img_capa_livro() {
        return url_img_capa_livro;
    }

    public void setUrl_img_capa_livro(ImgModel url_img_capa_livro) {
        this.url_img_capa_livro = url_img_capa_livro;
    }

    public String getNome_pdf() {
        return nome_pdf;
    }

    public void setNome_pdf(String nome_pdf) {
        this.nome_pdf = nome_pdf;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public LocalDateTime getData_envio_pdf() {
        return data_envio_pdf;
    }

    public void setData_envio_pdf(LocalDateTime data_envio_pdf) {
        this.data_envio_pdf = data_envio_pdf;
    }

    public Date getData_lancamento_pdf() {
        return data_lancamento_pdf;
    }

    public void setData_lancamento_pdf(Date data_lancamento_pdf) {
        this.data_lancamento_pdf = data_lancamento_pdf;
    }
}
