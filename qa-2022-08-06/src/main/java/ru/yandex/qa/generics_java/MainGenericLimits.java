package ru.yandex.qa.generics_java;

/**
 * 1) Generic-и не работают с примитивами
 * 2) Во время выполнения нет никакой информации о типе -> вся информация удаляется во время компиляции
 * 3) Нельзя создать объект Generic-а внутри класса, который содержит его
 * 4) Нельзя создать массив Generic-а внутри класса, который содержит его
 * 5) Невозможно создать массив Generic-классов
 * 6) Generic-и не могут быть статическими (следствие 3)
 */
public class MainGenericLimits {

    public static void main(String[] args) {

    }
}