package ru.geekbrains.java.javatwo.lesson_5;

/*
1. Необходимо написать два метода, которые делают следующее:
1) Создают одномерный длинный массив, например:

static final int size = 10000000;
static final int h = size / 2;
float[] arr = new float[size];

2) Заполняют этот массив единицами;
3) Засекают время выполнения: long a = System.currentTimeMillis();
4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
5) Проверяется время окончания метода System.currentTimeMillis();
6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);

Отличие первого метода от второго:
Первый просто бежит по массиву и вычисляет значения.
Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы
обратно в один.

Пример деления одного массива на два:

System.arraycopy(arr, 0, a1, 0, h);
System.arraycopy(arr, h, a2, 0, h);

Пример обратной склейки:

System.arraycopy(a1, 0, arr, 0, h);
System.arraycopy(a2, 0, arr, h, h);

Примечание:
System.arraycopy() – копирует данные из одного массива в другой:
System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда
начинаем записывать данные в массив-назначение, сколько ячеек копируем)
По замерам времени:
Для первого метода надо считать время только на цикл расчета:

for (int i = 0; i < size; i++) {
arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
}

Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
 */

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        methodOne();

        methodTwo();
    }

    public static void methodOne() {
        int[] array = new int[10_000_000];

        Arrays.fill(array, 1);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Method one total execution time:" + (endTime - startTime) + " ms.");
    }

    public static void methodTwo() {
        int[] array = new int[10_000_000];

        long startTime = System.currentTimeMillis();

        int[] arrayPartOne = new int[5_000_000];
        int[] arrayPartTwo = new int[5_000_000];

        System.arraycopy(array, 0, arrayPartOne, 0, arrayPartOne.length);
        System.arraycopy(array, arrayPartOne.length, arrayPartTwo, 0, arrayPartTwo.length);

        Thread threadOne = new Thread(() -> {
            Arrays.fill(arrayPartOne, 1);

            for (int i = 0; i < arrayPartOne.length; i++) {
                arrayPartOne[i] =
                        (int) (arrayPartOne[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        threadOne.start();

        Thread threadTwo = new Thread(() -> {
            Arrays.fill(arrayPartTwo, 1);

            for (int i = 0; i < arrayPartTwo.length; i++) {
                arrayPartTwo[i] =
                        (int) (arrayPartTwo[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        threadTwo.start();

        System.arraycopy(arrayPartOne, 0, array, 0,  arrayPartOne.length);
        System.arraycopy(arrayPartTwo, 0, array, arrayPartOne.length, arrayPartTwo.length );

        long endTime = System.currentTimeMillis();

        System.out.println("Method two total execution time:" + (endTime - startTime) + " ms.");

    }
}
