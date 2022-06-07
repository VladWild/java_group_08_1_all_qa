package ru.yandex.qa;

import java.util.Scanner;

public class MainSwitchStarter {

    public static void main(String[] args) {
        //int
        //exampleInt();

        //String
        //exampleString();

        //java 14 / Enum

        Color color = Color.GRAY;

        switch (color) {
            case RED -> System.out.println("Красный");
            case BLUE, GREEN -> System.out.println("Синий или зеленый");
            case WHITE -> System.out.println("Белый");
            default -> System.out.println("Неизвестный цвет");
        }
    }

    public static enum Color {
        RED, BLUE, GREEN, WHITE, GRAY;
    }

    private static void exampleInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int number = scanner.nextInt();

        switch (number)  {
            case 0:
                System.out.println("Вы нажали 0");
                break;
            case 1:
                System.out.println("Вы нажали 1");
                break;
            case 2:
            case 3:
                System.out.println("Вы нажали или 2, или 3");
                break;
            default:
                System.out.println("Вы нажали что-то неизвестное");
        }

        scanner.close();
    }

    private static void exampleString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String str = scanner.nextLine();

        switch (str) {
            case "Zero":
                System.out.println("Вы ввели Zero");
                break;
            case "One":
                System.out.println("Вы ввели One");
                break;
            default:
                System.out.println("Неизвстная команда");
        }
    }
}
