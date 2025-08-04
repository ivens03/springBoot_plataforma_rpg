/*
package projetos.rpg.application.services.itens;

import org.springframework.stereotype.Service;
import projetos.rpg.application.services.cards.CriadoPor;
import projetos.rpg.domain.model.itens.ItemModel;
import projetos.rpg.domain.repository.ItemRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ItemService {

    // Injeção do repositorio

    private final ItemRepository itemRepository;
    private final CriadoPor criadoPorService;

    public ItemService(ItemRepository itemRepository, CriadoPor criadoPorService) {
        this.itemRepository = itemRepository;
        this.criadoPorService = criadoPorService;
    }

    // Salvar item

    public ItemModel salvarItem(ItemModel itemModel) {
        // Salvar o dia que foi feito criado o item
        LocalDate dataAtual = LocalDate.now();
        itemModel.setCriado_em(dataAtual);
        return itemRepository.save(itemModel);
    }

    // No InfModels tem se é publico ou privado "True or false"
    // Nesse metado GET Pegamos somente os publicos

    public List<ItemModel> listaItensPublicos() {
        return itemRepository.findByPublicoTrue();
    }

    // No InfModels tem o criado_por (O nome da pessoa)
    // Nesse GET retorna a lista mas so do item feito por essa pessoa.

*/
/*    public List<ItemModel> listaItensPrivados() {

    }*//*


}
*/
