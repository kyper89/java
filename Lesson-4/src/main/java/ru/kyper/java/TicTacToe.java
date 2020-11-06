package ru.kyper.java;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    // Парметры игры
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final int LINE_LIMIT = 15;

    // Константы
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';

    // Игровое поле, работа с клавиатурой, случайные числа
    public static char[][] map;
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {

        initMap();
        printMap();

        while (true) {

            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Вы выиграли!");
                break;
            }
            if (mapIsFull()) {
                System.out.println("Ничья!!!");
                break;
            }

            aiTurn();
            printMap();
            if (checkWin(DOT_0)) {
                System.out.println("Вы проиграли!");
                break;
            }
            if (mapIsFull()) {
                System.out.println("Ничья!!!");
                break;
            }
        }

        System.out.println("Игра окончена");
        scanner.close();
    }

    private static boolean mapIsFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char symbol) {

        int matchingChar;

        // Проверим все горизонтали
        for (int y = 0; y < SIZE; y++) {
            matchingChar = 0;
            for (int x = 0; x < SIZE; x++) {
                if (map[y][x] == symbol) {
                    matchingChar++;
                } else matchingChar = 0;
                if (matchingChar == DOTS_TO_WIN) return true;
            }
        }

        // Проверим все вертикали
        for (int x = 0; x < SIZE; x++) {
            matchingChar = 0;
            for (int y = 0; y < SIZE; y++) {
                if (map[y][x] == symbol) {
                    matchingChar++;
                } else matchingChar = 0;
                if (matchingChar == DOTS_TO_WIN) return true;
            }
        }

        // Проверим все диагонали /
        for (int i = SIZE - 1; i >= DOTS_TO_WIN - 1; i--) {
            for (int j = 0; j <= DOTS_TO_WIN - 1; j++) {
                matchingChar = 0;
                for (int x = i, y = j; x >= 0 && y < SIZE; x--, y++) {
                    if (map[y][x] == symbol) {
                        matchingChar++;
                    } else matchingChar = 0;
                    if (matchingChar == DOTS_TO_WIN) return true;
                }
            }
        }

        // Проверим все диагонали \
        for (int i = 0; i <= DOTS_TO_WIN - 1; i++) {
            for (int j = 0; j <= DOTS_TO_WIN - 1; j++) {
                matchingChar = 0;
                for (int x = i, y = j; x < SIZE && y < SIZE; x++, y++) {
                    if (map[y][x] == symbol) {
                        matchingChar++;
                    } else matchingChar = 0;
                    if (matchingChar == DOTS_TO_WIN) return true;
                }
            }
        }

        return false;
    }

    private static void aiTurn() {
        int x, y;

        do {
            x = random.nextInt(SIZE); // [0 .. SIZE)
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_0;
    }

    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате x y");
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

        // Отступ
        for (int i = 0; i < LINE_LIMIT; i++) {
            System.out.println();
        }

        // Верхняя легенда
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
