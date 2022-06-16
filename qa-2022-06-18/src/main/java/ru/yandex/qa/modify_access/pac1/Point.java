package ru.yandex.qa.modify_access.pac1;

public class Point {
    public int x;
    protected int y;
    int z;
    private String color;

    public int getX() {
        return x;
    }

    protected int getY() {
        return y;
    }

    int getZ() {
        return z;
    }

    private String getColor() {
        return color;
    }

    private void method() {
        Point point = new Point();

        point.x = 1;
        point.y = 1;
        point.z = 1;
        point.color = "BLUE";

        point.getX();
        point.getY();
        point.getZ();
        point.getColor();
    }
}
