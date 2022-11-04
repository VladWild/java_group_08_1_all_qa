package ru.yandex.qa.db.model;

import ru.yandex.qa.db.model.base.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book extends BaseModel<Long> {

    private String title;

    @Id
    @Override
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return super.getId();
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
