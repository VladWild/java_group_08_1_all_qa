package ru.yandex.qa.generics_java;

import java.util.ArrayList;

/*
 * В чем проблема?
 * Java не знает об типе, хранящемся в коллекции -> без дженериков надо делать постоянно Cast
 *
 * Без дженериков может быть java.lang.ClassCastException
 * Дженерики защищают нас от этого исключения -> программа даже не скомпилируется
 */
public class MainGenericsProblemsResolve {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Person("Игорь", 23));
        arrayList.add(new Person("Игорь 2", 23));
        arrayList.add(new Person("Игорь 3", 23));
        arrayList.add(new Person("Игорь 4", 23));

        Object o = arrayList.get(0);
        Person o1 = (Person) o;
        o1.getAge();
        o1.getName();

        //------------------------------

        ArrayList<Person> list = new ArrayList<>();
        //list.add(new Object());
        //list.add(new Integer(2));
        list.add(new Person("Игорь", 23));

        Person person = (Person) list.get(1);
    }

    public static class Person {
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
