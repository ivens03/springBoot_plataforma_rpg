package projetos.rpg.domain.repository.livros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetos.rpg.domain.model.ficha.statusBasicos.AntecedentesModel;

@Repository
public interface AntecedentesRepository extends JpaRepository<AntecedentesModel, Long> {
}
