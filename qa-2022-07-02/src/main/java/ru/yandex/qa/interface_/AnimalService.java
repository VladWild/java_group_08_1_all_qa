package ru.yandex.qa.interface_;

public class AnimalService {

    public void hunt(MainInterface.WildAnimal wildAnimal) {
        wildAnimal.hunting();
    }

    public void eatHome(MainInterface.HomeAnimal homeAnimal) {
        homeAnimal.getEat();
    }
}
