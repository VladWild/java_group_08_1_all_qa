package ru.yandex.qa.streams.terminal;

import ru.yandex.qa.streams.entity.Car;
import ru.yandex.qa.streams.entity.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MainFindFirstFindAnyMinMax {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Игорь", new Car("LADA Granta")),
                new Person(2, "Катя", new Car("LADA Priora")),
                new Person(3, "Олег", new Car("Audi A4")),
                new Person(1, "Коля", new Car("Ferrari"))
        );

        Person person = people.stream()
                .peek(System.out::println) //быть аккуратнее
                .filter(person1 -> person1.getId() == 2)
                .findFirst()
                .orElse(null);
        System.out.println("--------------");
        System.out.println(person);

        Person person2 = people.stream()
                .filter(person1 -> person1.getId() == 3)
                .findAny()
                .orElse(null);
        System.out.println(person2);

        Optional<Person> min = people.stream()
                .min(Comparator.comparingInt(Person::getId));
        System.out.println(min.get());

        Optional<Person> max = people.stream()
                .max(Comparator.comparingInt(Person::getId));
        System.out.println(max.get());
    }
}
