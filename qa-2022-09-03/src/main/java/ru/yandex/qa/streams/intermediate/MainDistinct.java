package ru.yandex.qa.streams.intermediate;

import ru.yandex.qa.streams.entity.Car;
import ru.yandex.qa.streams.entity.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MainDistinct {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Игорь", new Car("ЛАДА Гранта")),
                new Person(1, "Катя", new Car("ЛАДА Приора")),
                new Person(2, "Alex", new Car("Audi A4")),
                new Person(2, "Саша", new Car("Мазда"))
        );

        System.out.println(people);

        List<Person> people1 = people.stream()
                .distinct()
                .toList();

        System.out.println(people1);

        //аналогично
        Set<Person> peopleSet = people.stream().collect(Collectors.toSet());
        System.out.println(peopleSet);
    }
}
