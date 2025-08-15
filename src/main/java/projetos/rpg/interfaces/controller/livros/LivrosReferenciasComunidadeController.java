package projetos.rpg.interfaces.controller.livros;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetos.rpg.application.services.livros.LivrosReferenciasComunidadeServices;
import projetos.rpg.domain.model.ficha.livros.referencias.LivrosReferenciasComunidadeModel;

import java.util.List;

@RestController
@RequestMapping("/livro/comunidade")
public class LivrosReferenciasComunidadeController {

    private final LivrosReferenciasComunidadeServices livrosReferenciasComunidadeServices;

    public LivrosReferenciasComunidadeController(LivrosReferenciasComunidadeServices livrosReferenciasComunidadeServices) {
        this.livrosReferenciasComunidadeServices = livrosReferenciasComunidadeServices;
    }

    // Salvar

    @PostMapping
    public ResponseEntity<LivrosReferenciasComunidadeModel> cadastrarLivroOficial(@RequestBody LivrosReferenciasComunidadeModel livrosReferenciasComunidadeModel) {
        LivrosReferenciasComunidadeModel salvar = livrosReferenciasComunidadeServices.salvarLivroComunidade(livrosReferenciasComunidadeModel);
        return ResponseEntity.ok(salvar);
    }

    // Atualizar

    @PutMapping("/{id}")
    public ResponseEntity<LivrosReferenciasComunidadeModel> atualizarLivroComunidade(@PathVariable Long id_livro_referencias, @RequestBody LivrosReferenciasComunidadeModel livrosReferenciasComunidadeModel) {
        return livrosReferenciasComunidadeServices.buscarUnidadeLivroComunidade(id_livro_referencias)
                .map(livroExistente -> {
                    livrosReferenciasComunidadeModel.setId_livro_referencias(id_livro_referencias);
                    LivrosReferenciasComunidadeModel atualizacaoLivroComunidade = livrosReferenciasComunidadeServices.atualizarLivroComunidade(livrosReferenciasComunidadeModel);
                    return ResponseEntity.ok(atualizacaoLivroComunidade);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete logico

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerLivroComunidade(@PathVariable Long id_livro_referencias) {
        livrosReferenciasComunidadeServices.removerLivroComunidade(id_livro_referencias);
        return ResponseEntity.noContent().build();
    }

    // Lista todos os livros publicos para o feed

    @GetMapping("/all")
    public ResponseEntity<List<LivrosReferenciasComunidadeModel>> obterUnidadeLivroOficial() {
        List<LivrosReferenciasComunidadeModel> listaLivrosComunidadePublicoComPrivado = livrosReferenciasComunidadeServices.todosLivrosComunidade();
        return ResponseEntity.ok(listaLivrosComunidadePublicoComPrivado);
    }

    // Lista do jogador(Usuario) + Livro publico + Livro privado

    @GetMapping("/{id}")
    public ResponseEntity<LivrosReferenciasComunidadeModel> listaPorId(@PathVariable Long id_livro_referencias) {
        return livrosReferenciasComunidadeServices.buscarUnidadeLivroComunidade(id_livro_referencias)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
