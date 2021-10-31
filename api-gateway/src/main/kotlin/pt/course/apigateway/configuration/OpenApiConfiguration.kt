package pt.course.apigateway.configuration

import org.springdoc.core.GroupedOpenApi
import org.springdoc.core.SwaggerUiConfigParameters
import org.springframework.cloud.gateway.route.RouteDefinition
import org.springframework.cloud.gateway.route.RouteDefinitionLocator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy


@Configuration
class OpenApiConfiguration {

    fun getFilter(routeDefinition: RouteDefinition) = routeDefinition.id.matches(Regex(".*-service"))

    @Bean
    @Lazy(false)
    fun apis(config: SwaggerUiConfigParameters, locator: RouteDefinitionLocator): List<GroupedOpenApi> {
        val definitions = locator.routeDefinitions.collectList().block()!!
        definitions
            .stream()
            .filter { getFilter(it) }
            .forEach { routeDefinition: RouteDefinition ->
                val name = routeDefinition.id
                config.addGroup(name)
                GroupedOpenApi.builder()
                    .pathsToMatch("/$name/**")
                    .group(name).build()
            }
        return ArrayList<GroupedOpenApi>()
    }
}