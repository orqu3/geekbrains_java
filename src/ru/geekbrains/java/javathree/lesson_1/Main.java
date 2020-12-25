package ru.geekbrains.java.javathree.lesson_1;

/*
1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        testArrayToArrayListMethod();

        testSwapArrayElementsMethod();

    }

    private static void testSwapArrayElementsMethod() {
        String[] strArray = {"zero", "one", "five"};
        System.out.println("String array before swap: " + Arrays.toString(strArray));
        swapArrayElements(strArray, 0, 2);
        System.out.println("String array after swap: " + Arrays.toString(strArray));

        Integer[] intArray = {234, 7, 0};
        System.out.println("Int array before swap: " + Arrays.toString(strArray));
        swapArrayElements(intArray, 0, 1);
        System.out.println("Int array after swap: " + Arrays.toString(intArray));
    }

    private static void testArrayToArrayListMethod() {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"one", "two", "three", "four", "five"};
        arrayToArrayList(intArray);
        arrayToArrayList(stringArray);
        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(stringArray));
    }

    public static void swapArrayElements(Object[] array, int i, int j) {
        if (i < 0 || i > array.length || j < 0 || j > array.length) {
            System.err.println("Incorrect value of index!");
        }
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T> ArrayList arrayToArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
