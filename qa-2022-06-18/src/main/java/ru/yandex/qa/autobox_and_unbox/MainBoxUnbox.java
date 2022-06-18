package ru.yandex.qa.autobox_and_unbox;

import java.util.ArrayList;

public class MainBoxUnbox {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        int i = 7;
        Integer integer = new Integer(7);

        /*int[] arryy = new int[]{1, 2};
        ArrayList<Integer> objects = new ArrayList<>();*/

        Integer integer2 = 6;

        i = integer.intValue();
    }
}
