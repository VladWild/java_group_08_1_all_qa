package ru.yandex.qa.streams.intermediate;

import ru.yandex.qa.streams.entity.Car;
import ru.yandex.qa.streams.entity.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Переделать из одного объекта в другой
 */
public class MainMap {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Игорь", new Car("LADA Granta")),
                new Person(2, "Катя", new Car("LADA Priora")),
                new Person(3, "Олег", new Car("Audi A4")),
                new Person(4, "Колян", new Car("Ferrari"))
        );

        List<Car> cars = people.stream()
                .map(Person::getCar)
                .toList();

        System.out.println(cars);

        int[] ids = people.stream()
                .mapToInt(Person::getId)
                .toArray();

        System.out.println(Arrays.toString(ids));
    }
}
