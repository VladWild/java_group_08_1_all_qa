package ru.yandex.qa.db.web.mapper;

import ru.yandex.qa.db.db.model.Book;
import ru.yandex.qa.db.web.dto.request.BookRequestDto;
import ru.yandex.qa.db.web.dto.response.BookResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {

    BookResponseDto toDto(Book dto);

    Book toEntity(BookRequestDto dto);
}
