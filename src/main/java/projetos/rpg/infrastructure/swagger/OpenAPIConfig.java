package projetos.rpg.infrastructure.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

/// <p>O ultimo zero a aplicação são mudanças pequenas dentro do software
/// Otimização, refatoração, tudo que seja para melhoria não visivel ao usuario final.</p>
/// <p>O segundo zero é para toda mudança visual
/// Onde o usuario conseguer vizualizar a mudança somete visual.</p>
/// <p>O primeiro zero é para mudanças de feature
/// Mudanças de medidas novas para o usuario</p>

@Configuration
public class OpenAPIConfig {

    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
            .title("Projeto de estudo plataforma de RPG")
            .version("1.0.2")
            .description("caso de estudo")
        );
    }
}
