package projetos.rpg.domain.model.ficha.statusBasicos;

import jakarta.persistence.*;
import projetos.rpg.domain.model.ficha.statusBasicos.statusEnum.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Status basicos de uma ficha de RPG, onde consiste em todos os atributos que contem uma ficha.
 * Este model vai para o FichaModel para fazer a ficha do jogador.
 * */

@Entity
public class StatusBasicosModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_apagar;

    /** Atributos basicos */

    private Integer pontos_vida_absoluto;
    private Integer pontos_vida_atual;
    private Integer pontos_vida_temporario;
    private Byte classe_armadura;
    private Byte iniciativa;
    private Byte deslocamente;
    private Integer pontos_xp;
    private byte nivel;

    /** Lista de atributos basicos */

    /**
    @ElementCollection
    @CollectionTable(name = "ficha_pericias_atributos")
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "atributos")
    @Column(name = "valor_atributos")
    private Map<AtributosEnum, Integer> lista_atributos;
    **/

    @ManyToOne
    @JoinColumn(name = "lista_atributos")
    private AntecedentesModel antecedente;

    @ElementCollection
    @CollectionTable(name = "ficha_pericias_salvaguarda")
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "salvaguarda")
    @Column(name = "valor_salvaguarda")
    private Map<SalvaguardaEnum, Integer> lista_salvaguarda;

    @ElementCollection
    @CollectionTable(name = "ficha_pericias_valores") // Tabela que vai ser criada e salvar os valores
    @MapKeyEnumerated(EnumType.STRING) // Diz ao JPA para guardar a chave do mapa (ENUM) como String
    @MapKeyColumn(name = "pericia") // Nome da coluna para a chave
    @Column(name = "valor_pericia") // Nome da coluna para o valor
    private Map<PericiasEnum, Integer> pericias;

    /** Lista de traços de personalidade */

    @Enumerated(EnumType.STRING)
    private AlinhamentoEnum alinhamento;
    private List<String> tracos_personalidade;
    private List<String> ideais;
    private List<String> vinculos;
    private List<String> fraquezas;

    ///----------------------------------------------------------------------------------------------/
    /// Tenho antecedentes basicos
    /// Tenho antecedentes de DLC
    /// Injetar sem ser via de codigo os antecedentes base + DLC
    /// Solução CRUD ?
    /// Quebraria para dois tipos de ususarios ( Jogador e ADM )
    /// MELHORAR ISSO ↓
    /// @Enumerated(EnumType.STRING)
    /// private AntecedentesEnum antecedentes;
    ///----------------------------------------------------------------------------------------------/
    private String antecedentes;

    //@ManyToOne
    //@JoinColumn(name = "titulo_livro")
    //private LivrosReferenciasModel livro;

    /** Características fisicas migrar isto para uma tabela separada
    *
    * private Integer idade;
    * private Float altura;
    * private Float peso;
    * private String cor_dos_olhos;
    * private String cor_da_pele;
    * private String cor_do_cabelo;
    */
}
