package geekbrains.lesson2_2_homework;

public class Main {

    public static void main(String[] args) {

        String[][] numbers = {
                {"4", "4",  "8","7"},
                {"3", "x", "4", "0"},
                {"4", "2", "4", "4"},
                {"5", "2", "5","8"}
        };

        checkSize(numbers);

        try {
            System.out.println(calc(numbers));
        } catch (MyArrayDataException ex) {
            ex.printStackTrace();
        }
    }

    static int calc(String[][] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                try {
                    sum += Integer.parseInt(numbers[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException("в ячейке [" + i + "],[" + j + "] находится тип отличный от int.", ex);
                }
            }

        }
        return sum;
    }



        static void checkSize(String[][] values) {
            if (values.length != 4) {
                throw new MyArraySizeException(String.format("Строк в массиве %s ,вместо положенныех 4", values.length));
            }

            for (int i = 0; i < values.length; i++) {
                if (values[i].length != 4) {
                    throw new MyArraySizeException(String.format("Массив [%s] сожержит %s элемента вместо 4", i, values[i].length));
                }
            }
        }
    }
