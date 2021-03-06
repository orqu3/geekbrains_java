package ru.geekbrains.java.javaone;

import java.util.Arrays;

public class Lesson_2 {

    // 1.Задать целочисленный массив,состоящий из элементов 0и 1.Например:[1,1,0,0,1,0,1,1,0,0].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void fillAndReplaceArrayZeroAndOne() {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int) (Math.random() * 2));
        }
        System.out.println("Array elements = " + Arrays.toString(array));
        for (int x = 0; x < array.length; x++) {
            if (array[x] == 0)
                array[x] = 1;
            else
                array[x] = 0;
        }
        System.out.println("Replaced array elements = " + Arrays.toString(array));
    }

    //2.Задать пустой целочисленный массив размером 8.С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void fillArray() {
        int[] array = new int[8];
        int number = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = number;
            number += 3;
        }
        System.out.println(Arrays.toString(array));
    }

    //3.Задать массив[1,5,3,2,11,4,5,2,4,8,9,1]пройти по нему циклом,и числа меньшие 6умножить на 2;
    public static void changeArray() {
        int[] array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Array elements: " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] *= 2;
        }
        System.out.println("Changed array elements: " + Arrays.toString(array));
    }

    //    4.Создать квадратный двумерный целочисленный массив(количество строк и столбцов одинаковое),
    //        и с помощью цикла(-ов)заполнить его диагональные элементы единицами;
    public static void fillArrayDiagonal() {
        int[][] array = new int[5][5];
        int i, j;
        for (i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][array.length - i - 1] = 1;
        }
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array.length; j++)
                System.out.print(array[i][j] + "  ");
            System.out.println();
        }
    }

    // 5.**Задать одномерный массив и найти в нем минимальный и максимальный элементы(без помощи интернета);
    public static void findMaxAndMinArrayElementValue() {
        int[] array = new int[]{12, 1, 56, 78, 3, 456};
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        System.out.println("Array elements = " + Arrays.toString(array));
        System.out.println("Min element of array = " + min);
        System.out.println("Max element of array = " + max);
    }

    // 6.**Написать метод,в который передается не пустой одномерный целочисленный массив,метод должен вернуть true,
    // если в массиве есть место,в котором сумма левой и правой части массива равны.Примеры:checkBalance([2,2,2,1,2,
    // 2,||10,1]) → true,checkBalance([1,1,1,||2,1]) → true,граница показана символами||,эти символы в массив не входят.
    public static boolean checkBalance(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            int rightSum = 0;
            int leftSum = 0;
            for (int j = i; j < array.length; j++) {
                rightSum += array[j];
            }
            for (int j = 0; j < i; j++) {
                leftSum += array[j];
            }
            if (rightSum == leftSum)
                return true;
        }
        return false;
    }
}
