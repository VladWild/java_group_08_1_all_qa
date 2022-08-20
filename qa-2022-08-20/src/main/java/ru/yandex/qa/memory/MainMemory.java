package ru.yandex.qa.memory;

import java.io.IOException;

public class MainMemory {

    public static void main(String[] args) {
        method();
    }

    private static void method() {
        if (true) {
            throw new MyIOE();
        }
    }


    public static class MyIOE extends RuntimeException {

    }
}
