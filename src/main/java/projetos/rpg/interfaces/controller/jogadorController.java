package projetos.rpg.interfaces.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetos.rpg.application.services.jogador.JogadorService;
import projetos.rpg.domain.model.jogador.JogadorModel;

import java.util.List;

@RestController
@RequestMapping("/jogador")
public class jogadorController {

    // Injeção do repositorio

    private final JogadorService jogadorService;

    public jogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    // Salvar jogador

    @PostMapping
    public ResponseEntity<JogadorModel> cadatrarJogador(@RequestBody JogadorModel jogador) {
        JogadorModel salvar = jogadorService.salvarJogador(jogador);
        return ResponseEntity.ok(salvar);
    }

    // Atualizar inforamação do jogador

    @PutMapping("/{id}")
    public ResponseEntity<JogadorModel> atualizarJogador(@PathVariable Long id, @RequestBody JogadorModel jogadorModel) {
        return jogadorService.buscarJogadorPorId(id)
                .map(jogadorExistente -> {
                    jogadorModel.setId(id);
                    JogadorModel jogadorAtualizado = jogadorService.atualizarJogador(jogadorModel);
                    return ResponseEntity.ok(jogadorAtualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Lista todos os jogadores sendo ativos ou não ativos.

    @GetMapping("/all")
    public ResponseEntity<List<JogadorModel>> listaTodosJogadores() {
        List<JogadorModel> listaTodos = jogadorService.listarJogadores();
        return ResponseEntity.ok(listaTodos);
    }

    // Listar Todos os jogadores Jogadores ativos.

    @GetMapping("/ativo")
    public ResponseEntity<List<JogadorModel>> listaJogadoresAtivos() {
        List<JogadorModel> listaTodos = jogadorService.listarJogadoresAtivos();
        return ResponseEntity.ok(listaTodos);
    }

    // Pegar um jogador

    @GetMapping("/{id}")
    public ResponseEntity<JogadorModel> listarUmJogador(@PathVariable Long id) {
        return jogadorService.buscarJogadorPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar um jogador

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUmJogador(@PathVariable Long id) {
        jogadorService.desativarJogador(id);
        return ResponseEntity.noContent().build();
    }

}
