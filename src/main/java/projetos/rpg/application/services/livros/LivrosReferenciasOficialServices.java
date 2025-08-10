package projetos.rpg.application.services.livros;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetos.rpg.domain.model.ficha.livros.LivrosReferenciasOficialModel;
import projetos.rpg.domain.repository.livros.LivrosReferenciasOficialRepository;

import java.util.Optional;

@Service
public class LivrosReferenciasOficialServices {

    private final LivrosReferenciasOficialRepository livrosReferenciasOficialRepository;

    public LivrosReferenciasOficialServices(LivrosReferenciasOficialRepository livrosReferenciasOficialRepository) {
        this.livrosReferenciasOficialRepository = livrosReferenciasOficialRepository;
    }

    // Salvar

    public LivrosReferenciasOficialModel salvarLivroOficial(LivrosReferenciasOficialModel livrosReferenciasOficialModel) {
        return livrosReferenciasOficialRepository.save(livrosReferenciasOficialModel);
    }

    // Atualizar

    public LivrosReferenciasOficialModel atualizarLivroOficial(LivrosReferenciasOficialModel livrosReferenciasOficialModel) {
        return livrosReferenciasOficialRepository.save(livrosReferenciasOficialModel);
    }

    // Pegar todos os livros oficial sendo todos publicos

    public LivrosReferenciasOficialModel todosLivrosOficialPublico (Long id_livro_referencias) {
        return livrosReferenciasOficialRepository.findById_livro_referenciasAndPublicoTrue(id_livro_referencias);
    }

    // Pegar os Privados + Publics

    public Optional<LivrosReferenciasOficialModel> todosLivrosOficial (Long id_livro_referencias) {
        return livrosReferenciasOficialRepository.findById(id_livro_referencias);
    }

    // Apagar

    @Transactional
    public void removerLivroOficial(Long id_livro_referencias) {
        livrosReferenciasOficialRepository.findById(id_livro_referencias).ifPresent(livro -> {
            livro.setLivro_ativo_DB(false);
            livrosReferenciasOficialRepository.save(livro);
        });
    }

}
