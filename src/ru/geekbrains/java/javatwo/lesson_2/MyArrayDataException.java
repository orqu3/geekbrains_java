package ru.geekbrains.java.javatwo.lesson_2;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException() {
        super("It must be an integer!");
    }
}
