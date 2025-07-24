package projetos.rpg.domain.model.classe;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.List;

public class ClassePersonagemModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_classe_personagem;

    private boolean publico;

    private String nome_classe;
    private String descricao;

    private String dado_vida_classe;
    private int vida_inicial;
    private int vida_ganha_por_nivel;

    private List<String> proficiencias_armas;
    private List<String> proficiencias_armaduras;
    private List<String> proficiencias_ferramentas;

    private List<SalvaguardaEnum> lista_opcoes_salvaguarda;

    // Ex: Furtividade, Intuição, Acrobacia -> pericias_disponiveis
    private List<String> pericias_disponiveis;

    // Ex: 2, 3 (quantas o jogador pode escolher) -> quantidade_pericias_escolhidas
    private byte quantidade_pericias_escolhidas;

    // habilidades que tem na classe -> habilidades_por_nivel;
    // private List<HabilidadeClasse> habilidades_por_nivel;

    // Estrutura com informações mágicas, se aplicável -> magias
    // private ListaMagia magias;

    private int xp_total;
}
