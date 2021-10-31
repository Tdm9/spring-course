package pt.course.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.course.bookservice.model.Book

interface BookRepository : JpaRepository<Book, Long>{

}