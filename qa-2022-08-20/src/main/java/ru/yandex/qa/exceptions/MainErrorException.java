package ru.yandex.qa.exceptions;

import java.util.ArrayList;

public class MainErrorException {

    public static void main(String[] args) {
        //method();

        ArrayList<Object> list = new ArrayList<>();

        for (int i = 0; i < 1_000_000_000; i++) {
            list.add(new Object());
        }
    }

    private static void method() {
        method();
    }
}
