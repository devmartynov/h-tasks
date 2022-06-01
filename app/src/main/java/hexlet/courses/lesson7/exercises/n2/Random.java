package hexlet.courses.lesson7.exercises.n2;

public class Random implements Generator {
    private int seed;
    private final int init;

    Random(int seed) {
        this.seed = seed;
        this.init = seed;
    }

    @Override
    public int getNext() {
        var a = 45 + init;
        var c = 21 + init;
        var m = 67 + init;

        seed = (a * seed + c) % m;

        return seed;
    }

    @Override
    public void reset() {
        seed = init;
    }
}
