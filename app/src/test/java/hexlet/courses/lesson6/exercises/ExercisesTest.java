package hexlet.courses.lesson6.exercises;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ExercisesTest {
    @Test
    public void testBuildSnailPath1() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        int[] expected = {1, 2, 4, 3};
        var actual = Exercises.buildSnailPath(matrix);
        assertThat(actual).containsExactly(expected);
    }

    @Test
    public void testBuildSnailPath2() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int[] expected = {1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};
        var actual = Exercises.buildSnailPath(matrix);
        assertThat(actual).containsExactly(expected);
    }

    @Test
    public void testBuildSnailPath3() {
        int[][] matrix = {};
        int[] expected = {};
        var actual = Exercises.buildSnailPath(matrix);
        assertThat(actual).containsExactly(expected);
    }

    @Test
    public void testBuildSnailPath4() {
        int[][] matrix = {{1, 2, 3, 4}};
        int[] expected = {1, 2, 3, 4};
        var actual = Exercises.buildSnailPath(matrix);
        assertThat(actual).containsExactly(expected);
    }

    @Test
    public void testBuildSnailPath5() {
        int[][] matrix = {{1}, {2}, {3}, {4}};
        int[] expected = {1, 2, 3, 4};
        var actual = Exercises.buildSnailPath(matrix);
        assertThat(actual).containsExactly(expected);
    }

    @Test
    public void testBuildSnailPath6() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int[] expected = {1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};
        var actual = Exercises.buildSnailPath(matrix);
        assertThat(actual).containsExactly(expected);
    }
}
