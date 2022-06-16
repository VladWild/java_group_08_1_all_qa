package ru.yandex.qa.auto_box_and_unbox;

import java.util.ArrayList;

public class MainAutoBoxAndUnbox {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        int i = 2;
        Integer integer = new Integer(4);
        Integer integer2 = 4;

        i = integer.intValue();
        System.out.println(i);

        integer2 = new Integer(i);
        System.out.println(integer2);

        ArrayList<Integer> integers = new ArrayList<>();
        //ArrayList<int> integers = new ArrayList<>();
    }
}
