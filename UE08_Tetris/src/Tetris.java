public class Tetris {

    public static String[][] rowsToColums(String[][] rotArr){
        int length = rotArr.length;

        for (String[] number: rotArr) {
            for (String element: number) {
                System.out.print(" " + element + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        for (int row = 0; row < length; row++){
            for (int column = row; column < length; column++){

                String newRow = rotArr[row][column];
                rotArr [row][column] = rotArr [column][row];
                rotArr [column][row] = newRow;
            }
        }
        return rotArr;
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

        rotArr1 = rowsToColums(rotArr1);
        rotArr1 = reverseArray(rotArr1);

        for (String[] number: rotArr1) {
            for (String element: number) {
                System.out.print(" " + element + " ");
            }
            System.out.println();
        }
    }
}

