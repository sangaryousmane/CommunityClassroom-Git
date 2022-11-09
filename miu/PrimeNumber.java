package miu;

import java.io.FileNotFoundException;

public class PrimeNumber {

    public static void main(String[] args) throws FileNotFoundException {
        occurenceInNumbers(3002);

    }

    static void primeNumber(int number) {
        int n = 2;

        while (n < number) {
            if (number % n == 0)
                System.out.println("Not Prime");
            else
                System.out.println("It's Prime");
            n++;
        }

    }

    static void celsiusTable(int celsius) {
        int quotient = 9 / 5;

        for (int i = 0; i < celsius; i++) {
            System.out.println("The celsius at: " + (celsius + i) + " is: " + ((quotient * (celsius + i) + 32)) + " fahrenheit");
        }
    }

    static int centerNumberArray(int[] array) {
        if (array == null || array.length % 2 == 0) return 0;

        int midIndex = array.length / 2;
        int middleItem = array[midIndex]; // The index of an odd number array is the middle element.

        for (int i = 0; i < array.length; i++) {
            if (i != midIndex && middleItem >= array[i])
                return 0;
        }
        return 1;
    }

    static int sumOfEvenAndOdd(int[] array) {
        int sumOfEven = 0;
        int sumOfOdd = 0;

        for (int i : array) {
            if (i % 2 == 0)
                sumOfEven += i;
            else
                sumOfOdd += i;
        }
        return sumOfOdd - sumOfEven;
    }

    // Reverse Integer
    static int reverseInt(int number) {
        int sign = 1;
        // 584
        if (number < 0) {
            sign = -1;
            number = -number;
        }
        int reverse = 0;
        while (number != 0) {
            reverse = (reverse * 10) + (number % 10);
            number = number / 10;
        }
        return sign * reverse;
    }

    /*
    Find the largest among three numbers.
     */
    static void largest(int a, int b, int c) {
        int max = Math.max(c, Math.max(b, a));
        int large=a;

        if (b > large)
            large=b;
        if (c > large)
            large=c;
        System.out.println(large);
    }

    static void letterCaseCheck(String values) {
        char letter = values.trim().charAt(0);

        if (letter >= 'a' && letter <= 'z')
            System.out.println("Lowercase letters.");
        else
            System.out.println("Uppercase letters.");
    }

    static int fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int fib(int n) {
        int a = 0;
        int b = 1;
        int count = 2;
        while (count <= n) {
            int temp = b;
            b += a;
            a = temp;
            count++;
        }
        return b;
    }

    static void occurenceInNumbers(int n){
        int count=0;
        while (n > 0){
            int remainder = n % 10;
            if (remainder==5){
                count ++;
            }
            n /=10;
        }
        System.out.println(count);
    }
}
