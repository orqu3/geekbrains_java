/*
1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе
необходимо выбросить RuntimeException.
Написать набор тестов для этого метода (по 3-4 варианта входных данных).
Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

2.Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
то метод вернет false; Если в нем есть число отличное от 1 и 4 то тоже вернуть false; Написать набор тестов для
этого метода (по 3-4 варианта входных данных).
[ 1 1 1 4 4 1 4 4 ] -> true
[ 1 1 1 1 1 1 ] -> false
[ 4 4 4 4 ] -> false
[ 1 4 4 1 1 4 3 ] -> false
 */

import org.apache.commons.lang3.ArrayUtils;

public class Main {

    public static int[] firstMethod(int[] array) {
        int[] newArray = null;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                newArray = new int[array.length - i - 1];
                for (int j = i + 1, k = 0; j < array.length; j++, k++) {
                    if (array[j] == 4) {
                        continue;
                    }
                    newArray[k] = array[j];
                }
            }

            if (!ArrayUtils.contains(array, 4)) {
                throw new RuntimeException();
            }
        }
        return newArray;
    }

    public static boolean secondMethod(int[] array) {
        boolean numbOne = false;
        boolean numbFour = false;
        for (int j : array) {
            if (j != 1 && j != 4)
                return false;
            if (j == 1)
                numbOne = true;
            if (j == 4)
                numbFour = true;
        }
        return (numbOne && numbFour);
    }
}


