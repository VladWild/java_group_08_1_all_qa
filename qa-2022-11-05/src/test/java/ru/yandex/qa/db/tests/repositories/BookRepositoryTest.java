package ru.yandex.qa.db.tests.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import ru.yandex.qa.db.model.Book;
import ru.yandex.qa.db.repositories.BookRepository;
import ru.yandex.qa.db.tests.JpaH2Runner;

import java.util.List;

@ContextConfiguration(classes = {
        BookRepository.class
})
class BookRepositoryTest extends JpaH2Runner {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Sql("classpath:sql/book/add_book.sql")
    void findAllTest() {
        List<Book> books = bookRepository.findAll();
        System.out.println(books);
    }
}
