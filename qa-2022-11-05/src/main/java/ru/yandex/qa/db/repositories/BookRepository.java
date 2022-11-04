package ru.yandex.qa.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.qa.db.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
