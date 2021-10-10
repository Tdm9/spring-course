package pt.course.bookservice.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pt.course.bookservice.model.Book
import pt.course.bookservice.proxy.CambioProxy
import pt.course.bookservice.repository.BookRepository

@RestController
@RequestMapping("book-service")
class BookController {
    @Autowired
    private val environment: Environment? = null

    @Autowired
    private val repository: BookRepository? = null

    @Autowired
    private val proxy: CambioProxy? = null
    @GetMapping(value = ["/{id}/{currency}"])
    fun findBook(
        @PathVariable("id") id: Long,
        @PathVariable("currency") currency: String?
    ): Book {
        val book = repository!!.getById(id) ?: throw RuntimeException("Book not Found")
        val cambio = proxy!!.getCambio(book.price, "USD", currency)
        val port = environment!!.getProperty("local.server.port")
        book.environment = "Book port: " + port +
                " Cambio Port " + cambio.environment
        book.price = cambio.convertedValue
        return book
    }
    /**@GetMapping(value = "/{id}/{currency}")
     * public Book findBook(
     * @PathVariable("id") Long id,
     * @PathVariable("currency") String currency
     * ) {
     *
     * var book = repository.getById(id);
     * if (book == null) throw new RuntimeException("Book not Found");
     *
     * HashMap<String></String>, String> params = new HashMap<>();
     * params.put("amount", book.getPrice().toString());
     * params.put("from", "USD");
     * params.put("to", currency);
     *
     * var response = new RestTemplate()
     * .getForEntity("http://localhost:8000/cambio-service/"
     * + "{amount}/{from}/{to}",
     * Cambio.class,
     * params);
     *
     * var cambio = response.getBody();
     *
     * var port = environment.getProperty("local.server.port");
     * book.setEnvironment(port);
     * book.setPrice(cambio.getConvertedValue());
     * return book;
     * }
     */
}