package ru.geekbrains.java.javaone;

/*
1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4. Очень
желательно не делать это просто набором условий для каждой из возможных ситуаций;
4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
 */

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static final int SIZE = 5;
    public static final int LINE_LIMIT = 15;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static char[][] map;
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        playTicTacToeGame();
        scanner.close();
    }

    private static void playTicTacToeGame() {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();

            if (checkWin(DOT_X)) {
                System.out.println("You WIN!");
                break;
            }
            if (mapIsFull()) {
                System.out.println("DRAW...");
                break;
            }
            aiTurn();
            printMap();

            if (checkWin(DOT_O)) {
                System.out.println("AI WIN!");
                break;
            }

            if (mapIsFull()) {
                System.out.println("DRAW...");
                break;
            }
        }
        System.out.println("GAME OVER");
    }

    private static boolean mapIsFull() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (map[y][x] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    private static boolean checkRowFilled(char symbol) {
        boolean isRowFilled = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                isRowFilled = map[i][j] == symbol;
                if (!isRowFilled) {
                    break;
                }
            }
            if (isRowFilled) {
                break;
            }
        }
        return isRowFilled;
    }

    private static boolean checkColumnFilled(char symbol) {
        boolean isColumnFilled = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                isColumnFilled = map[j][i] == symbol;
                if (!isColumnFilled) {
                    break;
                }
            }
            if (isColumnFilled) {
                break;
            }
        }
        return isColumnFilled;
    }

    private static boolean checkLeftToRightDiagonalFilled(char symbol) {
        boolean isLeftToRightDiagonalFilled = false;
        for (int i = 0; i < SIZE; i++) {
            isLeftToRightDiagonalFilled = map[i][i] == symbol;
            if (!isLeftToRightDiagonalFilled) {
                break;
            }
        }
        return isLeftToRightDiagonalFilled;
    }

    private static boolean checkRightToLeftDiagonalFilled(char symbol) {
        boolean isRightToLeftDiagonalFilled = false;
        for (int i = 0; i < SIZE; i++) {
            isRightToLeftDiagonalFilled = map[i][SIZE - 1 - i] == symbol;
            if (!isRightToLeftDiagonalFilled) {
                break;
            }
        }

        return isRightToLeftDiagonalFilled;
    }


    private static boolean checkWin(char symbol) {
        return checkRowFilled(symbol) ||
                checkColumnFilled(symbol) ||
                checkLeftToRightDiagonalFilled(symbol) ||
                checkRightToLeftDiagonalFilled(symbol);
    }

    private static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
    }

    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Please, enter coordinates in X Y format [1.." + SIZE + "]");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE) return false;
        if (y < 0 || y >= SIZE) return false;
        if (map[y][x] != DOT_EMPTY) return false;
        return true;
    }

    private static void printMap() {
        for (int i = 0; i < LINE_LIMIT; i++) {
            System.out.println();
        }

        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int y = 0; y < SIZE; y++) {
            System.out.print((y + 1) + " ");
            for (int x = 0; x < SIZE; x++) {
                System.out.print(map[y][x] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
}
