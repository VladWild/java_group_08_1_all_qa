package ru.yandex.qa.db.web.controler;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.qa.db.db.model.Book;
import ru.yandex.qa.db.service.impl.BookService;
import ru.yandex.qa.db.web.dto.BookDto;
import ru.yandex.qa.db.web.mapper.BookMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/book")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService,
                          BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping
    public List<BookDto> getAll() {
        final List<Book> books = bookService.getAll();
        return books.stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }
}
