package projetos.rpg.application.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projetos.rpg.domain.model.JogadorModel;
import projetos.rpg.domain.repository.JogadorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    // Injeção do repository user
    // Injeção da criptografia da senha

    private final JogadorRepository jogadorRepository;
    private final PasswordEncoder passwordEncoder;

    public JogadorService(JogadorRepository jogadorRepository, PasswordEncoder passwordEncoder) {
        this.jogadorRepository = jogadorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Salvar

    public JogadorModel salvarJogador (JogadorModel jogador) {
        String criptografiaSenha = passwordEncoder.encode(jogador.getPassword());
        jogador.setPassword(criptografiaSenha);
        return jogadorRepository.save(jogador);
    }

    // Atualizar

    public JogadorModel atualizarJogador (JogadorModel jogador) {
        if (jogador.getPassword() != null && !jogador.getPassword().isEmpty()) {
            String criptografiaSenha = passwordEncoder.encode(jogador.getPassword());
            jogador.setPassword(criptografiaSenha);
        }
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
