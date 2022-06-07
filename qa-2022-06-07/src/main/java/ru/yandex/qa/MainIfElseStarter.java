package ru.yandex.qa;

import java.util.Scanner;

public class MainIfElseStarter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer number = scanner.nextInt();

        if (number.equals(1)) {
            System.out.println("Вы вывели 1");
        } else if (number.equals(2)) {
            System.out.println("Вы ввели 2");
        } else {
            System.out.println("Я не знаю что вы ввели!");
        }
    }
}
