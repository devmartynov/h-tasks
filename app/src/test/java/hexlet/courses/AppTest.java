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

    @Test
    void testSymmetricalPoint1() {
        var point = new Point(5, 7);
        var symmetricalPoint = App.getSymmetricalPoint(point);
        assertThat(symmetricalPoint.getCoordinateX()).isEqualTo(5);
        assertThat(symmetricalPoint.getCoordinateY()).isEqualTo(-7);
    }

    @Test
    void testSymmetricalPoint2() {
        var point = new Point(-3, -9);
        var symmetricalPoint = App.getSymmetricalPoint(point);
        assertThat(symmetricalPoint.getCoordinateX()).isEqualTo(-3);
        assertThat(symmetricalPoint.getCoordinateY()).isEqualTo(9);
    }

    @Test
    void testIsNotSamePoint() {
        var point = new Point(1, 2);
        var symmetricalPoint = App.getSymmetricalPoint(point);
        assertThat(symmetricalPoint).isNotSameAs(point);
    }

    @Test
    void testCircle1() {
        var circle = new Circle(1, 2, 5);
        var actual = App.getCircumference(circle);
        assertThat(actual).isCloseTo(31.4, within(0.05));
    }

    @Test
    void testCircle2() {
        var circle = new Circle(1, 2, 10);
        var actual = App.getCircumference(circle);
        assertThat(actual).isCloseTo(62.8, within(0.05));
    }

    @Test
    void testCircle3() {
        var circle = new Circle(1, 2, 0);
        var actual = App.getCircumference(circle);
        assertThat(actual).isEqualTo(0);
    }
}