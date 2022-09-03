package ru.yandex.qa.streams.terminal;

import ru.yandex.qa.streams.entity.Car;
import ru.yandex.qa.streams.entity.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainCoollect {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Игорь", new Car("ЛАДА Гранта")),
                new Person(2, "Катя", new Car("ЛАДА Приора")),
                new Person(3, "Alex", new Car("Audi A4")),
                new Person(4, "Саша", new Car("Мазда"))
        );

        List<Person> peopleList = people.stream().collect(Collectors.toList());
        List<Person> peopleList2 = people.stream().toList(); //java 17

        Set<Person> peopleSet = people.stream().collect(Collectors.toSet());

        Map<Integer, Person> peopleMap = people.stream()
                .collect(Collectors.toMap(Person::getId, person -> person));
        System.out.println(peopleMap);

        Map<Integer, Person> peopleMap2 = people.stream()
                .collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println(peopleMap2);

        Map<Integer, Person> peopleMap3 = people.stream()
                .collect(Collectors.toMap(Person::getId, Person::getPerson));
        System.out.println(peopleMap3);

        Map<Integer, Car> peopleMapCar = people.stream()
                .collect(Collectors.toMap(Person::getId, Person::getCar));
        System.out.println(peopleMapCar);

        System.out.println("----------");

        //----------------

        List<Person> people2 = Arrays.asList(
                new Person(1, "Игорь", new Car("ЛАДА Гранта")),
                new Person(2, "Катя", new Car("ЛАДА Приора")),
                new Person(3, "Alex", new Car("Audi A4")),
                new Person(1, "Саша", new Car("Мазда"))
        );

        Map<Integer, Person> people2Map = people2.stream()
                .collect(Collectors.toMap(Person::getId, Function.identity(), (p1, p2) -> {
                    if (p1.getName().length() > p2.getName().length()) {
                        return p1;
                    }
                    return p2;
                }));
        System.out.println(people2Map);

        Map<Integer, Person> people2Map2 = people2.stream()
                .collect(Collectors.toMap(Person::getId, Function.identity(), (p1, p2) -> {
                    if (p1.getName().length() < p2.getName().length()) {
                        return p1;
                    }
                    return p2;
                }));
        System.out.println(people2Map2);

        System.out.println("---------------");

        //-------------------------

        Map<Integer, Person> collect = people2.stream()
                .distinct()
                .collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println(collect);
        System.out.println("--------------------");

        //----------------------------

        Map<Integer, List<Person>> personIdPersonList = people2.stream()
                .collect(Collectors.groupingBy(Person::getId));
        System.out.println(personIdPersonList);
    }
}
