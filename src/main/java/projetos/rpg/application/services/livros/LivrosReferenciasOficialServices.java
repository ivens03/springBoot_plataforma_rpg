package projetos.rpg.application.services.livros;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetos.rpg.domain.model.ficha.statusBasicos.LivrosReferenciasOficialModel;
import projetos.rpg.domain.repository.LivrosReferenciasOficialRepository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Service responsavel para os livros que são a base para tudo que depende deles.
 * */

@Service
public class LivrosReferenciasOficialServices {

    private final LivrosReferenciasOficialRepository livrosReferenciasOficialRepository;

    public LivrosReferenciasOficialServices(LivrosReferenciasOficialRepository livrosReferenciasOficialRepository) {
        this.livrosReferenciasOficialRepository = livrosReferenciasOficialRepository;
    }

    // Salvar

    public LivrosReferenciasOficialModel salvarLivroReferencia (LivrosReferenciasOficialModel livrosReferenciasOficialModel) {
        LocalDateTime dataAtual = LocalDateTime.now();
        livrosReferenciasOficialModel.setData_lacamento_dentro_sistema_livro(dataAtual);
        return livrosReferenciasOficialRepository.save(livrosReferenciasOficialModel);
    }

    //atualizar

    public LivrosReferenciasOficialModel atualizarLivroReferencia (LivrosReferenciasOficialModel livrosReferenciasOficialModel) {
        return livrosReferenciasOficialRepository.save(livrosReferenciasOficialModel);
    }

    //pegar por id

    public Optional<LivrosReferenciasOficialModel> pegarUmLivroReferencia (Long idLivroReferencia) {
        return livrosReferenciasOficialRepository.findById(idLivroReferencia);
    }

    //delete logico desativando no DB

    @Transactional
    public void removerLivroReferencia (Long idLivroReferencia) {
        livrosReferenciasOficialRepository.findById(idLivroReferencia).ifPresent(livrosReferenciasOficialModel -> {
            livrosReferenciasOficialModel.setLivro_ativo_DB(false);
            livrosReferenciasOficialRepository.save(livrosReferenciasOficialModel);
        });
    }
}