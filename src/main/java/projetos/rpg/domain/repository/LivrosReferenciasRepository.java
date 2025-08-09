package projetos.rpg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetos.rpg.domain.model.ficha.statusBasicos.LivrosReferenciasModel;

@Repository
public interface LivrosReferenciasRepository extends JpaRepository<LivrosReferenciasModel, Long> {
}
