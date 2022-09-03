package ru.yandex.qa.streams.terminal;

import ru.yandex.qa.streams.entity.Car;
import ru.yandex.qa.streams.entity.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Что-то сложить в объединении
 */
public class MapReduce {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Игорь", new Car("LADA Granta")),
                new Person(2, "Катя", new Car("LADA Priora")),
                new Person(3, "Олег", new Car("Audi A4")),
                new Person(1, "Коля", new Car("Ferrari"))
        );

        String names = people.stream()
                .map(Person::getName)
                .reduce((p1, p2) -> p1 + " " + p2)
                .orElse(null);

        System.out.println(names);
    }
}
