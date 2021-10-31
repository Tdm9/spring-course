package pt.course.bookservice.controller

import io.github.resilience4j.bulkhead.annotation.Bulkhead
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@Tag(name = "Foo bar")
@RestController
@RequestMapping("book-service")
class FooBarController {
    private val logger = LoggerFactory.getLogger(FooBarController::class.java)

    @GetMapping("/foo-bar")
    @Operation(summary = "Foo bar") //@Retry(name = "foo-bar", fallbackMethod = "fallbackMethod")
    //@CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
    //@RateLimiter(name = "default")
    @Bulkhead(name = "default")
    fun fooBar(): String {
        logger.info("Request to foo-bar is received!")
        /*
		 * var response = new RestTemplate()
		 * .getForEntity("http://localhost:8080/foo-bar", String.class);
		 */return "Foo-Bar!!!"
        //return response.getBody();
    }

    fun fallbackMethod(ex: Exception?): String {
        return "fallbackMethod foo-bar!!!"
    }
}