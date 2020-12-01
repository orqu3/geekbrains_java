package ru.geekbrains.java.javatwo.lesson_2;

public class MyArraySizeException extends IllegalArgumentException {

    public MyArraySizeException() {
        super("Required array size is 4x4!");
    }

}
