package ru.yandex.yandex.qa.db.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import ru.yandex.qa.db.config.PostgresDbConfig;
import ru.yandex.qa.db.model.Book;
import ru.yandex.qa.db.repositories.BookRepository;

import java.util.List;

@AutoConfigureDataJpa
@PropertySource("classpath:application.properties")
@SpringBootTest(classes = PostgresDbConfig.class)
public class JpaRepositoryPostgresTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void test() {
        List<Book> books = bookRepository.findAll();
        System.out.println(books);
    }
}
