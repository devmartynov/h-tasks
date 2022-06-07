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

    public static int calcShipsCount(int[][] field) {
        if (ArrayUtils.isEmpty(field)) {
            return 0;
        }

        var deck = 1;

        var shipsCount = 0;

        var rowsCount = field.length;
        var colsCount = field[0].length;

        for (var i = 0; i < rowsCount; i++) {
            for (var j = 0; j < colsCount; j++) {
                if (field[i][j] == deck) { // it's a deck!
                    var needToGrowShipsCount = true;
                    var prevDeckPosition = findPrevDeckPosition(i, j, field);

                    if (!ArrayUtils.isEmpty(prevDeckPosition)) { // Oop! Found prev deck around here
                        needToGrowShipsCount = false;
                    }

                    if (needToGrowShipsCount) {
                        shipsCount++;
                    }
                }
            }
        }

        return shipsCount;
    }

    public static int[] findPrevDeckPosition(int rowPos, int colPos, int[][] field) {
        var prevRowPos = rowPos - 1;
        var prevColPos = colPos - 1;

        var isPrevRowExisted = prevRowPos >= 0;
        var isPrevColExisted = prevColPos >= 0;

        if (isPrevRowExisted && field[prevRowPos][colPos] == 1) {
            //  o 1 o
            //  o 1 o
            //  o c o
            return new int[]{prevRowPos, colPos};
        }

        if (isPrevColExisted && field[rowPos][prevColPos] == 1) {
            //  o o o
            //  1 1 o
            //  o c o
            return new int[]{rowPos, prevColPos};
        }

        return new int[0];
    }

    public static boolean isValidField(int[][] field) {
        if (field.length == 0) {
            return true;
        }

        var isValid = true;
        var rowsCount = field.length;
        var colsCount = field[0].length;

        for (var i = 0; i < rowsCount; i++) {
            if (!isValid) {
                break;
            }

            int[] row = field[i];

            var prevRowIndex = i - 1;
            var nextRowIndex = i + 1;

            var isPrevRowExisted = prevRowIndex >= 0;
            var isNextRowExisted = nextRowIndex < rowsCount;

            for (var j = 0; j < colsCount; j++) {
                var col = row[j];

                if (col != 1) {
                    continue;
                }

                var prevColIndex = j - 1;
                var nextColIndex = j + 1;

                var isPrevColExisted = prevColIndex >= 0;
                var isNextColExisted = nextColIndex < colsCount;

                if (isPrevRowExisted) {
                    int[] prevRow = field[prevRowIndex];

                    if (isPrevColExisted && prevRow[prevColIndex] == 1) {
                        isValid = false;
                        break;
                    }
                    if (isNextColExisted && prevRow[nextColIndex] == 1) {
                        isValid = false;
                        break;
                    }
                }

                if (isNextRowExisted) {
                    int[] nextRow = field[nextRowIndex];

                    if (isPrevColExisted && nextRow[prevColIndex] == 1) {
                        isValid = false;
                        break;
                    }
                    if (isNextColExisted && nextRow[nextColIndex] == 1) {
                        isValid = false;
                        break;
                    }
                }
            }
        }

        return isValid;
    }
}
