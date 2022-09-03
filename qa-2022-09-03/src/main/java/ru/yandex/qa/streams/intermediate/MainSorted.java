package ru.yandex.qa.streams.intermediate;

import ru.yandex.qa.streams.entity.Car;
import ru.yandex.qa.streams.entity.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Сортировать объекты в стриме
 */
public class MainSorted {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Игорь", new Car("LADA Granta")),
                new Person(3, "Олег", new Car("Audi A4")),
                new Person(4, "Колян", new Car("Ferrari")),
                new Person(2, "Катя", new Car("LADA Priora"))
        );

        System.out.println(people);

        List<Person> people1 = people.stream()
                .sorted(((o1, o2) -> o1.getId() - o2.getId()))
                .toList();

        System.out.println(people1);

        List<Person> people2 = people.stream()
                .sorted((Comparator.comparingInt(Person::getId)))
                .toList();

        System.out.println(people2);

        List<Person> peopleReversed = people.stream()
                .sorted((Comparator.comparingInt(Person::getId)).reversed())
                .toList();

        System.out.println(peopleReversed);
    }
}
