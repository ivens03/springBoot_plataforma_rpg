package projetos.rpg.domain.model.ficha.statusBasicos;

import jakarta.persistence.*;
import projetos.rpg.domain.model.ficha.statusBasicos.statusEnum.AtributosEnum;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "antecedentes")
public class AntecedentesModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_antecedentes;

    private String nome_antecedente;

    @ElementCollection
    @CollectionTable(name = "ficha_pericias_atributos") // Nome da tabela
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "atributos") // gera tipo um ID key chamada "atributos" servindo mapeado
    @Column(name = "valor_atributos") // Nome da coluna
    private Map<AtributosEnum, Integer> lista_atributos;

    private List<String> idiomas;
    private List<String> kit_base;


}
