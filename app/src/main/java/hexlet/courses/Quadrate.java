package hexlet.courses;

public class Quadrate implements Geometric {
    private int sideSize;

    Quadrate(int sideSize) {
        this.sideSize = sideSize;
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
