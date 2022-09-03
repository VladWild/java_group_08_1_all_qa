package ru.yandex.qa.streams.intermediate;

import ru.yandex.qa.streams.entity.Car;
import ru.yandex.qa.streams.entity.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Оставить не повторяющиеся объекты
 */
public class MainDistinct {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Игорь", new Car("LADA Granta")),
                new Person(1, "Катя", new Car("LADA Priora")),
                new Person(2, "Олег", new Car("Audi A4")),
                new Person(2, "Колян", new Car("Ferrari"))
        );

        System.out.println(people);

        List<Person> people2 = people.stream()
                .distinct()
                .toList();

        System.out.println(people2);

        Set<Person> peopleSet = people.stream().collect(Collectors.toSet());

        System.out.println(peopleSet);
    }
}
