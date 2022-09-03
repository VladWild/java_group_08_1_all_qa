package ru.yandex.qa.streams.intermediate;

import ru.yandex.qa.streams.entity.Car;
import ru.yandex.qa.streams.entity.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Переделать данные из одного объекта в другой
 */
public class MainMap {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Игорь", new Car("ЛАДА Гранта")),
                new Person(2, "Катя", new Car("ЛАДА Приора")),
                new Person(3, "Alex", new Car("Audi A4")),
                new Person(4, "Саша", new Car("Мазда"))
        );

        List<Car> cars = people.stream()
                .map(Person::getCar)
                .toList();

        System.out.println(cars);

        people.stream()
                .map(Person::getCar)
                .forEach(System.out::println);

        int[] ints = people.stream()
                .mapToInt(Person::getId)
                .toArray();

        System.out.println(Arrays.toString(ints));

        Integer[] integers = people.stream()
                .map(Person::getId)
                .toArray(Integer[]::new);

        System.out.println(Arrays.toString(integers));
    }
}
