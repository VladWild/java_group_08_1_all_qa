package ru.yandex.qa.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ComparableMain {

    public static void main(String[] args) {
        Set<Person> people = new TreeSet<>();

        Person person = new Person(1, "Игорь", 12);
        Person person2 = new Person(2, "Катя", 45);
        Person person3 = new Person(3, "Александр", 45);
        Person person4 = new Person(4, "Александр", 32);
        Person person5 = new Person(5, "Борис", 34);

        people.add(person);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);

        System.out.println(people);

        //---------------------------------------------

        System.out.println("----------------------------------------------------");

        List<Person> people2 = new ArrayList<>();

        people2.add(person);
        people2.add(person2);
        people2.add(person3);
        people2.add(person4);
        people2.add(person5);

        System.out.println("Не сортированный список: " + people2);
        Collections.sort(people2);
        System.out.println("Сортированный список: " + people2);
    }

    private static class Person implements Comparable<Person> {
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

        public void setAge(int age) {
            this.age = age;
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

        @Override
        public int compareTo(Person o) {
            int ageResult = this.age - o.age;
            if (ageResult == 0) {
                return this.id - o.id;
            }
            return ageResult;
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
