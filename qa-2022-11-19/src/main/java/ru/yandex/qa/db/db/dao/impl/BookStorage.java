package ru.yandex.qa.db.db.dao.impl;

import org.springframework.stereotype.Component;
import ru.yandex.qa.db.db.dao.Storage;
import ru.yandex.qa.db.db.model.Book;

import java.util.List;

@Component
public class BookStorage implements Storage<Book, Long> {

    @Override
    public void save(Book data) {

    }

    @Override
    public void update(Book data) {

    }

    @Override
    public Book get(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Book> getAll() {
        return null;
    }
}
