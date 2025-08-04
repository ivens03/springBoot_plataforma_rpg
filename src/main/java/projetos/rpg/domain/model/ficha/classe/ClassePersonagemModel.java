package projetos.rpg.domain.model.ficha.classe;

import jakarta.persistence.*;

@Entity
@Table(name = "classe_personagem")
@DiscriminatorValue("card_classe")
public class ClassePersonagemModel  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_classe_personagem;

    private String nome_classe;

    private String dado_vida_classe;
    private int vida_inicial;
    private int vida_ganha_por_nivel;

/*    @ElementCollection
    @CollectionTable(name = "classe_proficiencias_armas", joinColumns = @JoinColumn(name = "classe_id"))
    private List<String> proficiencias_armas;*/
    // private List<String> proficiencias_armaduras;
    // private List<String> proficiencias_ferramentas;


    // Ex: Furtividade, Intuição, Acrobacia -> pericias_disponiveis
    // private List<String> pericias_disponiveis;

    // Ex: 2, 3 (quantas o jogador pode escolher) -> quantidade_pericias_escolhidas
    private byte quantidade_pericias_escolhidas;

    // habilidades que tem na classe -> habilidades_por_nivel;
    // private List<HabilidadeClasse> habilidades_por_nivel;

    // Estrutura com informações mágicas, se aplicável -> magias
    // private ListaMagia magias;

    private int xp_total;
}
