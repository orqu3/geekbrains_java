package ru.geekbrains.java.javatwo.lesson_2;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(String value, int i, int j) {
        super("Invalid value " + value + " in array cell " + "[" + i + "][" + j + "]! It must be integer!");
    }
}
