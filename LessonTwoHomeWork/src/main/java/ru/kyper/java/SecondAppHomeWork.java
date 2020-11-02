package ru.kyper.java;

public class SecondAppHomeWork {

    public static void main(String[] args) {

            // 1.
        {
            int[] numbers = {0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0};
            for (int i = 0; i < numbers.length; i++) {

                int value = numbers[i];
                switch (value) {
                    case 0:
                        numbers[i] = 1;
                        break;
                    case 1:
                        numbers[i] = 0;
                }
            }
        }

            // 2.
        {
            int[] numbers = new int[8];
            for (int i = 1, j = 3; i < 8; i++, j += 3) {
                numbers[i] = j;
            }

        }

            // 3.
        {
            int[] numbers = {1, 8, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            for (int i = 0; i < numbers.length; i++) {

                if (numbers[i] < 6) {
                    numbers[i] = numbers[i] * 2;
                }
            }
        }
       
            // 4.
        {
            int[][] numbers = new int[5][5];
            for (int i = 0, j = numbers.length - 1; i < numbers.length; i++, j--) {
                numbers[i][i] = 1;
                numbers[i][j] = 1;
            }
            for (int[] x : numbers) {
                for (int y : x) {
                    System.out.print(y + " ");
                }
                System.out.println();
            }
        }

            // 5. **
        {
            int[] numbers =  {1, 8, 3, 2, 11, 4, 5, 2, 4, 8, 0, -1};

            int min = 0;
            int max = 0;

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] < min || i == 0) min = numbers[i];
                if (numbers[i] > max || i == 0) max = numbers[i];
            }
            System.out.println("min = " + min);
            System.out.println("max = " + max);
        }

            // 6. **
        {
            int[] numbers = {1, 8, 3, 5, 0};
            System.out.println(checkBalance(numbers));
            int[] numbers2 = {2, 2, 2, 1, 2, 2, 10, 1};
            System.out.println(checkBalance(numbers2));
            int[] numbers3 = {1, 1, 1, 2, 1};
            System.out.println(checkBalance(numbers3));
        }

            // 7. ***
        {
            int[] numbers = {1, 2, 3};
            shiftElements(numbers, 1);
            for (int x : numbers) System.out.print(x + " ");

            System.out.println();

            int[] numbers2 = {3, 5, 6, 1};
            shiftElements(numbers2, -2);
            for (int x : numbers2) System.out.print(x + " ");
        }
    }
            // 6. **
    static boolean checkBalance(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {

            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j <= i; j++) {
                leftSum += numbers[j];
            }

            for (int k = numbers.length - 1; k > i; k--) {
                rightSum += numbers[k];
            }

            if (leftSum == rightSum) {
                return true;
            }

        }

        return false;
    }

    // 7. ***
    static void shiftElements(int[] numbers, int n) {

        if (numbers.length == 0) {
            return;
        }

        int startingIndex, currentElement, nextElement, shift, nextIndex;

        if (n < 0) {
            startingIndex = numbers.length - 1;
            shift = -1;
            n = -n;
        } else {
            startingIndex = 0;
            shift = 1;
        }

        for (int i = 0; i < n; i++) {

            currentElement = numbers[startingIndex];
            for (int counter = 1, j = startingIndex; counter <= numbers.length; counter++, j += shift) {

               nextIndex = j + shift;
               if (nextIndex == -1 || nextIndex == numbers.length) {
                   nextIndex = startingIndex;
               }

               nextElement = numbers[nextIndex];
               numbers[nextIndex] = currentElement;
               currentElement = nextElement;
            }
        }     

    }
}