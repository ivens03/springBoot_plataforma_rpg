package projetos.rpg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetos.rpg.domain.model.ficha.statusBasicos.LivrosReferenciasOficialModel;

@Repository
public interface LivrosReferenciasOficialRepository extends JpaRepository<LivrosReferenciasOficialModel, Long> {
}
