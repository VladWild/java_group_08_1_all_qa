package ru.yandex.qa.db.service.impl;

import org.springframework.stereotype.Service;
import ru.yandex.qa.db.db.dao.impl.BookStorage;
import ru.yandex.qa.db.db.model.Book;
import ru.yandex.qa.db.service.AbstractService;

import java.util.List;

@Service("bookService")
public class BookService extends AbstractService<Book, Long, BookStorage> {

    public BookService(BookStorage storage) {
        super(storage);
    }

    public List<Book> getAll() {
        return storage.getAll();
    }
}
