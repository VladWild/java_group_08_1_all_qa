package ru.yandex.qa.db.db.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.yandex.qa.db.db.dao.Storage;
import ru.yandex.qa.db.db.dao.impl.utils.BookStorageUtils;
import ru.yandex.qa.db.db.model.Book;

import java.sql.PreparedStatement;
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
    public Long save(Book book) {
        String sqlQuery = "insert into books (title) values (?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement stmt = connection.prepareStatement(sqlQuery, new String[]{"id"});
            stmt.setString(1, book.getTitle());
            return stmt;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public void update(Book book) {
        String sqlQuery = "update BOOKS SET TITLE = ? WHERE ID = ?";
        jdbcTemplate.update(sqlQuery, book.getTitle(), book.getId());
    }

    @Override
    public Book get(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        String sqlQuery = "delete from BOOKS WHERE ID = ?";
        jdbcTemplate.update(sqlQuery, 6L);
    }

    @Override
    public List<Book> getAll() {
        String sql = "select * from BOOKS";
        return jdbcTemplate.query(sql, BookStorageUtils::makeBook);
    }

    //@Transactional
    public void saveAndDelete(Book saveBook, Long deleteBookId) {
        String sqlQueryUpdate = "insert into books (title) values (?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement stmt = connection.prepareStatement(sqlQueryUpdate, new String[]{"id"});
            stmt.setString(1, saveBook.getTitle());
            return stmt;
        });

        String sqlQueryDelete = "delete from BOOKS WHERE ID = ?";
        jdbcTemplate.update(sqlQueryDelete, 6L);
    }
}
