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

    @Test
    public void testCalcShipsCount() {
        int[][] battleField1 = {};
        assertThat(Exercises.calcShipsCount(battleField1)).isEqualTo(0);

        int[][] battleField2 = {{1}};
        assertThat(Exercises.calcShipsCount(battleField2)).isEqualTo(1);

        int[][] battleField3 = {{0}};
        assertThat(Exercises.calcShipsCount(battleField3)).isEqualTo(0);

        int[][] battleField4 = {
                {0, 0, 1},
                {0, 0, 0},
                {1, 1, 0},
        };
        assertThat(Exercises.calcShipsCount(battleField4)).isEqualTo(2);

        int[][] battleField5 = {
                {1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 1, 0, 0},
        };
        assertThat(Exercises.calcShipsCount(battleField5)).isEqualTo(6);

        int[][] battleField6 = {
                {1, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 1},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 1, 0, 0},
        };
        assertThat(Exercises.calcShipsCount(battleField6)).isEqualTo(8);

        int[][] battleField7 = {
                {1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
        };
        assertThat(Exercises.calcShipsCount(battleField7)).isEqualTo(3);

        int[][] battleField8 = {
                {1, 0, 1, 1},
                {1, 0, 0, 0},
                {0, 0, 1, 0},
                {1, 0, 1, 0},
        };
        assertThat(Exercises.calcShipsCount(battleField8)).isEqualTo(4);
    }

    @Test
    public void testValidateField() {
        int[][] battleField1 = {};
        assertThat(Exercises.isValidField(battleField1)).isTrue();

        int[][] battleField2 = {
                {0, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 1, 1, 1},
        };
        assertThat(Exercises.isValidField(battleField2)).isFalse();

        int[][] battleField3 = {
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 1},
        };
        assertThat(Exercises.isValidField(battleField3)).isTrue();

        int[][] battleField4 = {
                {1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 1, 0, 0},
        };
        assertThat(Exercises.isValidField(battleField4)).isTrue();

        int[][] battleField5 = {
                {1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 1},
                {0, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0},
        };
        assertThat(Exercises.isValidField(battleField5)).isFalse();
    }
}
