package ru.yandex.qa.modify_static;

public class MainStaticMethod {

    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.eat();

        Animal.eat();

        Animal anumal = null;
        anumal.eat();

        int sum = MathUtils.sum(3, 4);
        System.out.println(sum);

        int abs = Math.abs(-678);
        System.out.println(abs);
    }

    public static class Animal {

        public static void eat() {
            System.out.println("Я зверушку, которая ест!!");
        }
    }

    public static class Cat extends Animal {

        //@Override
        public static void eat() {
            System.out.println("Я кот, которая ест!!");
        }
    }

    public static class MathUtils {

        private MathUtils() {};

        public static int sum(int x, int y) {
            return x + y;
        }
    }
}
