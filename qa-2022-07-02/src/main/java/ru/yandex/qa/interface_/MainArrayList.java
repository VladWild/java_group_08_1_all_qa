package ru.yandex.qa.interface_;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MainArrayList {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        //List<Object> list = new LinkedList<>();

        algoritm(list);
    }

    public static void algoritm(List<Object> list) {
        //do something
        //list.peek();
        list.set(4, new Object());
    }
}
