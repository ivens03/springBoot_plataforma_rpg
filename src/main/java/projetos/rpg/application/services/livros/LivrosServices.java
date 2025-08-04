package projetos.rpg.application.services.livros;

import org.springframework.stereotype.Service;
import projetos.rpg.domain.repository.LivrosReferenciasRepository;

/**
 * Service responsavel para os livros que são a base para tudo que depende deles.
 *
 * */

@Service
public class LivrosServices {

    // Injeção do repository

    private LivrosReferenciasRepository livrosReferenciasRepository;

    private LivrosServices(LivrosReferenciasRepository livrosReferenciasRepository) {
        this.livrosReferenciasRepository = livrosReferenciasRepository;
    }

    // Salvar
}
