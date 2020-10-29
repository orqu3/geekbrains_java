package ru.geekbrains.java.javaone;

/*
1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры
 этого метода;
4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20
(включительно), если да – вернуть true, в противном случае – false;
5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль
положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число
отрицательное;
7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль
сообщение «Привет, указанное_имя!»;
8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год
является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
 */

public class Lesson_1 {
    public static int calculation(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    public static boolean isSumInRangeBetween10and20(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void printPositiveOrNegative(int a) {
        if (a >= 0) {
            System.out.println("The number is positive.");
        } else
            System.out.println("The number is  negative");
    }

    public static boolean isNegative(int a) {
        return a < 0;
    }

    public static void hello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            System.out.println(year + " год не входит в интервал допустимых значений!");
            return false;
        }

        if ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0)) {
            return true;
        }

        if (year % 4 != 0) {
            return false;
        }

        if (year % 100 != 0) {
            return true;
        }

        return false;
    }
}
