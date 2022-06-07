package ru.yandex.qa;

import java.util.Arrays;
import java.util.Random;

public class MainArrayStarter {

    public static void main(String[] args) {
        Random random = new Random();

        //одномерный массив
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(0, 10);
        }

        System.out.println(Arrays.toString(array));
        System.out.println("------------------------------------");

        //двумерный массив
        int[][] array2 = new int[10][20];

        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                array2[i][j] = random.nextInt(0, 100);
            }
        }

        for (int i = 0; i < array2.length; i++) {
            System.out.println(Arrays.toString(array2[i]));
        }
    }
}
