package ru.yandex.qa.db.db.model;

import ru.yandex.qa.db.db.model.base.StorageData;

public class Book extends StorageData<Long> {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
