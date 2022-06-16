package ru.yandex.qa.modify_static;

public class MainStaticMethod {

    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.eat();

        System.out.println("--------------------------------");
        //метод жестко привязан к классу
        Animal.eat();
        Cat.eat();
        System.out.println("--------------------------------");

        //чаще всего применяется в утилитных классах
        int sum = MathUtils.sum(2, 4);
        System.out.println(sum);

        System.out.println("--------------------------------");
        int abs = Math.abs(-2);
        System.out.println(abs);
    }

    public static class Animal {

        public static void eat() {
            System.out.println("Я зверушка и я ем!");
        }
    }

    public static class Cat extends Animal {

        //@Override
        public static void eat() {
            System.out.println("Я кот и я ем!");
        }
    }

    public static class MathUtils {
        private MathUtils() {}

        public static int sum(int a, int b) {
            return a + b;
        }
    }
}
