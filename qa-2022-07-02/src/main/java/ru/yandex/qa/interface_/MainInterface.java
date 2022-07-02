package ru.yandex.qa.interface_;

public class MainInterface {

    public static void main(String[] args) {
        AnimalService animalService = new AnimalService();

        Dog dog = new Dog();
        Cat cat = new Cat();
        Tiger tiger = new Tiger();

        animalService.eatHome(dog);
        animalService.eatHome(cat);
        //animalService.eatHome(tiger);

        //animalService.hunt(dog);
        animalService.hunt(cat);
        animalService.hunt(tiger);
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
            System.out.println("Я собака и я хочу есть!!!");
        }
    }

    public static class Tiger implements WildAnimal {

        @Override
        public void hunting() {
            System.out.println("Я тигр и я вышел на охоту!!!");
        }
    }

    public static class Cat implements HomeAnimal, WildAnimal {

        @Override
        public void hunting() {
            System.out.println("Я кот и я вышел на охоту на мышей!!!");
        }

        @Override
        public void getEat() {
            System.out.println("Я кот пришел поесть!");
        }
    }
}
