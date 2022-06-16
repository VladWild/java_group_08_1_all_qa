package ru.yandex.qa.modify_final;

public class MainFinal {
    final int l = 0; //показать, что обязательно надо проинициализировать

    public static void main(String[] args) {
        final int k;
        k = 0;
        //k = 1; //так нельзя

        new Object(); //тут пример final показать

        String string = ""; //показать что от него нельзя наследоваться
    }

    public final static class Animal {

        public final void eat() {
            System.out.println("Я зверушка и я ем!");
        }
    }

    //public static class Cat extends Animal {

        /*
        @Override
        public void eat() {
            System.out.println("Я кот и я ем!");
        }
        */
    //}
}
