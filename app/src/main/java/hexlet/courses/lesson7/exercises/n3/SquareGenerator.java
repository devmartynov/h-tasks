package hexlet.courses.lesson7.exercises.n3;

public class SquareGenerator {
    public static Square generate(double perimeter) {
        var side = perimeter / 4;

        return new Square(side);
    }
}
