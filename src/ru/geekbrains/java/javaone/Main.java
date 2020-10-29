package ru.geekbrains.java.javaone;

public class Main {

    public static void main(String[] args) {
        checkLesson1();
    }

    public static void checkLesson1() {
        byte a = -128;
        short b = 32767;
        int c = -2147483648;
        long d = 9223372036854775807L;
        double e = 1.7976931348623157E308;
        float f = 1.6666666F;
        char g = '\u0044';
        boolean h = true;
        String i = "This is string";

        System.out.println(Lesson_1.calculation(5, 1, 20, 5));
        System.out.println(Lesson_1.isSumInRangeBetween10and20(11, 8));
        Lesson_1.printPositiveOrNegative(0);
        System.out.println(Lesson_1.isNegative(-67));
        Lesson_1.hello("Алёна");
        System.out.println(Lesson_1.isLeapYear(2020));
    }
}
