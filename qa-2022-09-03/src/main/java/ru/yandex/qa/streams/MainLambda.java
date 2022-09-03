package ru.yandex.qa.streams;

import java.util.concurrent.Flow;
import java.util.function.Function;

@SuppressWarnings("all")
public class MainLambda {
    private String text = "MainLambda";

    public static void main(String[] args) {
        MainLambda mainLambda = new MainLambda();
        mainLambda.run();
    }

    private void run() {
        //1)
        myFunction myFunction = new myFunction();
        print(myFunction, "Текст!");

        //2)
        Function<String, Integer> function = new Function<>() {
            private String text = "Anonum";

            @Override
            public Integer apply(String o) {
                System.out.println(this.text);
                return o.length();
            }
        };
        print(function, "Текст!");

        //3)
        Function<String, Integer> functionLambda = o -> {
            //some logic
            return o.length();
        };
        print(functionLambda, "Текст!");

        Function<String, Integer> functionLambda2 = o -> o.length();
        print(functionLambda2, "Текст!");

        Function<String, Integer> functionLambda3 = String::length;
        print(functionLambda3, "Текст!");
    }

    public <T, R> void print(Function<T, R> function, T text) {
        R result = function.apply(text);
        System.out.println(text + " -> длинна строки: " + result);
    }

    class myFunction implements Function<String, Integer> {
        @Override
        public Integer apply(String s) {
            return s.length();
        }
    }
}
