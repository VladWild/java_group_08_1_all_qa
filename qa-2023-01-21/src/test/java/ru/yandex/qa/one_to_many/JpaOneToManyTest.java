package ru.yandex.qa.one_to_many;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import ru.yandex.qa.JpaRunner;
import ru.yandex.qa.config.DbConfig;
import ru.yandex.qa.model.one_to_many.Person;
import ru.yandex.qa.repository.one_to_many.PersonRepository;
import ru.yandex.qa.service.Service;

import java.util.List;

@EntityScan(basePackages = "ru.yandex.qa.model.one_to_many")
@EnableJpaRepositories(basePackages = "ru.yandex.qa.repository.one_to_many")
@ContextConfiguration(classes = DbConfig.class)
public class JpaOneToManyTest extends JpaRunner {

    @Autowired
    private PersonRepository personRepository;

    @Test
    //@Sql({"classpath:schema.sql"})
    void test() {
        List<Person> people = personRepository.findAll();
        System.out.println(people);
    }
}
