package hexlet.courses;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class AppTest {

    @Test
    void testGetSquare1() {
        var actual = App.getSquare(10, 10, 60);
        assertThat(actual).isCloseTo(43.3, within(0.05));
    }

    @Test
    void testGetSquare2() {
        var actual = App.getSquare(4, 5, 45);
        assertThat(actual).isCloseTo(7.07, within(0.05));
    }

    @Test
    void testGetSquare3() {
        var actual = App.getSquare(4, 5, 0);
        assertThat(actual).isEqualTo(0);
    }
}