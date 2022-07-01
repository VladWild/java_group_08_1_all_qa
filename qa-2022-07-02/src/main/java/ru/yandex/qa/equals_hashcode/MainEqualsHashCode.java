package ru.yandex.qa.equals_hashcode;

import java.util.Objects;

public class MainEqualsHashCode {

    public static void main(String[] args) {
        Point point = new Point(Color.RED, 4, 6);
        Point point2 = new Point(Color.RED, 4, 6);
        boolean equals = point.equals(point2);
        System.out.println(equals);

        int pointHashCode = point.hashCode();
        int pointHashCode2 = point2.hashCode();
        System.out.println(pointHashCode);
        System.out.println(pointHashCode2);

        Point point3 = new Point(Color.RED, 34, 56);
        int pointHashCode3 = point3.hashCode();
        System.out.println(pointHashCode3);

        Point point4 = new Point(Color.RED, 6, 4);
        int pointHashCode4 = point4.hashCode();
        System.out.println(pointHashCode4);
    }

    public enum Color {
        RED, BLUE, GREEN;
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

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y && color == point.color;
        }

        @Override
        public int hashCode() {
            return x + y;
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
