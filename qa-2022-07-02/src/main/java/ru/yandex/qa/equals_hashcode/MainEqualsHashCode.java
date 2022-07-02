package ru.yandex.qa.equals_hashcode;

import java.util.Objects;

public class MainEqualsHashCode {

    public static void main(String[] args) {
        Point point = new Point(Color.RED, 4, 7);
        Point point2 = new Point(Color.RED, 4, 7);
        boolean equals = point.equals(point2);
        System.out.println(equals);

        int pointHash = point.hashCode();
        int point2Hash = point2.hashCode();
        System.out.println(pointHash);
        System.out.println(point2Hash);

        Point point3 = new Point(Color.RED, 3, 10);

        int point3Hash = point3.hashCode();
        System.out.println(point3Hash);

        Point point4 = new Point(Color.RED, 7, 4);
        int point4Hash = point4.hashCode();
        System.out.println(point4Hash);
    }

    public static enum Color {
        RED, BLUE, GREEN;
    }

    public static class Point {
        private final Color color;
        private final double x;
        private final int y;

        public Point(Color color, double x, int y) {
            this.color = color;
            this.x = x;
            this.y = y;
        }

        public Color getColor() {
            return color;
        }

        public double getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y && color == point.color;
        }

        @Override
        public int hashCode() {
            return Objects.hash(color, x, y);
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
}
