package ru.kyper.java;

import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {

    public static void main(String[] args) {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
                          "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String hiddenWord, enteredWord, displayedString, allWords = "";

        for (String word: words) {
            allWords = allWords + (allWords.equals("") ? "" : ", ") + word;
        }
        Random random = new Random();
        hiddenWord = words[random.nextInt(words.length - 1)];
        boolean wordsMatch, charMatch;

        System.out.println("Я загадал случайное слово из:");
        System.out.println(allWords);
        System.out.println("Это слово: ");

        Scanner scanner = new Scanner(System.in);
        do {
            enteredWord = scanner.next();
            wordsMatch = true;
            displayedString = "";

            for (int i = 0; i < enteredWord.length() && i < hiddenWord.length(); i++) {
                charMatch = enteredWord.charAt(i) == hiddenWord.charAt(i);
                displayedString = displayedString + (charMatch ? enteredWord.charAt(i) : '*');
                wordsMatch = wordsMatch && charMatch && enteredWord.length() == hiddenWord.length();
            }

            for (int i = enteredWord.length(); !wordsMatch && i < 16; i++) {
                displayedString = displayedString + '*';
            }
            System.out.println("Вы" + (wordsMatch ? " ": " не ") + "угадали!");
            System.out.println(displayedString);
        } while (wordsMatch == false);

    }
}
