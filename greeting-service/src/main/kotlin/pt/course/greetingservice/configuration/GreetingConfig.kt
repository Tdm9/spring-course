package pt.course.greetingservice.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
//import org.springframework.cloud.context.config.annotation.RefreshScope;

@Component
//@RefreshScope
@ConfigurationProperties(prefix = "greeting-service")
class GreetingConfig {
    lateinit var defaultValue: String;
    lateinit var greeting: String
}