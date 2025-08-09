package projetos.rpg.interfaces.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetos.rpg.application.services.livros.LivrosReferenciasServices;
import projetos.rpg.domain.model.ficha.statusBasicos.LivrosReferenciasModel;

@RestController
@RequestMapping("/api/livros")
public class LivrosReferenciasController {

    // Injenção do LivrosReferenciasServices

    private final LivrosReferenciasServices livrosReferenciasServices;

    public LivrosReferenciasController(LivrosReferenciasServices livrosReferenciasServices) {
        this.livrosReferenciasServices = livrosReferenciasServices;
    }

    // Salvar

    @PostMapping
    public ResponseEntity<LivrosReferenciasModel> cadastrarLivroReferencia(@RequestBody LivrosReferenciasModel livrosReferenciasModel){
        LivrosReferenciasModel salvar = livrosReferenciasServices.salvarLivroReferencia(livrosReferenciasModel);
        return ResponseEntity.ok(salvar);
    }

    // Atualizar

    @PutMapping("/{id}")
    public ResponseEntity<LivrosReferenciasModel> atualizarLivroReferencia(@PathVariable Long id_livro_referencias, @RequestBody LivrosReferenciasModel livrosReferenciasModel) {
        return livrosReferenciasServices.pegarUmLivroReferencia(id_livro_referencias)
                .map(livroExistente -> {
                    livrosReferenciasModel.setId_livro_referencias(id_livro_referencias);
                    LivrosReferenciasModel atualizarLivro = livrosReferenciasServices.atualizarLivroReferencia(livrosReferenciasModel);
                    return ResponseEntity.ok(atualizarLivro);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Pegar um por vez

    @GetMapping("/{id}")
    public ResponseEntity<LivrosReferenciasModel> listarUmLivroReferencia(@PathVariable long id_livro_referencias) {
        return livrosReferenciasServices.pegarUmLivroReferencia(id_livro_referencias)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Desativar do DB

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogicoLivroReferencia(@PathVariable long id_livro_referencias) {
        livrosReferenciasServices.removerLivroReferencia(id_livro_referencias);
        return ResponseEntity.noContent().build();
    }
}
