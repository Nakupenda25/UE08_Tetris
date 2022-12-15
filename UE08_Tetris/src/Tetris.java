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

        rotArr1 = rotateArray(rotArr1);
        rotArr2 = rotateArray(rotArr2);
        rotArr3 = rotateArray(rotArr3);
        rotArr4 = rotateArray(rotArr4);

    }
}

