package ru.yandex.qa.db.db.dao.impl.utils;

import ru.yandex.qa.db.db.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookStorageUtils {

    private BookStorageUtils() {
    }

    public static Book makeBook(ResultSet resultSet, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong("id"));
        book.setTitle(resultSet.getString("title"));
        return book;
    }
}
