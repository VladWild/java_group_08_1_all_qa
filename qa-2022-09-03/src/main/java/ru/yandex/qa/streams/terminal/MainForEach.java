package ru.yandex.qa.streams.terminal;

import ru.yandex.qa.streams.entity.Car;
import ru.yandex.qa.streams.entity.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Что-то сделать в конце стрима
 */
public class MainForEach {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Игорь", new Car("LADA Granta")),
                new Person(2, "Катя", new Car("LADA Priora")),
                new Person(3, "Олег", new Car("Audi A4")),
                new Person(4, "Колян", new Car("Ferrari"))
        );

        people.stream().forEach(System.out::println);

        people.forEach(System.out::println);
    }
}
