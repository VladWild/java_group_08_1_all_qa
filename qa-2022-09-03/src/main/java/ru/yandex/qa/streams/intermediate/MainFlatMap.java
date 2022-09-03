package ru.yandex.qa.streams.intermediate;

import ru.yandex.qa.streams.entity.Car;
import ru.yandex.qa.streams.entity.Person;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Объединить несколько коллекций в одну
 */
public class MainFlatMap {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Игорь", new Car("LADA Granta")),
                new Person(2, "Катя", new Car("LADA Priora"))
        );

        List<Person> people2 = Arrays.asList(
                new Person(3, "Олег", new Car("Audi A4")),
                new Person(4, "Колян", new Car("Ferrari"))
        );

        List<List<Person>> peopleList = Arrays.asList(
                people,
                people2
        );

        System.out.println(peopleList);

        List<Person> people3 = peopleList.stream()
                .flatMap(people1 -> people1.stream())
                .toList();

        System.out.println(people3);

        List<Person> people4 = peopleList.stream()
                .flatMap(Collection::stream)
                .toList();

        System.out.println(people4);
    }
}
