package hexlet.courses.lesson7.exercises.n1;

public class Circle {
    private final int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}
