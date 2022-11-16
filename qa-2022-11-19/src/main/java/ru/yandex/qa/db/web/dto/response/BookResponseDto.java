package ru.yandex.qa.db.web.dto.response;

import ru.yandex.qa.db.web.dto.request.BookRequestDto;

public class BookResponseDto extends BookRequestDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
