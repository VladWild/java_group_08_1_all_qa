package ru.yandex.qa.streams;

import java.util.function.Function;

@SuppressWarnings("all")
public class MainLambda {
    private String test2 = "MainLambda";

    public static void main(String[] args) {
        MainLambda mainLambda = new MainLambda();
        mainLambda.run();
    }

    public void run() {
        MyFunction function = new MyFunction();
        print(function, "Посчитай длинну этого текста!");

        Function<String, Integer> function2 = new Function<>() {
            private String test2 = "AnonumClass";

            @Override
            public Integer apply(String s) {
                System.out.println(this.test2);
                return s.length();
            }
        };
        print(function2, "Посчитай длинну этого текста!");

        //-----------------------------------------------

        Function<String, Integer> function3 = str -> {
            System.out.println(this.test2);
            return str.length();
        };
        print(function3, "Посчитай длинну этого текста!");

        Function<String, Integer> function4 = str -> str.length();
        print(function4, "Посчитай длинну этого текста!");

        Function<String, Integer> function5 = String::length;
        print(function5, "Посчитай длинну этого текста!");
    }

    public <T, R> void print(Function<T, R> function, T text) {
        R count = function.apply(text); //text.length()
        System.out.println(count);
    }

    class MyFunction implements Function<String, Integer> {

        @Override
        public Integer apply(String s) {
            return s.length();
        }
    }
}

