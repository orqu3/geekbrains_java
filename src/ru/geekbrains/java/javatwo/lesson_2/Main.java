package ru.geekbrains.java.javatwo.lesson_2;

/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого
размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то
элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть
брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
MyArrayDataException, и вывести результат расчета.
 */

public class Main {

    private static final int ARRAY_SIZE = 4;

    public static void main(String[] args) {

        String[][] firstArrayForCheck = new String[][]{
                {"5", "0", "7", "1"},
                {"3", "1", "1", "0"},
                {"9", "2", "5", "6"},
                {"0", "7", "8", "3"},
        };

        String[][] secondArrayForCheck = new String[][]{
                {"0", "7", "1"},
                {"3", "1", "1"},
                {"9", "2", "5"},
                {"0", "7", "8"},
        };

        String[][] thirdArrayForCheck = new String[][]{
                {"5", "O", "7", "1"},
                {"3", "1", "I", "0"},
                {"9", "2", "5", "6"},
                {"0", "7", "8", "3"},
        };

        catchArrayExceptions(firstArrayForCheck);
        catchArrayExceptions(secondArrayForCheck);
        catchArrayExceptions(thirdArrayForCheck);
    }

    public static void catchArrayExceptions(String[][] array) {
        try {
            System.out.println("Sum of array elements = " + sumArrayElements(array));
        } catch (MyArraySizeException e) {
            System.err.println("Incorrect array size! " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Array contains invalid data! " + e.getMessage());
        }
    }

    public static int sumArrayElements(String[][] array) throws MyArrayDataException, MyArraySizeException {

        checkArraySize(array);

        int sum = 0;

        for (String[] row : array) {
            for (String value : row) {
                try {
                    sum += Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException();
                }
            }
        }

        return sum;
    }

    public static void checkArraySize(String[][] array) {
        if (array.length != ARRAY_SIZE) {
            throw new MyArraySizeException();
        }

        for (String[] row : array) {
            if (row.length != ARRAY_SIZE) {
                throw new MyArraySizeException();
            }
        }
    }
}
