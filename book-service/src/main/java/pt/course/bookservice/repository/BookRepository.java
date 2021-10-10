package pt.course.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.course.bookservice.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{}