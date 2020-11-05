package ru.geekbrains.java.javaone;

/*
1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 */

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        do {
            playGameGuessTheNumber();
            System.out.println("Repeat game? (1 - yes, 0 - no)");
        } while (scanner.nextInt() == 1);

        scanner.close();
    }

    public static void playGameGuessTheNumber() {
        System.out.println("Guess the number from 0 to 9:");

        int count = 0;
        int input_number = -1;
        int number = random.nextInt(10);

        while (count < 3 && input_number != number) {

            if (scanner.hasNextInt()) {
                input_number = scanner.nextInt();

                if (number != input_number) {
                    System.out.println("Your number is " +
                            ((input_number > number) ? "greater" : "less"));
                    count++;
                }

            } else {
                System.out.println("This is not a number! Please, try again!");
                scanner.next();
            }
        }

        System.out.println("You " +
                ((input_number == number) ? "win!" : "lose... It was: " + number));
    }
}


