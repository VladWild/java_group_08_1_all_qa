package ru.yandex.qa.db.model;

import ru.yandex.qa.db.model.base.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book extends BaseModel<Long> {

    private String title;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
