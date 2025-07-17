package projetos.rpg.infrastructure.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
            .title("Projeto de estudo plataforma de RPG")
            .version("0.0.0")
            .description("caso de estudo")
        );
    }
}
