package ru.yandex.qa.streams.terminal;

import ru.yandex.qa.streams.entity.Car;
import ru.yandex.qa.streams.entity.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.lang.String.CASE_INSENSITIVE_ORDER;

public class MainFindFirstFindAnyFindMax {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(2, "Игорь", new Car("ЛАДА Гранта")),
                new Person(1, "Катя", new Car("ЛАДА Приора")),
                new Person(3, "Alex", new Car("Audi A4")),
                new Person(4, "Саша", new Car("Мазда"))
        );

        //people.forEach(System.out::println);

        people.forEach(person -> {

        });

        for (Person person : people) {
            //dfgdfgfg
            //dfgdfgfg
            //dfgdfgfg
            //dfgdfgfg
        }

        Optional<Person> first = people.stream().findFirst();
        if (first.isPresent()) {
            first.get();
        }

        Person person = people.stream().findFirst().orElse(null);
        //System.out.println(person);

        Person personFirst = people.stream()
                .filter(p -> p.getId() > 2)
                .findFirst()
                .orElse(null);

        System.out.println(personFirst);

        Person personFirst2 = people.stream()
                .sorted((p1, p2) -> -p1.getName().compareTo(p2.getName()))
                .findFirst()
                .orElse(null);
        System.out.println(personFirst2);
    }
}
