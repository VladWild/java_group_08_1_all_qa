package ru.yandex.qa.streams.terminal;

import ru.yandex.qa.streams.entity.Car;
import ru.yandex.qa.streams.entity.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainCollect {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Игорь", new Car("LADA Granta")),
                new Person(2, "Катя", new Car("LADA Priora")),
                new Person(3, "Олег", new Car("Audi A4")),
                new Person(1, "Коля", new Car("Ferrari"))
        );

        List<Person> peopleList = people.stream().toList();
        List<Person> peopleList2 = people.stream().collect(Collectors.toList());


        Set<Person> peopleSet = people.stream().collect(Collectors.toSet());

        Map<Integer, Person> peopleMap = people.stream()
                .collect(Collectors.toMap(Person::getId, person -> person, (p1, p2) -> {
                    if (p1.getName().length() > p2.getName().length()) {
                        return p1;
                    }
                    return p2;
                }));
        System.out.println(peopleMap);

        Map<Integer, Person> peopleMap2 = people.stream()
                .collect(Collectors.toMap(Person::getId, Function.identity(), (p1, p2) -> {
                    if (p1.getName().length() > p2.getName().length()) {
                        return p2;
                    }
                    return p1;
                }));
        System.out.println(peopleMap2);

        Map<Integer, List<Person>> peopleMapAll = people.stream()
                .collect(Collectors.groupingBy(Person::getId));

        System.out.println(peopleMapAll);

        Long size = people.stream().collect(Collectors.counting());
        System.out.println(size);
    }
}
