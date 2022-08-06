package ru.yandex.qa.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class ComparatorMain {

    public static void main(String[] args) {
        Set<Person> people = new TreeSet<>(new PersonNameComparator());

        Person person = new Person(1, "Игорь", 12);
        Person person2 = new Person(2, "Катя", 45);
        Person person3 = new Person(3, "Александр", 45);
        Person person4 = new Person(4, "Александр", 32);
        Person person5 = new Person(5, "AAБорис", 34);
        Person person6 = new Person(6, "Александр", 45);

        people.add(person);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        people.add(person6);

        System.out.println(people);

        //----------------------------------------

        System.out.println("-----------------------------------------------------");

        List<Person> people2 = new ArrayList<>();

        people2.add(person);
        people2.add(person2);
        people2.add(person3);
        people2.add(person4);
        people2.add(person5);
        people2.add(person6);

        System.out.println("Not sorted: " + people2);
        Collections.sort(people2, new PersonAgeComparator());
        System.out.println("Sorted: " + people2);

        Collections.sort(people2, (o1, o2) -> {
            int i = o1.name.compareTo(o2.name);
            if (i == 0) {
                return 0;
            }
            return i;
        });
        System.out.println(people2);
    }

    private static class PersonNameComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            int i = o1.name.compareTo(o2.name);
            if (i == 0) {
                return o2.id - o1.id;
            }
            return i;
        }
    }

    private static class PersonAgeComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            int resultComp = o1.age - o2.age;
            if (resultComp == 0) {
                return o1.id - o2.id;
            }
            return resultComp;
        }
    }

    private static class Person {
        private Integer id;
        private String name;
        private int age;

        public Person(Integer id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
