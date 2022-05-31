package hexlet.courses.lesson7.theory;

public class Quadrate implements Geometric {
    private int sideSize;

    Quadrate(int sideSize) {
        this.sideSize = sideSize;
    }

    public int getSideSize() {
        return sideSize;
    }

    @Override
    public String getName() {
        return "quadrate";
    }

    @Override
    public int getSquare() {
        return sideSize * sideSize;
    }
}
