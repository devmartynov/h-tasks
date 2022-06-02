package hexlet.courses.lesson7.exercises.n4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RationalTest {

    @Test
    void testGcd() {
        var actual1 = Rational.gcd(2, 3);
        var actual2 = Rational.gcd(10, 25);
        var actual3 = Rational.gcd(-4, 16);
        assertThat(actual1).isEqualTo(1);
        assertThat(actual2).isEqualTo(5);
        assertThat(actual3).isEqualTo(4);
    }

    @Test
    void testRational() {
        var rat1 = new Rational(3, 9);
        assertThat(rat1.getNumer()).isEqualTo(1);
        assertThat(rat1.getDenom()).isEqualTo(3);
        assertThat(rat1.toString()).isEqualTo("1/3");

        var rat2 = new Rational(-4, 16);
        assertThat(rat2.getNumer()).isEqualTo(-1);
        assertThat(rat2.getDenom()).isEqualTo(4);
        assertThat(rat2.toString()).isEqualTo("-1/4");
    }

    @Test
    void testSub() {
        var rat1 = new Rational(3, 9);
        var rat2 = new Rational(10, 3);
        var actual1 = rat1.sub(rat2);
        assertThat(actual1.getNumer()).isEqualTo(-3);
        assertThat(actual1.getDenom()).isEqualTo(1);

        var rat3 = new Rational(-4, 16);
        var rat4 = new Rational(12, 5);
        var actual2 = rat3.sub(rat4);
        assertThat(actual2.getNumer()).isEqualTo(-53);
        assertThat(actual2.getDenom()).isEqualTo(20);

        assertThat(actual1).isInstanceOf(Rational.class);
        assertThat(actual1).isNotSameAs(rat1);
        assertThat(actual1).isNotSameAs(rat2);
    }

    @Test
    void testAdd() {
        var rat1 = new Rational(3, 9);
        var rat2 = new Rational(10, 3);
        var actual1 = rat1.add(rat2);
        assertThat(actual1.getNumer()).isEqualTo(11);
        assertThat(actual1.getDenom()).isEqualTo(3);

        var rat3 = new Rational(-4, 16);
        var rat4 = new Rational(12, 5);
        var actual2 = rat3.add(rat4);
        assertThat(actual2.getNumer()).isEqualTo(43);
        assertThat(actual2.getDenom()).isEqualTo(20);

        assertThat(actual1).isInstanceOf(Rational.class);
        assertThat(actual1).isNotSameAs(rat1);
        assertThat(actual1).isNotSameAs(rat2);
    }

}
