package ru.yandex.qa.oop;

public class MainOOP {

    public static void main(String[] args) {
        Object object = new Point();
        System.out.println(object.toString());
    }

    public static class Point {
        private int x;
        private int y;

        public Point() {
            x = 0;
            y = 0;
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
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
