package ru.geekbrains.java.javathree.lesson_7;

public class MyTest {

    @BeforeSuite
    public static void test1() {
        System.out.println("test1, BeforeSuite");
    }

    @Test(priority = 3)
    public static void test2() {
        System.out.println("test2, priority = 3");
    }

    @Test(priority = 10)
    public static void test3() {
        System.out.println("test3, priority = 10");
    }

    @Test
    public static void test4() {
        System.out.println("test4, default priority = 5");
    }

    @AfterSuite
    public static void test5() {
        System.out.println("test5, AfterSuite");
    }
}
