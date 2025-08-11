package projetos.rpg.domain.repository.livros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetos.rpg.domain.model.ficha.livros.LivrosReferenciasOficialModel;

import java.util.List;

@Repository
public interface LivrosReferenciasOficialRepository extends JpaRepository<LivrosReferenciasOficialModel, Long> {

    List<LivrosReferenciasOficialModel> findByPublicoTrue(/*Boolean publico*/);

}
