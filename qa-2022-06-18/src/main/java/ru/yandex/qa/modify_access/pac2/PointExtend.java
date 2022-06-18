package ru.yandex.qa.modify_access.pac2;

import ru.yandex.qa.modify_access.pac1.Point;

public class PointExtend extends Point {

    private void method() {
        PointExtend point = new PointExtend();

        point.color = "RED";
        point.x = 1;
        //point.y = 2;
        //point.z = 3;

        point.getColor();
        point.getX();
        //point.getY();
        //point.getZ();
    }
}
