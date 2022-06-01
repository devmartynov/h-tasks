package hexlet.courses.lesson7.exercises.n1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.within;

public class CircleTest {
    @Test
    void testGetArea() {
        var circle1 = new Circle(1);
        var actual1 = circle1.getArea();
        assertThat(actual1).isCloseTo(3.14, within(0.1));

        var circle2 = new Circle(3);
        var actual2 = circle2.getArea();
        assertThat(actual2).isCloseTo(28.2, within(0.1));
    }

    @Test
    void testGetCircumference() {
        var circle1 = new Circle(1);
        var actual1 = circle1.getCircumference();
        assertThat(actual1).isCloseTo(6.2, within(0.1));

        var circle2 = new Circle(3);
        var actual2 = circle2.getCircumference();
        assertThat(actual2).isCloseTo(18.8, within(0.1));
    }
}
