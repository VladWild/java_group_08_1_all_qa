package ru.yandex.qa.equals;

import java.util.Objects;

public class MainEquals {

    public static void main(String[] args) {
        Point point = new Point(Color.RED, 4, 6);
        Point point2 = new Point(Color.BLUE, 4, 6);
        System.out.println(point.equals(point2));
        //System.out.println(point.equals(point));
    }

    private enum Color {
        RED("красный"), BLUE("синий"), WHITE("белый");

        private final String info;

        Color(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
    }

    public static class Point {
        private Color color;
        private int x;
        private int y;

        public Point(Color color, int x, int y) {
            this.color = color;
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || this.getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "color=" + color +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static class PointExtend extends Point {

        public PointExtend(Color color, int x, int y) {
            super(color, x, y);
        }
    }
}
