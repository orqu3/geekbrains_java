package ru.geekbrains.java.javaone;

/*
2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
"carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
 "pear", "pepper", "pineapple", "pumpkin", "potato"};
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер
показывает буквы которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно, можно пользоваться:
String str = "apple";
str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово
Используем только маленькие буквы
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static String[] words = new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
            "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {

        playGameGuessTheWord();

    }

    public static String getRandomWord() {
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }

    public static int getMinLength(String randomWord, String inputWord) {
        return Math.min(randomWord.length(), inputWord.length());
    }

    public static void playGameGuessTheWord() {
        System.out.println("Guess the word from list: " + Arrays.toString(words));
        String randomWord = getRandomWord();
        String inputWord = null;
        char[] equalChars = new char[randomWord.length()];

        while (!randomWord.equals(inputWord)) {
            inputWord = scanner.nextLine().toLowerCase();

            if (randomWord.equals(inputWord)) {
                System.out.println("You win!");
                break;
            }

            int minLength = getMinLength(randomWord, inputWord);
            int notEqualIndex = 0;

            for (int i = 0; i < minLength; i++) {
                if (inputWord.charAt(i) == randomWord.charAt(i)) {
                    equalChars[i] = inputWord.charAt(i);
                } else {
                    notEqualIndex = i;
                    break;
                }
            }
            char[] maskedAnswer = new char[notEqualIndex + 15];

            for (int i = 0; i < notEqualIndex; i++) {
                maskedAnswer[i] = equalChars[i];
            }
            for (int i = notEqualIndex; i < maskedAnswer.length; i++) {
                maskedAnswer[i] = '#';
            }

            System.out.println("You didn't guess!" + Arrays.toString(maskedAnswer));
        }

    }
}
