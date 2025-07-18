package projetos.rpg.application.services;

import org.springframework.stereotype.Service;
import projetos.rpg.domain.model.JogadorModel;
import projetos.rpg.domain.repository.JogadorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    // Injeção do repository user

    final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    // Salvar

    public JogadorModel salvarJogador (JogadorModel jogador) {
        return jogadorRepository.save(jogador);
    }

    // Atualizar

    public JogadorModel atualizarJogador (JogadorModel jogador) {
        return jogadorRepository.save(jogador);
    }

    // Listar todos
    public List<JogadorModel> listarJogadores() {
        return jogadorRepository.findAll();
    }

    // Listar um por um

    public Optional<JogadorModel> buscarJogadorPorId(Long id) {
        return jogadorRepository.findById(id);
    }

    // Deletar

    public void deletarDB (Long id) {
        jogadorRepository.deleteById(id);
    }
}
