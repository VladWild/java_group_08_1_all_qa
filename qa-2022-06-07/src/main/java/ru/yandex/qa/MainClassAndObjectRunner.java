package ru.yandex.qa;

import ru.yandex.qa.pack.Person1;

public class MainClassAndObjectRunner {

    public static void main(String[] args) {
        Person person = new Person("Игорь", 26);
        System.out.println(person);

        Person person1 = new Person();
        person1.setName("Саша");
        person1.setAge(23);
        System.out.println(person1);

        Person1 person11 = new Person1();
    }

    static class Person {
        private String name;
        private int age;

        public Person() {
        }

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
