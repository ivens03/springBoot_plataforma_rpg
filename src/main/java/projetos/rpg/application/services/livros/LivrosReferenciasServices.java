package projetos.rpg.application.services.livros;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetos.rpg.domain.model.ficha.statusBasicos.LivrosReferenciasModel;
import projetos.rpg.domain.repository.LivrosReferenciasRepository;

import java.util.Optional;

/**
 * Service responsavel para os livros que são a base para tudo que depende deles.
 * */

@Service
public class LivrosReferenciasServices {

    private final LivrosReferenciasRepository livrosReferenciasRepository;

    public LivrosReferenciasServices(LivrosReferenciasRepository livrosReferenciasRepository) {
        this.livrosReferenciasRepository = livrosReferenciasRepository;
    }

    // Salvar

    public LivrosReferenciasModel salvarLivroReferencia (LivrosReferenciasModel livrosReferenciasModel) {
        return livrosReferenciasRepository.save(livrosReferenciasModel);
    }

    //atualizar

    public LivrosReferenciasModel atualizarLivroReferencia (LivrosReferenciasModel livrosReferenciasModel) {
        return livrosReferenciasRepository.save(livrosReferenciasModel);    
    }

    //pegar por id

    public Optional<LivrosReferenciasModel> pegarUmLivroReferencia (Long idLivroReferencia) {
        return livrosReferenciasRepository.findById(idLivroReferencia);
    }

    //delete logico desativando no DB

    @Transactional
    public void removerLivroReferencia (Long idLivroReferencia) {
        livrosReferenciasRepository.findById(idLivroReferencia).ifPresent(livrosReferenciasModel -> {
            livrosReferenciasModel.setLivro_ativo_DB(false);
            livrosReferenciasRepository.save(livrosReferenciasModel);
        });
    }
}