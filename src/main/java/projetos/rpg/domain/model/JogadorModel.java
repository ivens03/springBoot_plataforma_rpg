package projetos.rpg.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.io.Serializable;

@Entity
@Table(name = "jogador")
public class JogadorModel implements Serializable {

    // Colunas

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;


    private String password;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    // Todo jogador começar ativo dentro do sistema.

    private Boolean ativo = true;

    // Construtor padrão para JPA

    public JogadorModel() {}

    // Construtor

    public JogadorModel(Long id, String username, String password, String email, Boolean ativo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.ativo = ativo;
    }

    // Getter e Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
