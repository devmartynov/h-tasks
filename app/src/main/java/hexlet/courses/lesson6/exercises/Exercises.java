package hexlet.courses.lesson6.exercises;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class Exercises {

    public static int[][] rotateLeft(int[][] matrix) {
        var rowsCount = matrix.length;
        var columnsCount = matrix[0].length;
        var rotatedMatrix = new int[columnsCount][rowsCount];

        for (var row = 0; row < columnsCount; row++) {

            rotatedMatrix[row] = new int[rowsCount];

            for (var coll = 0; coll < rowsCount; coll++) {
                rotatedMatrix[row][coll] =  matrix[coll][columnsCount - row - 1];
            }
        }

        return rotatedMatrix;
    }

    public static int[] getNumbersFromArray(int[][] array, int deep, int rotateCount) {
        var arrayToCopy = array[deep];
        var copyTo = array.length == 1 ? arrayToCopy.length : arrayToCopy.length - 1;

        int[] result = Arrays.copyOfRange(arrayToCopy, 0, copyTo);

        var nextDeep = rotateCount > 0 && rotateCount % 4 == 0 ? deep + 1 : deep;

        if (nextDeep >= array.length / 2) {
            return array.length > 2 ? Arrays.copyOfRange(result, 1, result.length) : result;
        }

        var nextRotateCount = rotateCount + 1;
        int[][] rotatedArray = rotateLeft(array);
        var nextNumbers = getNumbersFromArray(rotatedArray, nextDeep, nextRotateCount);
        var resultArray = ArrayUtils.addAll(result, nextNumbers);

        return resultArray;
    }

    public static int[] buildSnailPath(int[][] array) {
        if (array.length == 0) {
            return new int[0];
        }

        return getNumbersFromArray(array, 0, 1);
    }
}
