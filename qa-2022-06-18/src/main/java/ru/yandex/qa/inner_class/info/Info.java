package ru.yandex.qa.inner_class.info;

public class Info {
    private String str;
    private int number;
    private boolean flag;

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
