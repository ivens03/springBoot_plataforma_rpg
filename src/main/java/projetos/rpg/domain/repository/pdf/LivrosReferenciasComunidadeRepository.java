package projetos.rpg.domain.repository.pdf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetos.rpg.domain.model.ficha.livros.referencias.LivrosReferenciasComunidadeModel;

import java.util.List;

@Repository
public interface LivrosReferenciasComunidadeRepository extends JpaRepository<LivrosReferenciasComunidadeModel, Long> {

    List<LivrosReferenciasComunidadeModel> findByPublicoTrue();

}
