package hexlet.courses;

public class Point {
    private int coordinateX;
    private int coordinateY;

    Point(int x, int y) {
        this.coordinateX = x;
        this.coordinateY = y;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }
}
