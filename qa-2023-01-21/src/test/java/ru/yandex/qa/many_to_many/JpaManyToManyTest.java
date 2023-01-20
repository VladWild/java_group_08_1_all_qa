package ru.yandex.qa.many_to_many;

import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import ru.yandex.qa.JpaTest;
import ru.yandex.qa.many_to_many.utils.JpaManyToManyTestUtils;
import ru.yandex.qa.model.many_to_many.Author;
import ru.yandex.qa.model.many_to_many.Book;
import ru.yandex.qa.repository.many_to_many.AuthorRepository;
import ru.yandex.qa.repository.many_to_many.BookRepository;
import ru.yandex.qa.service.ManyToManyService;

import java.util.List;

@Sql("classpath:many_to_many/schema.sql")
public class JpaManyToManyTest extends JpaTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ManyToManyService manyToManyService;

    @Test
    @Sql("classpath:many_to_many/data.sql")
    void test() {
        List<Book> books = bookRepository.findAll();
        System.out.println(books);
    }

    /**
     * Показать, что может быть исключение и все это делается в разных транзакциях
     */
    @Test
    @Sql("classpath:many_to_many/data.sql")
    void test2() {
        Author author = JpaManyToManyTestUtils.createAuthor("Новый автор");
        Author authorSave = authorRepository.save(author);

        Book book = bookRepository.findByIdEntityGraph(1L);
        book.getAuthors().add(authorSave);

        Book bookSave = bookRepository.save(book);
        System.out.println(bookSave);
    }

    @Test
    @Sql("classpath:many_to_many/data.sql")
    void test3() {
        manyToManyService.saveNewAuthorAndAddToBook("Новый автор");
        System.out.println("Ок!!!!");
    }

    @Test
    @Sql("classpath:many_to_many/data.sql")
    void test4() {
        manyToManyService.method("Новый автор");
        System.out.println("Ок!!!!");
    }

    @Test
    @Sql("classpath:many_to_many/data.sql")
    void test5() {
        manyToManyService.method2();
        System.out.println("Ok!!!!");
    }
}
