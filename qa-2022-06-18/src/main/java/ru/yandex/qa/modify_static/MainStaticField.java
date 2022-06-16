package ru.yandex.qa.modify_static;

public class MainStaticField {

    public static void main(String[] args) {
        Point point = new Point("RED", 4, 5);
        Point point2 = new Point("BLUE", 2, -7);
        Point point3 = new Point("GRAY", 1, 9);

        System.out.println(point);
        System.out.println(point2);
        System.out.println(point3);

        //статическая переменная привязана к классу

        Point.color = "YELLOW";

        System.out.println(point);
        System.out.println(point2);
        System.out.println(point3);

        //чаще всего применяется с можификатором final
        //static final
    }

    public static class Point {
        public static String color;
        private int x;
        private int y;

        public Point(String color, int x, int y) {
            this.color = color;
            this.x = x;
            this.y = y;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
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
