package hexlet.courses.lesson7.exercises.n3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SquareGeneratorTest {
    @Test
    void testSquareGenerator() {
        var result = SquareGenerator.generate(20);
        assertThat(result).isInstanceOf(Square.class);
        assertThat(result.getSide()).isEqualTo(5);

        var result2 = SquareGenerator.generate(100);
        assertThat(result2).isInstanceOf(Square.class);
        assertThat(result2.getSide()).isEqualTo(25);
    }
}
