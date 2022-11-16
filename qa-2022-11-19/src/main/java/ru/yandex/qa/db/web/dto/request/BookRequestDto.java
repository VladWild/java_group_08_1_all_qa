package ru.yandex.qa.db.web.dto.request;

import javax.validation.constraints.NotBlank;

public class BookRequestDto {
    @NotBlank(message = "имя книги не должно быть пустым")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
