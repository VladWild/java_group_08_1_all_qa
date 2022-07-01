package ru.yandex.qa.interface_;

public class AnimalService {

    public void hunting(MainInterface.WildAnimal wildAnimal) {
        wildAnimal.hunting();
    }

    public void getEat(MainInterface.HomeAnimal homeAnimal) {
        homeAnimal.getEat();
    }
}
