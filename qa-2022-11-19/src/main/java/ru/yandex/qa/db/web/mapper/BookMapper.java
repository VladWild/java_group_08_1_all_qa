package ru.yandex.qa.db.web.mapper;

import ru.yandex.qa.db.db.model.Book;
import ru.yandex.qa.db.web.dto.BookDto;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {

    BookDto mapToBookDto(Book dto);
}
