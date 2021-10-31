package pt.course.cambioservice.configuration

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import org.springframework.context.annotation.Bean


@OpenAPIDefinition(
    info = io.swagger.v3.oas.annotations.info.Info(
        title = "Cambio Service API",
        version = "v1",
        description = "Documentation of Cambio Service API"
    )
)
class OpenApiConfiguration {
    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .components(Components())
            .info(
                io.swagger.v3.oas.models.info.Info()
                    .title("Cambio Service API")
                    .version("v1")
                    .license(
                        io.swagger.v3.oas.models.info.License()
                            .name("Apache 2.0")
                            .url("http://springdoc.org")
                    )
            )
    }
}