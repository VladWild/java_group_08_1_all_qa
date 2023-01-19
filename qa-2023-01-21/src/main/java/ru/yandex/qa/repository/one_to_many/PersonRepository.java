package ru.yandex.qa.repository.one_to_many;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.qa.model.one_to_many.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
