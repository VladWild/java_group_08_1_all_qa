package ru.yandex.qa.read_file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainReadFile {

    public static void main(String[] args) {
        String str = readFile("qa-2022-06-18/src/main/resources/example.csv");
        System.out.println(str);

        if (str != null) {
            String[] split = str.split(System.lineSeparator());
            System.out.println(Arrays.toString(split));

            List<Info> infos = new ArrayList<>();

            for (int i = 1; i < split.length; i++) {
                String[] elements = split[i].split(";");
                Info info = new Info(elements[0], Integer.parseInt(elements[1]), Boolean.parseBoolean(elements[2]));
                infos.add(info);
            }

            System.out.println("--------------------------------------");
            System.out.println(infos);
        }
    }

    private static String readFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public static class Info {
        private final String str;
        private final int number;
        private final boolean flag;

        public Info(String str, int number, boolean flag) {
            this.str = str;
            this.number = number;
            this.flag = flag;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "str='" + str + '\'' +
                    ", number=" + number +
                    ", flag=" + flag +
                    '}';
        }
    }
}
