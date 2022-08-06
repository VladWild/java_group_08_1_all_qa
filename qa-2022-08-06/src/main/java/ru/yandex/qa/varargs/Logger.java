package ru.yandex.qa.varargs;

import java.util.Arrays;

public class Logger {

    public void log(String... param) {
        System.out.println(Arrays.toString(param));
    }

    public void log(String message, int... param) {
        System.out.println(String.format(message, param[0], param[1]));
    }
}
