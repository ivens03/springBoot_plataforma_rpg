package projetos.rpg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetos.rpg.domain.model.JogadorModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface JogadorRepository extends JpaRepository<JogadorModel, Long> {

    // Consulta para pegar jogadores ativo no sistema
    List<JogadorModel> findByAtivoTrue();
    
    // Buscar jogador ativo por email
    Optional<JogadorModel> findByEmailAndAtivoTrue(String email);

}
