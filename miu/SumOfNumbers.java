package miu;

import java.util.Random;

public class SumOfNumbers {

    public static void main(String[] args) {
        int[] array = {900, 700, 100, 508, 800};
//         selectionSort(array);
//         for (int i: array){
//             System.out.println(i);
//         }
        System.out.println(sumOfNum(10));

    }

    /*
    #Loop until number is greater than 0; return the sum..
     */
    static int sumOfNum(int number) {
        int sum = 0;
        int remainder;
        while (number > 0) {
            remainder = number % 10;
            sum += remainder;
            number /= 10;
        }
        return sum;
    }

    static int letterCount(String value) {
        char character = value.charAt(0);
        int totalCountOfLetter = 0;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == character) {
                totalCountOfLetter += 1;
            }
        }
        return totalCountOfLetter;
    }

    static void barChar(int[] values) {
        int sales = 0;
        for (int i = 1; i < 5; i++) {
            System.out.println("Store " + i + " : ");
            switch (i) {
                case 1 -> sales = values[0];
                case 2 -> sales = values[1];
                case 3 -> sales = values[2];
                case 4 -> sales = values[3];
                case 5 -> sales = values[4];

            }
            for (int j = 1; j <= sales / 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    static void diceGame(int numberOfRoll) {
        int userWin = 0, userRoll;
        int computerWin = 0, computerRoll;
        int tieGame = 0;
        userRoll = diceRoll();
        computerRoll = diceRoll();

        for (int i = 0; i < numberOfRoll; i++) {
            if (userRoll == computerRoll) {
                tieGame++;
            } else {
                if (userRoll > computerRoll)
                    userWin++;
                else
                    computerWin++;
            }

        }
        System.out.println("Computer Win: " + computerWin);
        System.out.println("User Win: " + userWin);
        System.out.println("Tie Game : " + tieGame);
        System.out.println();
        determineWin(userWin, computerWin);
    }

    // Determining the winner of the game....
    static void determineWin(int user, int computer) {
        if (computer > user) {
            System.out.println("The computer wins: ");
        } else {
            if (computer < user)
                System.out.println("You win the computer.");
            else
                System.out.println("The game ended in a tie.");
        }
    }


    // Rolling the dice of 6.
    static int diceRoll() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    // A sequential search algorithm that searches for a value in an array.
    static int sequentialSearch(int[] array, int value) {
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == value)
//                return i;
//        }
//        return -1;

        for (int j : array) {
            if (j == value) {
                return value;
            }
        }
        return -1;
    }


    static void selectionSort(int[] array) {

        // loop thru and set the first element as minimum
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;

            /*
            swap index one and two, see if index one is greater than two.
            If true, initialize the minimum value to index two.
             */

            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            // Make the temporary value to the initial element or element swapped.
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}
