package ru.yandex.qa;

import java.util.Scanner;

public class MainScannerRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTrackerService stepTrackerService = new StepTrackerService(scanner);


        scanner.close();
    }

    static class StepTrackerService {
        private Scanner scanner;
        private MounthData[] mounthData;

        public StepTrackerService(Scanner scanner) {
            this.scanner = scanner;
            mounthData = new MounthData[12];
            for (int i = 0; i < mounthData.length; i++) {
                mounthData[i] = new MounthData();
            }
        }

        public void method1() {
            String s = scanner.nextLine();

            System.out.println(s);
        }

        public void method2() {
            String s = scanner.nextLine();

            System.out.println(s);
        }
    }

    static class MounthData {
        int[] steps = new int[30];
    }
}
