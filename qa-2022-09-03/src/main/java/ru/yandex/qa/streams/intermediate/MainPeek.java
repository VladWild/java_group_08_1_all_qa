package ru.yandex.qa.streams.intermediate;

import ru.yandex.qa.streams.entity.Car;
import ru.yandex.qa.streams.entity.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Просто что-то сделать в стриме
 */
public class MainPeek {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Игорь", new Car("LADA Granta")),
                new Person(3, "Олег", new Car("Audi A4")),
                new Person(4, "Колян", new Car("Ferrari")),
                new Person(2, "Катя", new Car("LADA Priora"))
        );

        people.stream()
                .peek(person -> {
                    System.out.println(person);
                    System.out.println(person.getCar());
                })
                .toList();
    }
}
