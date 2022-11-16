package ru.yandex.qa.db.web.controler;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.yandex.qa.db.db.model.Book;
import ru.yandex.qa.db.service.impl.BookService;
import ru.yandex.qa.db.web.dto.request.BookRequestDto;
import ru.yandex.qa.db.web.dto.response.BookResponseDto;
import ru.yandex.qa.db.web.mapper.BookMapper;

import javax.validation.Valid;
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
    public List<BookResponseDto> getAll() {
        final List<Book> books = bookService.getAll();
        return books.stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public Long saveBooks(@Valid @RequestBody BookRequestDto dto) {
        Book book = bookMapper.toEntity(dto);
        Book save = bookService.save(book);
        return save.getId();
    }
}
