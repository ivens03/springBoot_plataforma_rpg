package projetos.rpg.domain.model.livros;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import projetos.rpg.domain.model.multiMidia.ImgModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Representa um livro de referência oficial, publicado pela editora principal
 * do sistema de RPG (ex: "Livro do Jogador", "Guia do Mestre").
 * <p>
 * Esta entidade é mapeada para a tabela {@code livros_oficiais} e herda
 * todos os seus atributos da classe base {@link LivrosReferenciasModel}.
 *
 * @see LivrosReferenciasModel
 */

@Entity
@Table(name = "livros_comunidade")
public class LivrosReferenciasComunidadeModel extends LivrosReferenciasModel implements Serializable {

    public LivrosReferenciasComunidadeModel() {}

    public LivrosReferenciasComunidadeModel(Long id_livro_referencias, ImgModel url_img_capa_livro, String titulo_livro, String resumo, Boolean livro_ativo_DB, Date data_lacamento_livro, LocalDateTime data_lacamento_dentro_sistema_livro, Boolean publico) {
        super(id_livro_referencias, url_img_capa_livro, titulo_livro, resumo, livro_ativo_DB, data_lacamento_livro, data_lacamento_dentro_sistema_livro, publico);
    }

}
