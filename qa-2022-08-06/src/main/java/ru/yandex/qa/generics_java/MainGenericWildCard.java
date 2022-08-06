package ru.yandex.qa.generics_java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 *                Object
 *                  |
 *                Animal
 *         Cat               Dog
 *          |
 *        Kitten
 */
public class MainGenericWildCard {

    public static void main(String[] args) {
        List<Animal> animals = Arrays.asList(new Animal(), new Animal());
        List<Cat> cats = Arrays.asList(new Cat(), new Cat());
        List<Kitten> kittens = Arrays.asList(new Kitten(), new Kitten());
        List<Dog> dogs = Arrays.asList(new Dog(), new Dog());

        print(animals);
        print(cats);
        print(kittens);
        print(dogs);

        //printCat(animals);
        printCat(cats);
        printCat(kittens);
        //printCat(dogs);

        printNotCat(animals);
        printNotCat(cats);
        //printNotCat(kittens);
        //printNotCat(dogs);

        Collections.copy(animals, kittens);
        System.out.println(animals);

        //Collections.copy(kittens, animals);
    }

    public static void print(List<?> animals) {
        for (Object animal : animals) {
            System.out.println(animal);
        }
    }

    public static void printCat(List<? extends Cat> cats) {
        for (Cat cat : cats) {
            System.out.println(cat);
        }
    }

    public static void printNotCat(List<? super Cat> cats) {
        for (Object cat : cats) {
            System.out.println(cat);
        }
    }

    public static class Animal {

        @Override
        public String toString() {
            return "Animal{}";
        }
    }

    public static class Cat extends Animal {

        @Override
        public String toString() {
            return "Cat{}";
        }
    }

    public static class Kitten extends Cat {

        @Override
        public String toString() {
            return "Kitten{}";
        }
    }

    public static class Dog extends Animal {

        @Override
        public String toString() {
            return "Dog{}";
        }
    }
}
