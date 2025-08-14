package projetos.rpg.domain.repository.multiMidia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetos.rpg.domain.model.ficha.livros.pdf.PdfModel;

@Repository
public interface PdfRepository extends JpaRepository<PdfModel, Long> {
}
