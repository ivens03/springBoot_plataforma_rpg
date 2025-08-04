/*
package projetos.rpg.interfaces.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetos.rpg.application.services.itens.ItemService;
import projetos.rpg.domain.model.itens.ItemModel;

@RestController
@RequestMapping("/itens")
public class ItemController {

    // Injeção do repositorio

    private final ItemService itemService;

    public ItemController( ItemService itemService) {
        this.itemService = itemService;
    }

    // Salvar

    @PostMapping
    public ResponseEntity<ItemModel> criarItem(@RequestBody ItemModel item) {
        ItemModel itemSalvo = itemService.salvarItem(item);
        return ResponseEntity.ok(itemSalvo);
    }

    //

}
*/
