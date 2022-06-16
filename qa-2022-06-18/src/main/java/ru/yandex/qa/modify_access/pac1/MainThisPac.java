package ru.yandex.qa.modify_access.pac1;

public class MainThisPac {

    public static void main(String[] args) {
        Point point = new Point();

        point.x = 1;
        point.y = 1;
        point.z = 1;
        //point.color = "BLUE";

        point.getX();
        point.getY();
        point.getZ();
        //point.getColor();
    }
}
