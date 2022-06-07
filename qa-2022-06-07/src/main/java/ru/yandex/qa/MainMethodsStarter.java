package ru.yandex.qa;

public class MainMethodsStarter {

    public static void main(String[] args) {
        print();

        print("Послали в метод!");

        String begin = getBegin("Привет! Как дела?");
        System.out.println(begin);

        String begin1 = getBegin("Привет! Как дела?", 10);
        System.out.println(begin1);

        System.out.println("--------------------------------");

        StringInfo beginAndEnd = getBeginAndEnd("Привет! Как дела? Как настроение?");
        System.out.println(beginAndEnd);
        System.out.println(beginAndEnd.getBegin());
        System.out.println(beginAndEnd.getEnd());
    }

    private static StringInfo getBeginAndEnd(String text) {
        String begin = text.substring(0, 6);
        String end = text.substring(text.length() - 6);
        return new StringInfo(begin, end);
    }

    private static String getBegin(String s) {
        String substring = s.substring(0, 6);
        return substring;
    }

    private static String getBegin(String s, int k) {
        String substring = s.substring(0, k);
        return substring;
    }

    private static void print() {
        System.out.println("Привет!");
    }

    private static void print(String str) {
        System.out.println(str);
    }

    static class StringInfo {
        private String begin;
        private String end;

        public StringInfo(String begin, String end) {
            this.begin = begin;
            this.end = end;
        }

        public String getBegin() {
            return begin;
        }

        public void setBegin(String begin) {
            this.begin = begin;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
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
