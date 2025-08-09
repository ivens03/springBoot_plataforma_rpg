package projetos.rpg.interfaces.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetos.rpg.application.services.livros.LivrosReferenciasOficialServices;
import projetos.rpg.domain.model.ficha.statusBasicos.LivrosReferenciasOficialModel;

@RestController
@RequestMapping("/api/oficial/livros")
public class LivrosReferenciasOficialController {

    // Injenção do LivrosReferenciasServices

    private final LivrosReferenciasOficialServices livrosReferenciasOficialServices;

    public LivrosReferenciasOficialController(LivrosReferenciasOficialServices livrosReferenciasOficialServices) {
        this.livrosReferenciasOficialServices = livrosReferenciasOficialServices;
    }

    // Salvar

    @PostMapping
    public ResponseEntity<LivrosReferenciasOficialModel> cadastrarLivroReferencia(@RequestBody LivrosReferenciasOficialModel livrosReferenciasOficialModel){
        LivrosReferenciasOficialModel salvar = livrosReferenciasOficialServices.salvarLivroReferencia(livrosReferenciasOficialModel);
        return ResponseEntity.ok(salvar);
    }

    // Atualizar

    @PutMapping("/{id}")
    public ResponseEntity<LivrosReferenciasOficialModel> atualizarLivroReferencia(@PathVariable Long id_livro_referencias, @RequestBody LivrosReferenciasOficialModel livrosReferenciasOficialModel) {
        return livrosReferenciasOficialServices.pegarUmLivroReferencia(id_livro_referencias)
                .map(livroExistente -> {
                    livrosReferenciasOficialModel.setId_livro_referencias(id_livro_referencias);
                    LivrosReferenciasOficialModel atualizarLivro = livrosReferenciasOficialServices.atualizarLivroReferencia(livrosReferenciasOficialModel);
                    return ResponseEntity.ok(atualizarLivro);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Pegar um por vez

    @GetMapping("/{id}")
    public ResponseEntity<LivrosReferenciasOficialModel> listarUmLivroReferencia(@PathVariable long id_livro_referencias) {
        return livrosReferenciasOficialServices.pegarUmLivroReferencia(id_livro_referencias)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Desativar do DB

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogicoLivroReferencia(@PathVariable long id_livro_referencias) {
        livrosReferenciasOficialServices.removerLivroReferencia(id_livro_referencias);
        return ResponseEntity.noContent().build();
    }
}
