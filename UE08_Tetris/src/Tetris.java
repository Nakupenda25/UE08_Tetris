public class Tetris {

    public static String[][] rowsToColumns(String[][] rotArr1) {
        int length = rotArr1.length;

        //goes through each row and turns it into a column and vice versa
        for (int row = 0; row < length; row++) {
            for (int column = row; column < length; column++) {

                //uses the String newRow to save the value of rotArr at a specific spot
                String newRow = rotArr1[row][column];
                //swaps the position of row/column with column/row to use in further steps
                rotArr1[row][column] = rotArr1[column][row];
                rotArr1[column][row] = newRow;
            }
        }
        return rotArr1;
    }

    public static String[][] reverseArray(String[][] rotArr) {
        int length = rotArr.length;

        //goes through each row and the first two columns
        for (int row = 0; row < length; row++) {
            for (int column = 0; column < length / 2; column++) {

                //uses the temporary String reverse to reverse the columns. the string at a given position gets replaced by its mirror, and then the mirror gets replaced with the String reverse.
                String reverse = rotArr[row][column];
                //length - 1 - column gives us the mirrored position of the current column
                rotArr[row][column] = rotArr[row][length - 1 - column];
                rotArr[row][length - 1 - column] = reverse;
            }
        }
        return rotArr;
    }

    public static String[][] rotateArray(String[][] rotArr) {
        rotArr = rowsToColumns(rotArr);
        rotArr = reverseArray(rotArr);
        return rotArr;
    }

    public static void printArrays(String[][][] mainArray){

        //variables for tracking both the column and the array that is currently printed
        int formatCounter = 0;
        int arrayCounter = 0;

        //for loop that saves the current row being printed in the variable r
        for (int r = 0; r <= 3; r++) {
            //for loop that goes through all 4 arrays // after each array has been printed, arrayCounter gets incremented if it is not the last array (3)
            for (String[][] arrays : mainArray) {
                //uses the variable r and c to go through each column per given row, printing 2 spaces after every row per array. If the current array is number 3 (the last one) no spaces are printed at the end
                for (int c = 0; c <= 3; c++) {
                    if (formatCounter != 3) {
                        System.out.print(arrays[r][c] + " ");
                        formatCounter++;
                    } else if (formatCounter == 3 && arrayCounter != 3) {
                        System.out.print(arrays[r][c] + "  ");
                        formatCounter = 0;
                    } else {
                        System.out.print(arrays[r][c]);
                        formatCounter = 0;
                    }
                }
                //increments arrayCounter so the program can print the correct amount of spaces/sets it to zero after the 4th one has been printed so the next loop runs correctly
                if (arrayCounter != 3)
                    arrayCounter++;
                else
                    arrayCounter = 0;
            }
            System.out.println();
        }

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
                {"-", "-", "-", "-"}};

        String[][] rotArr3 = {
                {"-", "-", "-", "-"},
                {"-", "o", "-", "-"},
                {"-", "o", "-", "-"},
                {"-", "o", "o", "-"}};
        String[][] rotArr4 = {
                {"-", "-", "o", "-"},
                {"-", "-", "o", "-"},
                {"-", "-", "o", "-"},
                {"-", "-", "o", "-"}};

        String[][][] mainArray = {rotArr1, rotArr2, rotArr3, rotArr4};

        for (int counter = 0; counter < 4; counter++) {

            printArrays(mainArray);
            //rotates all the arrays once
            rotArr1 = rotateArray(rotArr1);
            rotArr2 = rotateArray(rotArr2);
            rotArr3 = rotateArray(rotArr3);
            rotArr4 = rotateArray(rotArr4);
            System.out.println();
        }

    }
}

