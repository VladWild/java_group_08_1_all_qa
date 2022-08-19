package ru.yandex.qa.memory;

public class MainMemory {

    public static void main(String[] args) {
        int i = 0;
        Object object = new Object();

        String dcdsc = new String("dcdsc");
        System.out.println(new String("dcdsc") == dcdsc);

        String str = "dff";
        String str2 = "dff";
        System.out.println(str == str2);
    }
}
