package pt.course.greetingservice.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import pt.course.greetingservice.models.Greeting
import pt.course.greetingservice.configuration.GreetingConfig
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController(
    @Autowired
    var configuration: GreetingConfig
) {

    var atomicLongProperty: AtomicLong = AtomicLong(0L)

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue= "") name: String): Greeting {
        println(configuration.greeting)
        return  if (name.isNullOrEmpty())
            Greeting(atomicLongProperty.getAndIncrement(),"${configuration.greeting},${configuration.defaultValue}")
        else
            Greeting(atomicLongProperty.getAndIncrement(),"${configuration.greeting},${name}")

    }

}