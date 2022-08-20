package ru.yandex.qa.exceptions;

public class MainExceptions {

    public static void main(String[] args) {
        int i = 8;
        Object o = new Object();

        String str = new String("str");
        String str2 = new String("str");
        System.out.println(str == str2);

        String str3 = "rt";
        String str4 = "rt";
        System.out.println(str3 == str4);
    }
}
