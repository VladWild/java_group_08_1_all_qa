package ru.yandex.qa.model.one_to_many;

import ru.yandex.qa.model.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car extends BaseModel<Long> {

    private Person person;

    @Id
    @Override
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "person_id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
