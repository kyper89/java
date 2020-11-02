package ru.kyper.java;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int counter, hiddenNumber, enteredNumber;
        do {
            counter = 0;
            enteredNumber = -1;
            hiddenNumber = random.nextInt(10);
            while (counter < 3 && enteredNumber != hiddenNumber) {
                System.out.print("Я загадал число от 0...9. Это число: ");
                enteredNumber = scanner.nextInt();
                if (enteredNumber != hiddenNumber) {
                    System.out.println("Введенное число " + (enteredNumber < hiddenNumber ? "меньше" : "больше"));
                    counter++;
                }
            }

            System.out.println("Вы " + (enteredNumber == hiddenNumber? "выиграли!" : "проиграли - " + hiddenNumber));
            System.out.print("Повторить игру еще раз? Да - введите 1, нет - 0: ");
        }	while (scanner.nextInt() == 1);
    }
}
