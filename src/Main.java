public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "S"}
        };

        try {
            processArray(array);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    public static void processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Array size is not 4x4");
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException("Invalid data at cell [" + i + "][" + j + "]");
                }
            }
        }

        System.out.println("Sum of array elements: " + sum);
    }
}