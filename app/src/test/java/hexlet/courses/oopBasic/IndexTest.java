package hexlet.courses.oopBasic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.within;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IndexTest {
    @Test
    void testGetSquare1() {
        var actual = Index.getSquare(10, 10, 60);
        assertThat(actual).isCloseTo(43.3, within(0.05));
    }

    @Test
    void testGetSquare2() {
        var actual = Index.getSquare(4, 5, 45);
        assertThat(actual).isCloseTo(7.07, within(0.05));
    }

    @Test
    void testGetSquare3() {
        var actual = Index.getSquare(4, 5, 0);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void testSymmetricalPoint1() {
        var point = new Point(5, 7);
        var symmetricalPoint = Index.getSymmetricalPoint(point);
        assertThat(symmetricalPoint.getCoordinateX()).isEqualTo(5);
        assertThat(symmetricalPoint.getCoordinateY()).isEqualTo(-7);
    }

    @Test
    void testSymmetricalPoint2() {
        var point = new Point(-3, -9);
        var symmetricalPoint = Index.getSymmetricalPoint(point);
        assertThat(symmetricalPoint.getCoordinateX()).isEqualTo(-3);
        assertThat(symmetricalPoint.getCoordinateY()).isEqualTo(9);
    }

    @Test
    void testIsNotSamePoint() {
        var point = new Point(1, 2);
        var symmetricalPoint = Index.getSymmetricalPoint(point);
        assertThat(symmetricalPoint).isNotSameAs(point);
    }

    @Test
    void testCircle1() {
        var circle = new Circle(1, 2, 5);
        var actual = Index.getCircumference(circle);
        assertThat(actual).isCloseTo(31.4, within(0.05));
    }

    @Test
    void testCircle2() {
        var circle = new Circle(1, 2, 10);
        var actual = Index.getCircumference(circle);
        assertThat(actual).isCloseTo(62.8, within(0.05));
    }

    @Test
    void testCircle3() {
        var circle = new Circle(1, 2, 0);
        var actual = Index.getCircumference(circle);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void testIsPalindrome() {
        assertThat(Index.isPalindrome("wow")).isTrue();
        assertThat(Index.isPalindrome("hexlet")).isFalse();
        assertThat(Index.isPalindrome("asdffdsa")).isTrue();
    }

    @Test
    void testIsPalindromeWithUppercase() {
        assertThat(Index.isPalindrome("Wow")).isTrue();
        assertThat(Index.isPalindrome("ABCcba")).isTrue();
    }

    @Test
    void testGetFigureSquare1() {
        var quadrate = new Quadrate(10);
        var actual = Index.getFigureSquare(quadrate);
        var expected = "Square of quadrate is 100";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testGetFigureSquare2() {
        var quadrate = new Quadrate(5);
        var actual = Index.getFigureSquare(quadrate);
        var expected = "Square of quadrate is 25";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testGetFigureSquare3() {
        var circle = new Circle(10);
        var actual = Index.getFigureSquare(circle);
        var expected = "Square of circle is 314";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testEnlarge1() {
        var quadrate = new Quadrate(5);
        var actual = Index.enlargeQuadrate(quadrate);

        assertThat(actual.getSideSize()).isEqualTo(10);
        assertThat(actual).isNotSameAs(quadrate);
    }

    @Test
    void testEnlarge2() {
        var quadrate = new Quadrate(10);
        var actual = Index.enlargeQuadrate(quadrate);
        assertThat(actual.getSideSize()).isEqualTo(20);
    }
}
