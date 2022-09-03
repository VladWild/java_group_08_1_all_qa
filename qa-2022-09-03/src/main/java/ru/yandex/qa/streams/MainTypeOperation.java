package ru.yandex.qa.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainTypeOperation {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        Stream<Integer> integerStream = integers.stream()
                .filter(integer -> integer > 3);

        Set<Integer> integerSet = integerStream.collect(Collectors.toSet());

        System.out.println(integerSet);

        //Стрим нельзя использовать 2 раза!!!!
        Set<Integer> collect = integerStream
                .filter(integer -> integer > 4)
                .collect(Collectors.toSet());
        System.out.println(collect);
    }
}
