package hexlet.courses.lesson7.exercises.n2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomTest {
    @Test
    void testGetNext() {
        var random = new Random(100);
        var result1 = random.getNext();
        var result2 = random.getNext();
        assertThat(result1).isNotEqualTo(result2);

        var random2 = new Random(100);
        var result21 = random2.getNext();
        var result22 = random2.getNext();
        assertThat(result21).isNotEqualTo(result22);
        assertThat(result1).isEqualTo(result21);
        assertThat(result2).isEqualTo(result22);
    }

    @Test
    void testReset() {
        var random = new Random(50);

        var result1 = random.getNext();
        var result2 = random.getNext();
        assertThat(result1).isNotEqualTo(result2);

        random.reset();

        var result21 = random.getNext();
        var result22 = random.getNext();
        assertThat(result1).isEqualTo(result21);
        assertThat(result2).isEqualTo(result22);
    }
}
