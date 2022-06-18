package ru.yandex.qa.this_super;

import ru.yandex.qa.this_super.pac1.Point;
import ru.yandex.qa.this_super.pac1.Point3D;

public class MainThisSuper {

    public static void main(String[] args) {
        Point point = new Point(6, 9);
        System.out.println(point);

        Point3D point3D = new Point3D(-3, -89, 8);
        System.out.println(point3D);
    }
}
