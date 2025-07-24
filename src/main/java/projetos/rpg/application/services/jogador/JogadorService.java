package projetos.rpg.application.services.jogador;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    // Listar todos jogadores, mesmo estando desativados.

    public List<JogadorModel> listarJogadores() {
        return jogadorRepository.findAll();
    }

    // Listar todos jogadores ativos

    public List<JogadorModel> listarJogadoresAtivos() {
        return jogadorRepository.findByAtivoTrue();
    }

    // Listar um jogador ativo por vez.

    public Optional<JogadorModel> buscarJogadorPorId(Long id) {
        return jogadorRepository.findById(id);
    }

    // Deletar de forma logica "somente desativando o usaurio".

    @Transactional
    public void desativarJogador(Long id) {
        jogadorRepository.findById(id).ifPresent(jogador -> {
            jogador.setAtivo(false);
            jogadorRepository.save(jogador);
        });
    }
}
