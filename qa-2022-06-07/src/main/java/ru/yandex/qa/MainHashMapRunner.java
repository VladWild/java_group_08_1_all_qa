package ru.yandex.qa;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainHashMapRunner {

    public static void main(String[] args) {
        Map<String, Person> map = new LinkedHashMap<>();
        map.put("человек1", new Person("Игорь", 25));
        map.put("человек2", new Person("Саша", 23));
        System.out.println(map);

        Person человек1 = map.get("человек1");
        System.out.println(человек1);

        Map<String, Person> treeMap = new TreeMap<>();

        Map<String, Person[]> map2 = new LinkedHashMap<>();
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
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
