package ru.yandex.qa.varargs;

import java.util.Arrays;

public class Logger {
    private String[] param;

    public void log(String... param) {
        System.out.println(Arrays.toString(param));
    }

    public void log(String meggase, int... param) {
        System.out.println(String.format(meggase, param[0], param[1]));
    }
}
