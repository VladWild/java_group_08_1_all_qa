package ru.yandex.qa.db.db.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.yandex.qa.db.db.dao.Storage;
import ru.yandex.qa.db.db.dao.impl.utils.BookStorageUtils;
import ru.yandex.qa.db.db.model.Book;

import java.util.List;

/**
 * Вот в этих Storage'ах как рам мы уже и используем JDBC Template
 */
@Component
public class BookStorage implements Storage<Book, Long> {

    private final JdbcTemplate jdbcTemplate;

    public BookStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
        String sql = "select * from BOOKS";
        return jdbcTemplate.query(sql, BookStorageUtils::makeBook);
    }
}
