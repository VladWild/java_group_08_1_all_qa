package ru.yandex.qa.modify_access.pac1;

public class Point {
    public String color;
    protected int x;
    int y;
    private int z;

    public String getColor() {
        return color;
    }

    protected int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    private int getZ() {
        return z;
    }

    private void method() {
        Point point = new Point();

        point.color = "RED";
        point.x = 1;
        point.y = 2;
        point.z = 3;

        point.getColor();
        point.getX();
        point.getY();
        point.getZ();
    }
}
