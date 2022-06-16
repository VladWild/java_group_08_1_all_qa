package ru.yandex.qa.this_super;

import ru.yandex.qa.this_super.pac1.Point;
import ru.yandex.qa.this_super.pac1.Point3D;

public class MainThisSuper {

    public static void main(String[] args) {
        Point point = new Point(4, 7);
        System.out.println(point);

        Point3D point3D = new Point3D(5, 7, 9);
        System.out.println(point3D);
    }
}
