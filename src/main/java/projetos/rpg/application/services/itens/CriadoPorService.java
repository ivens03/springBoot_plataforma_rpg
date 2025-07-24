package projetos.rpg.application.services.itens;

import org.springframework.stereotype.Service;
import projetos.rpg.domain.repository.JogadorRepository;


// Service com a função de salvar os campos de criadoPor e Quando foi criado

@Service
public class CriadoPorService {

    private final JogadorRepository jogadorRepository;

    private CriadoPorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }



}
