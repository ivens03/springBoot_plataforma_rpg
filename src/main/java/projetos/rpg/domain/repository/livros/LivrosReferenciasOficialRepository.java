package projetos.rpg.domain.repository.livros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projetos.rpg.domain.model.ficha.livros.LivrosReferenciasOficialModel;

@Repository
public interface LivrosReferenciasOficialRepository extends JpaRepository<LivrosReferenciasOficialModel, Long> {

    @Query("SELECT l FROM LivrosReferenciasOficialModel l WHERE l.id_livro_referencias = :id AND l.publico = true")
    LivrosReferenciasOficialModel findById_livro_referenciasAndPublicoTrue(@Param("id") Long idLivroReferencias);

}
