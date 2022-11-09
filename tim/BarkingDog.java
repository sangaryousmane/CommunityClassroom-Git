package tim;

import java.util.Arrays;

public class BarkingDog {

    public static void main(String[] args) {
        boolean result = isPrime(27);
        int reverse = getCountDigit(630032);
        int[] arr = {3, 0, 1, 4};
        reverseArray(arr);
    }

    /*
    1. Write a method name shouldWakeUp
    2. param 1, isBarking
    3. param 2, hourOfDay
     */
    public static boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
        if (hourOfDay >= 0 && hourOfDay <= 23)
            isBarking = true;

        if (hourOfDay < 8 || hourOfDay > 22)
            isBarking = true;

        if (hourOfDay < 0 || hourOfDay > 23)
            isBarking = false;
        return isBarking;
    }

    public static boolean hasEqualSum(int num1, int num2, int num3) {
        return num1 + num2 == num3;
    }

    public static boolean hasTeen(int age1, int age2, int age3) {
        return isTeen(age1) || isTeen(age2) || isTeen(age3);
    }

    static boolean isTeen(int num) {
        return num >= 13 && num <= 19;
    }

    public static boolean hasSameLastDigit(int num1, int num2, int num3) {

        boolean result = (num1 % 10 == num2 % 10) || (num3 % 10 == num1 % 10) || (num2 % 10 == num3 % 10);

        return result && (isValid(num1) && isValid(num2) && isValid(num3));
    }

    static boolean isValid(int number) {
        return number >= 10 && number <= 1000;
    }

    public static void factorOfNumber(int number) {
        if (number < 0)
            System.out.println("Invalid value");

        for (int i = 1; i <= number; i++) {
            if (number % i == 0)
                System.out.println(i);
        }
    }

    public static boolean perfectNumber(int number) {
        if (number < 1)
            return false;

        int divisors = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0)
                divisors = divisors + i;
        }
        return divisors == number;
    }

    public static int reverseNum(int number) {
        int sign = 1;

        if (number < 0) {
            sign = -1;
            number = -number;
        }
        int reverse = 0;
        while (number != 0) {
            int lastDigit = number % 10;
            reverse = (reverse * 10) + lastDigit;
            number /= 10;
        }
        return sign * reverse;
    }

    public static int getCountDigit(int number) {
        if (number < 0)
            return -1;
        if (number == 0)
            return 1;

        int countDigit = 0;
        while (number > 0) {
            countDigit++;
            number /= 10;
        }
        return countDigit;
    }

    public static boolean isPrime(int number) {

        boolean primeCount = false;
        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                primeCount = true;
                break;
            }
        }
        if (!primeCount) {
            primeCount = true;
        } else {
            primeCount = false;
        }
        return primeCount;
    }

    public static int largestPrime(int number) {
        int max = 1;

        for (int i = 0; i < number; i++) {
            if (isPrime(number)) {
                max = number;
                break;
            }

        }
        return max;
    }

    private static void reverseArray(int[] arr) {
        int n = arr.length;
        int end;
        System.out.print("Array=" + Arrays.toString(arr));

        for (int i = 0; i < n / 2; i++) {
            end = n - i - 1;
            int temp = arr[i];
            arr[i] = arr[end];
            arr[end] = temp;
        }
        System.out.print("Reversed array = "+Arrays.toString(arr));
    }

}
