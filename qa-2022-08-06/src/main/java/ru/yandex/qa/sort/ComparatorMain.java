package ru.yandex.qa.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ComparatorMain {

    public static void main(String[] args) {
        Person person = new Person(1, "Игорь", 12);
        Person person2 = new Person(2, "Катя", 45);
        Person person3 = new Person(3, "Александр", 32);
        Person person4 = new Person(4,"Александр", 32);
        Person person5 = new Person(5, "Борис", 34);

        Set<Person> peopleSortName = new TreeSet<>(new PersonNameComparator());

        peopleSortName.add(person);
        peopleSortName.add(person2);
        peopleSortName.add(person3);
        peopleSortName.add(person4);
        peopleSortName.add(person5);

        System.out.println("Сортировка по имени: " + peopleSortName);

        Set<Person> peopleSortAge = new TreeSet<>(new PersonAgeComparator());

        peopleSortAge.add(person);
        peopleSortAge.add(person2);
        peopleSortAge.add(person3);
        peopleSortAge.add(person4);
        peopleSortAge.add(person5);

        System.out.println("Сортировка по возрасту: " + peopleSortAge);

        //---------------------------------------------------

        System.out.println("-----------------------------------------------------");

        List<Person> people2 = new ArrayList<>();

        people2.add(person);
        people2.add(person2);
        people2.add(person3);
        people2.add(person4);
        people2.add(person5);

        System.out.println("Not sorted: " + people2);
        Collections.sort(people2, new PersonNameComparator());
        System.out.println("Sorted: " + people2);
    }

    public static class PersonNameComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            if (o1.name == null) {
                return -1;
            }
            int resultName = o1.name.compareTo(o2.name);
            if (resultName == 0) {
                return o1.id - o2.id;
            }
            return resultName;
        }
    }

    public static class PersonAgeComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            int resultAge = o1.age - o2.age;
            if (resultAge == 0) {
                return o1.id - o2.id;
            }
            return resultAge;
        }
    }

    public static class Person {
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
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
