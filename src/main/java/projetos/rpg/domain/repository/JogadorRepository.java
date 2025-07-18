package projetos.rpg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetos.rpg.domain.model.JogadorModel;

@Repository
public interface JogadorRepository extends JpaRepository<JogadorModel, Long> {
}
