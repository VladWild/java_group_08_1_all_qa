package ru.yandex.qa.modify_final;

import java.time.LocalDateTime;

public class MainFinal {
    private static final int DELIVERY_DAYS = 2;
    final int l;

    public MainFinal(int l) {
        this.l = l;
    }

    public static void main(String[] args) {
        final int k;
        k = 0;
        //k = 1; ошибка

        LocalDateTime.now().plusDays(DELIVERY_DAYS);

        System.out.println(k);

        new Object();

        new String();
    }

    public final static class Animal {

        public final void eat() {

        }
    }

    //public static class Cat extends Animal {

        /*@Override
        public void eat() {

        }*/
    //}
}
