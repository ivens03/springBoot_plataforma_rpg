package projetos.rpg.interfaces.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RenderizacaoPagina {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Tela para ir a pois o loginn

    @GetMapping("/HomeJogador")
    public String homeJogador() {
        return "homeJogador";
    }

}
