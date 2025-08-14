package projetos.rpg.application.services.livros;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetos.rpg.domain.model.ficha.livros.referencias.LivrosReferenciasComunidadeModel;
import projetos.rpg.domain.repository.pdf.LivrosReferenciasComunidadeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosReferenciasComunidadeServices {

    private final LivrosReferenciasComunidadeRepository livrosReferenciasComunidadeRepository;

    public LivrosReferenciasComunidadeServices(LivrosReferenciasComunidadeRepository livrosReferenciasComunidadeRepository) {
        this.livrosReferenciasComunidadeRepository = livrosReferenciasComunidadeRepository;
    }

    // Salvar

    public LivrosReferenciasComunidadeModel salvarLivroComunidade(LivrosReferenciasComunidadeModel livrosReferenciasComunidadeModel) {
        return livrosReferenciasComunidadeRepository.save(livrosReferenciasComunidadeModel);
    }

    // Atualizar

    public LivrosReferenciasComunidadeModel atualizarLivroComunidade(LivrosReferenciasComunidadeModel livrosReferenciasComunidadeModel) {
        return livrosReferenciasComunidadeRepository.save(livrosReferenciasComunidadeModel);
    }

    // Lista todos os livros comunidade sendo todos publicos para o feed

    public List<LivrosReferenciasComunidadeModel> todosLivrosComunidade () {
        return livrosReferenciasComunidadeRepository.findByPublicoTrue();
    }

    // lista uma unidade de livro comunidade por vez

    public Optional<LivrosReferenciasComunidadeModel> buscarUnidadeLivroComunidade (Long id_livro_referencias) {
        return livrosReferenciasComunidadeRepository.findById(id_livro_referencias);
    }

    // Apagar

    @Transactional
    public void removerLivroComunidade(Long id_livro_referencias) {
        livrosReferenciasComunidadeRepository.findById(id_livro_referencias).ifPresent(livro -> {
            livro.setLivro_ativo_DB(false);
            livrosReferenciasComunidadeRepository.save(livro);
        });
    }

}
