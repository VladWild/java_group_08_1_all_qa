package ru.yandex.qa.modify_static;

public class MainStaticField {

    public static void main(String[] args) {
        Point point = new Point("RED", 4, 6);
        Point point2 = new Point("BLUE", -2, -3);
        Point point3 = new Point("YELLOW", 2, 8);

        //статическая переменная привязана к классу
        Point.color = "WHITE";

        System.out.println(point);
        System.out.println(point2);
        System.out.println(point3);

        //static final - чаще всего
    }

    public static class Point {
        private static String color;
        private int x;
        private int y;

        public Point(String color, int x, int y) {
            this.color = color;
            this.x = x;
            this.y = y;
        }

        public static String getColor() {
            return color;
        }

        public static void setColor(String color) {
            Point.color = color;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "color='" + color + '\'' +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
