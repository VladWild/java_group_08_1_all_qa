package ru.yandex.qa.interface_;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainlinkedLinkedList {

    public static void main(String[] args) {
        LinkedList<Object> list = new LinkedList<>();

        new ArrayDeque<>();

        algoritm(list);
        algoritm(new ArrayList<>());
    }

    private static void algoritm(List<Object> list) {
        //list.peek();
        list.get(list.size() - 1);
        list.set(3, new Object());

        //-------
    }
}
