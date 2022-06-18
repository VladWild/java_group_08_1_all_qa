package ru.yandex.qa.enum_scanner;

import java.util.Scanner;

public class MainScannerEnum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        Color color = getColorEnum(str);
        System.out.println(color);

        switch (color) {
            case RED, BLUE -> {
                System.out.println("красный или синий");
            }
            //case BLUE -> System.out.println("синий");
            default -> System.out.println("другой цвет");
        }

        scanner.close();
    }

    public static enum Color {
        RED, BLUE, WHITE;
    }

    private static Color getColorEnum(String colorStr) {
        try {
            return Color.valueOf(colorStr);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception);
            return null;
        }
    }
}
