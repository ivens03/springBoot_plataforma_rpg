package projetos.rpg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetos.rpg.domain.model.post.ImgModel;

@Repository
public interface ImgRepository extends JpaRepository<ImgModel, Long> {
}
