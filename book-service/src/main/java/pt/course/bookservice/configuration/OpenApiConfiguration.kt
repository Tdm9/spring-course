package pt.course.bookservice.configuration

import org.springframework.context.annotation.Bean
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.License


@OpenAPIDefinition(
    info = Info(
        title = "Book Service API",
        version = "v1",
        description = "Documentation of Book Service API"
    )
)
class OpenApiConfiguration {
    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .components(Components())
            .info(
                io.swagger.v3.oas.models.info.Info()
                    .title("Book Service API")
                    .version("v1")
                    .license(License().name("Apache 2.0").url("http://springdoc.org"))
            )
    }
}