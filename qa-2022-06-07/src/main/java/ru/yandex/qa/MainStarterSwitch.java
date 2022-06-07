package ru.yandex.qa;

import java.util.Scanner;

public class MainStarterSwitch {

    public static void main(String[] args) {
        //число
        //exampleInt();

        //строка
        //exampleStr()

        //enum
        //exampleEnum();

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        Color color = Color.valueOf(s);
        System.out.println(color);

        String s1 = scanner.nextLine();
        Long aLong = Long.valueOf(s1);

        scanner.close();
    }

    private static enum Color {
        WHITE, BLUE, RED, GREEN, GRAY;
    }

    private static void exampleInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        int number = scanner.nextInt();

        switch (number) {
            case 0:
                System.out.println("Вы ввели 0");
                break;
            case 1:
                System.out.println("Вы ввели 1");
                break;
            case 2, 3:
                System.out.println("Вы ввели 2 или 3");
                break;
            default:
                System.out.println("Вы ввели другое число");
        }

        scanner.close();
    }

    private static void exampleStr() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String str = scanner.nextLine();

        switch (str) {
            case "One", "Two":
                System.out.println("Вы ввели One или Two");
                break;
            default:
                System.out.println("Вы ввели что-то другое");
        }

        scanner.close();
    }

    private static void exampleEnum() {
        Color color = Color.GRAY;

        switch (color) {
            case WHITE -> System.out.println("Белый");
            case BLUE -> System.out.println("Синий");
            case RED, GREEN -> System.out.println("Красный или зеленый");
            default -> System.out.println("Неизвестный цвет");
        }
    }
}
