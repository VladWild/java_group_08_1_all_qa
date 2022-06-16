package ru.yandex.qa.modify_access;

import ru.yandex.qa.modify_access.pac2.PointExtend;

public class MainModifyAccess {

    public static void main(String[] args) {
        PointExtend point = new PointExtend();

        point.x = 1;
        //point.y = 1;
        //point.z = 1;
        //point.color = "BLUE";

        point.getX();
        //point.getY();
        //point.getZ();
        //point.getColor();
    }
}
