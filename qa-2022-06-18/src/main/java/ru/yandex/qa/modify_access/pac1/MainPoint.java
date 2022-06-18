package ru.yandex.qa.modify_access.pac1;

public class MainPoint {

    public static void main(String[] args) {
        Point point = new Point();

        point.color = "RED";
        point.x = 1;
        point.y = 2;
        //point.z = 3;

        point.getColor();
        point.getX();
        point.getY();
        //point.getZ();
    }
}
