package hexlet.courses.lesson7.exercises.n3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SquareTest {
    @Test
    void testSquare() {
        var square = new Square(10);
        var side = square.getSide();
        assertThat(side).isEqualTo(10);
    }
}
