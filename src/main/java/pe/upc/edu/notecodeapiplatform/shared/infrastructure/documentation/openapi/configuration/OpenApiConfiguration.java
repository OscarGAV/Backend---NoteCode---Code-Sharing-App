package pe.upc.edu.notecodeapiplatform.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI noteCodePlatformOpenApi() {
        OpenAPI openApi = new OpenAPI()
                .info(new Info()
                        .title("NoteCode API Platform")
                        .description("API Platform for NoteCode - Code Sharing Application with DDD and CQRS")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("NoteCode Development Team"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")));

        final String securitySchemeName = "bearerAuth";
        Components components = new Components();
        components.addSecuritySchemes(securitySchemeName,
                new SecurityScheme()
                        .name(securitySchemeName)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT"));
        openApi.components(components);

        SecurityRequirement securityRequirement = new SecurityRequirement().addList(securitySchemeName);
        openApi.addSecurityItem(securityRequirement);

        return openApi;
    }
}