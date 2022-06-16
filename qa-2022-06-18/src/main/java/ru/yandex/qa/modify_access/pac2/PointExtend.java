package ru.yandex.qa.modify_access.pac2;

import ru.yandex.qa.modify_access.pac1.Point;

public class PointExtend extends Point {

    private void method() {
        PointExtend point = new PointExtend();

        point.x = 1;
        point.y = 1;
        //point.z = 1;
        //point.color = "BLUE";

        point.getX();
        point.getY();
        //point.getZ();
        //point.getColor();
    }
}
