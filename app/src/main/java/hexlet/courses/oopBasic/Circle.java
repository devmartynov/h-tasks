package hexlet.courses.oopBasic;

public class Circle implements Geometric {
    public int x;
    public int y;
    public int radius;

    Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    Circle(int radius) {
        this.x = 0;
        this.y = 0;
        this.radius = radius;
    }

    @Override
    public String getName() {
        return "circle";
    }

    @Override
    public int getSquare() {
        return (int)(Math.PI * radius * radius);
    }
}
