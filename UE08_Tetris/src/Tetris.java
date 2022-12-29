/*
 * Tetris
 * Turns 4 fixed array matrixes clockwise and prints them out after each rotation
 * Author: Benedikt Schmatz
 * Last Change: 29.12.22
 */

public class Tetris {

    public static String[][] rowsToColumns(String[][] rotArr1){
        int length = rotArr1.length;

        //goes through each row and turns it into a column and vice versa
        for (int row = 0; row < length; row++){
            for (int column = row; column < length; column++){

                //uses the String newRow to save the value of rotArr at a specific spot
                String newRow = rotArr1[row][column];
                //swaps the position of row/column with column/row to use in further steps
                rotArr1 [row][column] = rotArr1 [column][row];
                rotArr1 [column][row] = newRow;
            }
        }
        return rotArr1;
    }

    public static String[][] reverseArray(String[][] rotArr){
        int length = rotArr.length;

        for (int row = 0; row < length; row++){
            for (int column = 0; column < length / 2; column++){

                String reverse = rotArr[row][column];
                rotArr [row][column] = rotArr [row][length - 1 - column];
                rotArr [row][length - 1 - column] = reverse;
            }
        }
        return rotArr;
    }

    public static String[][] rotateArray(String[][] rotArr){
        rotArr = rowsToColumns(rotArr);
        rotArr = reverseArray(rotArr);
        return rotArr;
    }

    public static void main(String[] args) {
        String[][] rotArr1 = {
                {"-", "-", "-", "-"},
                {"-", "o", "-", "-"},
                {"o", "o", "o", "-"},
                {"-", "-", "-", "-"}};

        String[][] rotArr2 = {
                {"-", "-", "-", "-"},
                {"-", "o", "o", "-"},
                {"o", "o", "-", "-"},
                {"-", "-", "-" ,"-"}};

        String[][] rotArr3 = {
                {"-", "-", "-", "-"},
                {"-", "o", "-", "-"},
                {"-", "o", "-", "-"},
                {"-", "o", "o" ,"-"}};
        String[][] rotArr4 = {
                {"-", "-", "o", "-"},
                {"-", "-", "o", "-"},
                {"-", "-", "o", "-"},
                {"-", "-", "o" ,"-"}};

        String[][][] mainArray = {rotArr1, rotArr2, rotArr3, rotArr4};

        int formatCounter = 0;

        for (int counter = 0; counter <= mainArray.length; counter++) {
            for (int r = 0; r < rotArr1.length; r++) {
                for (String[][] arrays : mainArray) {
                    for (int c = 0; c < rotArr1[1].length; c++) {
                        if (formatCounter != 3) {
                            System.out.print(arrays[r][c] + " ");
                            formatCounter++;
                        } else {
                            System.out.print(arrays[r][c] + "  ");
                            formatCounter = 0;
                        }
                    }
                }
                System.out.println();
            }
            rotArr1 = rotateArray(rotArr1);
            rotArr2 = rotateArray(rotArr2);
            rotArr3 = rotateArray(rotArr3);
            rotArr4 = rotateArray(rotArr4);
            System.out.println();
        }
    }
}

