package ru.yandex.qa.generics_java;

/*
 * В чем проблема?
 * Java не знает об типе, хранящемся в коллекции -> без дженериков надо делать постоянно Cast
 *
 * Без дженериков может быть java.lang.ClassCastException
 * Дженерики защищают нас от этого исключения -> программа даже не скомпилируется
 */
public class MainGenericsProblemsResolve {

    public static void main(String[] args) {

    }
}
