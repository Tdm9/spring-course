package pt.course.greetingservice.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.stereotype.Component

@Component
@RefreshScope
@ConfigurationProperties(prefix = "greeting-service")
class GreetingConfig {
    lateinit var defaultValue: String
    lateinit var greeting: String
}