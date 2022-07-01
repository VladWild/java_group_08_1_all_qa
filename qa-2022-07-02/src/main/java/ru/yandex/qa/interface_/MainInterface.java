package ru.yandex.qa.interface_;

public class MainInterface {

    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Tiger tiger = new Tiger();

        AnimalService animalService = new AnimalService();

        animalService.getEat(cat);
        animalService.getEat(dog);
        //animalService.getEat(tiger);

        animalService.hunting(cat);
        //animalService.hunting(dog);
        animalService.hunting(tiger);
    }

    public interface WildAnimal {

        void hunting();
    }

    public interface HomeAnimal {

        void getEat();
    }

    public static class Dog implements HomeAnimal {

        @Override
        public void getEat() {
            System.out.println("Я собака и я хочу есть!!!!!!");
        }
    }

    public static class Tiger implements WildAnimal {

        @Override
        public void hunting() {
            System.out.println("Я вышел на охоту, чтобы поесть!!!!!");
        }
    }

    public static class Cat implements HomeAnimal, WildAnimal {

        @Override
        public void hunting() {
            System.out.println("Я кот, пришел поесть!!!!");
        }

        @Override
        public void getEat() {
            System.out.println("Я кот и я вышел на охоту на мышей!!!!");
        }
    }
}
