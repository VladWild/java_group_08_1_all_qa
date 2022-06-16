package ru.yandex.qa.reference_value;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MainReferenceValue {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        int i = 1;
        increment(i);
        System.out.println(i);
        System.out.println("--------------------------------");

        AtomicInteger atomicInteger = new AtomicInteger(1);
        increment(atomicInteger);
        System.out.println(atomicInteger);
        System.out.println("--------------------------------");

        Integer integer = new Integer(1);
        increment(integer);
        System.out.println(integer);
        System.out.println("--------------------------------");

        int[] ints = new int[]{1, 2, 3, 4};
        increment(ints);
        System.out.println(Arrays.toString(ints));
        System.out.println("--------------------------------");
    }

    public static void increment(int i) {
        i = i + 1;
    }

    public static void increment(AtomicInteger i) {
        i.incrementAndGet();
    }

    public static void increment(Integer i) {
        i = i + 1;
    }

    private static void increment(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            ints[i]++;
        }
    }
}
