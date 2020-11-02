package ru.geekbrains.java.javaone;

public class Main {

    public static void main(String[] args) {
        checkLesson1();
        checkLesson2();
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

    public static void checkLesson2() {
        Lesson_2.fillAndReplaceArrayZeroAndOne();
        Lesson_2.fillArray();
        Lesson_2.changeArray();
        Lesson_2.fillArrayDiagonal();
        Lesson_2.findMaxAndMinArrayElementValue();
        int[] firstArrayForCheckBalance = new int[] {50,0,0,1,1,1};
        int[] secondArrayForCheckBalance = new int[] {2,2,0,3,0,1};
        System.out.println(Lesson_2.checkBalance(firstArrayForCheckBalance));
        System.out.println(Lesson_2.checkBalance(secondArrayForCheckBalance));
    }
}
