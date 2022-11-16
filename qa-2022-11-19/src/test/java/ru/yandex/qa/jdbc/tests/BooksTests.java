package ru.yandex.qa.jdbc.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import ru.yandex.qa.db.db.dao.impl.BookStorage;
import ru.yandex.qa.db.db.model.Book;
import ru.yandex.qa.jdbc.JdbcH2Runner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(classes = BookStorage.class)
class BooksTests extends JdbcH2Runner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BookStorage bookStorage;

    /**
     * Что такое ResultSet и как достать все данные?
     */
    @Test
    @Sql({"classpath:book/table.sql", "classpath:book/data_book.sql"})
    void resultSetTestBookMapperTest() {
        String sql = "select * from BOOKS";
        List<Book> books = jdbcTemplate.query(sql, new BookMapper());
        System.out.println(books);
    }

    /**
     * Делаем тоже самое в Storage'е
     */
    @Test
    @Sql({"classpath:book/table.sql", "classpath:book/data_book.sql"})
    void resultSetTestBookStorageTest() {
        String sql = "select * from BOOKS";
        List<Book> books = bookStorage.getAll();
        System.out.println(books);
    }

    /**
     * Еще один способ получить все книги с помощью ResultSet
     * Еще упомянуть про jdbcTemplate.setFetchSize(2); и что это такое
     */
    @Test
    @Sql({"classpath:book/table.sql", "classpath:book/data_book.sql"})
    void resultSetTestResultSetExtractorTest() {
        String sql = "select * from BOOKS";
        List<Book> books = jdbcTemplate.query(sql, new BookResultSetExtractor());
        System.out.println(books);
    }

    /**
     * Еще упомянуть про jdbcTemplate.setFetchSize(2); и что это такое
     */
    @Test
    @Sql({"classpath:book/table.sql", "classpath:book/data_book.sql"})
    void resultSetTestFetchSizeFetchSizeTest() {
        String sql = "select * from BOOKS";
        jdbcTemplate.setFetchSize(2);
        List<Book> books = jdbcTemplate.query(sql, new BookResultSetExtractor());
        System.out.println(books);
    }

    /**
     * Как вообще можно настраивать ResultSet?
     */
    @Test
    @Sql({"classpath:book/table.sql", "classpath:book/data_book.sql"})
    void statementResultSetTest() {
        String sql = "select * from BOOKS b where b.id = 1";
        Book bookGet = jdbcTemplate.execute((ConnectionCallback<Book>) connection -> {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(sql);

            Book book = new Book();

            while (resultSet.next()) {
                book.setId(resultSet.getLong("id"));
                book.setTitle(resultSet.getString("title"));
            }

            //resultSet.previous();

            return book;
        });
        System.out.println(bookGet);
    }

    /**
     * Можно ли обновить данные с помощью ResultSet?
     */
    @Test
    @Sql({"classpath:book/table.sql", "classpath:book/data_book.sql"})
    void statementResultSetUpdateTest() {
        List<Book> books = bookStorage.getAll();
        System.out.println(books);

        String sql = "select * from BOOKS b where b.id = 1";
        Book bookGet = jdbcTemplate.execute((ConnectionCallback<Book>) connection -> {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(sql);

            Book book = new Book();

            resultSet.first();
            resultSet.updateString("TITLE", "Гарри Поттер и Тайная Комната");
            resultSet.updateRow();

            return book;
        });

        List<Book> books2 = bookStorage.getAll();
        System.out.println(books2);
    }

    /**
     * PreparedStatement - сохранение данных
     */
    @Test
    @Sql({"classpath:book/table.sql", "classpath:book/data_book.sql"})
    void saveBookTest() {
        List<Book> books = bookStorage.getAll();
        System.out.println(books);

        String sqlQuery = "insert into books (title) values (?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement stmt = connection.prepareStatement(sqlQuery, new String[]{"id"});
            stmt.setString(1, "Гарри Поттер и Принц Полукровка");
            return stmt;
        }, keyHolder);

        long bookId = keyHolder.getKey().longValue();
        System.out.println(bookId);

        List<Book> books2 = bookStorage.getAll();
        System.out.println(books2);
    }

    /**
     * BookStorage - сохранение данных
     */
    @Test
    @Sql({"classpath:book/table.sql", "classpath:book/data_book.sql"})
    void saveBookBookStorageTest() {
        List<Book> books = bookStorage.getAll();
        System.out.println(books);

        Book book = new Book();
        book.setTitle("Гарри Поттер и Дары Смерти");

        bookStorage.save(book);

        List<Book> books2 = bookStorage.getAll();
        System.out.println(books2);
    }

    /**
     * JdbcTemplate - обновление данных
     */
    @Test
    @Sql({"classpath:book/table.sql", "classpath:book/data_book.sql"})
    void updateBook() {
        List<Book> books = bookStorage.getAll();
        System.out.println(books);

        Book book = new Book();
        book.setId(1L);
        book.setTitle("Гарри Поттер и Орден Феникса");

        String sqlQuery = "update BOOKS SET TITLE = ? WHERE ID = ?";
        jdbcTemplate.update(sqlQuery, book.getTitle(), book.getId());

        List<Book> books2 = bookStorage.getAll();
        System.out.println(books2);
    }

    /**
     * BookStorage - обновление данных
     */
    @Test
    @Sql({"classpath:book/table.sql", "classpath:book/data_book.sql"})
    void updateBookStorageTest() {
        List<Book> books = bookStorage.getAll();
        System.out.println(books);

        Book book = new Book();
        book.setId(6L);
        book.setTitle("Гарри Поттер и Орден Феникса");

        bookStorage.update(book);

        List<Book> books2 = bookStorage.getAll();
        System.out.println(books2);
    }

    /**
     * JdbcTemplate - удаление данных по id
     */
    @Test
    @Sql({"classpath:book/table.sql", "classpath:book/data_book.sql"})
    void deleteBookTest() {
        List<Book> books = bookStorage.getAll();
        System.out.println(books);

        String sqlQuery = "delete from BOOKS WHERE ID = ?";
        jdbcTemplate.update(sqlQuery, 6);

        List<Book> books2 = bookStorage.getAll();
        System.out.println(books2);
    }

    /**
     * BookStorage - удаление данных по id
     */
    @Test
    @Sql({"classpath:book/table.sql", "classpath:book/data_book.sql"})
    void deleteBookStorageTest() {
        List<Book> books = bookStorage.getAll();
        System.out.println(books);

        bookStorage.delete(6L);

        List<Book> books2 = bookStorage.getAll();
        System.out.println(books2);
    }

    private static final class BookResultSetExtractor implements ResultSetExtractor<List<Book>> {

        @Override
        public List<Book> extractData(ResultSet rs) throws SQLException, DataAccessException {
            List<Book> books = new ArrayList<>();

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong("id"));
                book.setTitle(rs.getString("title"));
                books.add(book);
            }

            return books;
        }
    }

    private static final class BookMapper implements RowMapper<Book> {

        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            book.setId(rs.getLong("id"));
            book.setTitle(rs.getString("title"));
            return book;
        }
    }
}
