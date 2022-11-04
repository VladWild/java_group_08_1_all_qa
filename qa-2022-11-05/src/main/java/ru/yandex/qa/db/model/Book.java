package ru.yandex.qa.db.model;

import org.hibernate.annotations.GenericGenerator;
import ru.yandex.qa.db.model.base.BaseModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book extends BaseModel<Long> {

    private String title;

    private Set<Page> pages = new HashSet<>();      //рекомендация ставить Set
    private Set<Author> authors = new HashSet<>();

    @Id
    @Override
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //если однонаправленная связь
    //@OneToMany
    //@JoinColumn(name = "book_id")
    @OneToMany(mappedBy = "book")
    public Set<Page> getPages() {
        return pages;
    }

    public void setPages(Set<Page> pages) {
        this.pages = pages;
    }

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                ", authors=" + authors +
                '}';
    }
}
