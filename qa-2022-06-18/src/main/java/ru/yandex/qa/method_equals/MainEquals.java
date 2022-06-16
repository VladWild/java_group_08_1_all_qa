package ru.yandex.qa.method_equals;

public class MainEquals {

    public static void main(String[] args) {
        Point point = new Point(5, 6, Color.BLUE);
        Point point2 = new Point3D(5, 6, Color.BLUE);
        System.out.println(point.equals(point2));
    }

    private enum Color {
        RED, BLUE, GREEN;
    }

    public static class Point {
        private final int x;
        private final int y;
        private final Color color;

        public Point(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y && color == point.color;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", color=" + color +
                    '}';
        }
    }

    public static class Point3D extends Point {

        public Point3D(int x, int y, Color color) {
            super(x, y, color);
        }
    }
}
