package pt.course.bookservice.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import pt.course.bookservice.model.Book
import pt.course.bookservice.proxy.CambioProxy
import pt.course.bookservice.repository.BookRepository
import pt.course.bookservice.response.Cambio


@Tag(name = "Book endpoint")
@RestController
@RequestMapping("book-service")
class BookController {


    @Autowired
    private val environment: Environment? = null

    @Autowired
    private val repository: BookRepository? = null

    @Autowired
    private val proxy: CambioProxy? = null

    @Operation(summary = "Find a specific book by your ID")
    @GetMapping(value = ["/{id}/{currency}"])
    fun findBook(@PathVariable("id") id: Long, @PathVariable("currency") currency: String?): Book? {
        val book: Book = repository?.getById(id) ?: throw RuntimeException("Book not Found")
        val cambio: Cambio? = proxy?.getCambio(book.price, "USD", currency)
        val port: String? = environment?.getProperty("local.server.port")
        if (cambio != null) {
            book.environment="Book port: " + port + " Cambio Port " + cambio.environment
        }
        if (cambio != null) {
            book.price=cambio.convertedValue
        }
        return book
    }
}