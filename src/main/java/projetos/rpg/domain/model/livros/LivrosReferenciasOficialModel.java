package projetos.rpg.domain.model.livros;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import projetos.rpg.domain.model.multiMidia.ImgModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Representa um livro de referência criado pela comunidade de jogadores (homebrew),
 * contendo regras, classes, e afins sendo não oficiais.
 * <p>
 * Esta entidade é mapeada para a tabela {@code livros_comunidade} e herda
 * todos os seus atributos da classe base {@link LivrosReferenciasModel}.
 *
 * @see LivrosReferenciasModel
 */

@Entity
@Table(name = "livros_oficiais")
public class LivrosReferenciasOficialModel extends LivrosReferenciasModel implements Serializable {

    public LivrosReferenciasOficialModel() {}

    public LivrosReferenciasOficialModel(Long id_livro_referencias, ImgModel url_img_capa_livro, String titulo_livro, String resumo, Boolean livro_ativo_DB, Date data_lacamento_livro, LocalDateTime data_lacamento_dentro_sistema_livro, Boolean publico) {
        super(id_livro_referencias, url_img_capa_livro, titulo_livro, resumo, livro_ativo_DB, data_lacamento_livro, data_lacamento_dentro_sistema_livro, publico);
    }
}
