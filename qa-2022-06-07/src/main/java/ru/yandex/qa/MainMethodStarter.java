package ru.yandex.qa;

public class MainMethodStarter {

    public static void main(String[] args) {
        print();

        print("Этот текст я прокинул в метод!");

        String begin = getBegin("Привет! Как дела?");
        print(begin);

        StringInfo stringInfo = getStringInfo("Привет! Как дела?");
        print(stringInfo);
    }

    private static void print() {
        System.out.println("Привет!");
    }

    private static void print(String text) {
        System.out.println(text);
    }

    private static void print(Object text) {
        System.out.println(text);
    }

    private static String getBegin(String text) {
        return text.substring(0, 5);
    }

    private static StringInfo getStringInfo(String text) {
        String begin = text.substring(0, 5);
        String end = text.substring(text.length() - 5, text.length());
        return new StringInfo(begin, end);
    }

    static class StringInfo {
        private String begin;
        private String end;

        public StringInfo(String begin, String end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public String toString() {
            return "StringInfo{" +
                    "begin='" + begin + '\'' +
                    ", end='" + end + '\'' +
                    '}';
        }
    }
}
