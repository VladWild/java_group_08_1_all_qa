package ru.yandex.qa.streams.intermediate;

import ru.yandex.qa.streams.entity.Car;
import ru.yandex.qa.streams.entity.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainSorted {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(3, "Игорь", new Car("ЛАДА Гранта")),
                new Person(4, "Катя", new Car("ЛАДА Приора")),
                new Person(1, "Alex", new Car("Audi A4")),
                new Person(2, "Саша", new Car("Мазда"))
        );

        System.out.println(people);

        List<Person> people1 = people.stream()
                .sorted((p1, p2) -> p1.getId() - p2.getId())
                .toList();

        System.out.println(people1);

        List<Person> people2 = people.stream()
                .sorted((p1, p2) -> p2.getId() - p1.getId())
                .toList();

        System.out.println(people2);

        List<Person> people3 = people.stream()
                .sorted(Comparator.comparingLong(Person::getId))
                .toList();

        System.out.println(people3);

        List<Person> people4 = people.stream()
                .sorted(Comparator.comparingLong(Person::getId).reversed())
                .toList();

        System.out.println(people4);
    }
}
