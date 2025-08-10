package projetos.rpg.interfaces.controller.livros;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetos.rpg.application.services.livros.LivrosReferenciasOficialServices;
import projetos.rpg.domain.model.ficha.livros.LivrosReferenciasOficialModel;

@RestController
@RequestMapping("/livro/oficial")
public class LivrosReferenciasOficialController {

    private final LivrosReferenciasOficialServices livrosReferenciasOficialServices;

    public LivrosReferenciasOficialController(LivrosReferenciasOficialServices livrosReferenciasOficialServices) {
        this.livrosReferenciasOficialServices = livrosReferenciasOficialServices;
    }

    // Salvar

    @PostMapping
    public ResponseEntity<LivrosReferenciasOficialModel> cadastrarLivroOficial(@RequestBody LivrosReferenciasOficialModel livrosReferenciasOficialModel) {
        LivrosReferenciasOficialModel salvar = livrosReferenciasOficialServices.salvarLivroOficial(livrosReferenciasOficialModel);
        return ResponseEntity.ok(salvar);
    }

    // Atualizar

    @PutMapping("/{id}")
    public ResponseEntity<LivrosReferenciasOficialModel> atulizarLivroOficial(@PathVariable Long id_livro_referencias, @RequestBody LivrosReferenciasOficialModel livrosReferenciasOficialModel) {
        return livrosReferenciasOficialServices.todosLivrosOficial(id_livro_referencias)
                .map(livroExistente -> {
                    livrosReferenciasOficialModel.setId_livro_referencias(id_livro_referencias);
                    LivrosReferenciasOficialModel atualizarLivroOficial = livrosReferenciasOficialServices.salvarLivroOficial(livrosReferenciasOficialModel);
                    return ResponseEntity.ok(atualizarLivroOficial);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
