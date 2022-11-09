package documentation;

// A Final class can't be subclassed or instantiated
// A Final method can't be overridden

/**
 * TO find the last digit of a number. we say: number % 10
 * TO find the first digit of a number. we say: number /10;
 */
public class Odd {

    public static void main(String[] args) {
        System.out.println(hasSharedDigit(9, 99));
    }

    static boolean isOdd(int number) {
        if (!(number > 0))
            return false;

        return number % 2 != 0;
    }

    static int sumOdd(int start, int end) {
        if (!(end >= start) && (start > 0 && end > 0)) {
            return -1;
        }

        int sumOfOdd = 0;
        for (int i = start; i <= end; i++) {
            if (isOdd(i))
                sumOfOdd += i;
        }
        return sumOfOdd;
    }


    /*
    Write a method named printFactors with one parameter of type int named number.
    If number is < 1, the method should print "Invalid Value". The method should print all factors of the number.
    A factor of a number is an integer which divides that number wholly (i.e. without leaving a remainder).
    For example, 3 is a factor of 6 because 3 fully divides 6 without leaving a remainder. In other words 6 / 3 = 2.
     */
    public static void printFactors(int number) {
        if (number < 1) {
            System.out.println("Invalid Value");
        }

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.println(i);
            }
        }
    }

    /*
    Write a method named isPerfectNumber with one parameter of type int named number.
    If number is < 1, the method should return false. The method must calculate if the number is perfect.
    If the number is perfect, the method should return true; otherwise, it should return false.
     */
    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
    //A perfect number is a positive integer which is equal to the sum of its proper positive divisors.


    /*
    Finding the greatest common divisor.
    Write a method named getGreatestCommonDivisor with two parameters of type int named first and second.
    If one of the parameters is < 10, the method should return -1 to indicate an invalid value.
     */
    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10)
            return -1;

        int minVal = 0, maxVal = 0;
        if (first > second) {
            maxVal = first;
            minVal = second;
        } else {
            maxVal = second;
            minVal = first;
        }

        int index = minVal;
        int gcf = 0;
        while (index >= 1) {
            if (minVal % index == 0 && maxVal % index == 0) {
                gcf = index;
                break;
            }
            index--;
        }
        return gcf;
    }

    /*
    Write a method named hasSharedDigit with two parameters of type int.
    Each number should be within the range of 10 (inclusive) - 99 (inclusive).
    If one of the numbers is not within the range, the method should return false.
     */
    public static boolean hasSharedDigit(int firstNumber, int secondNumber) {

        if (firstNumber < 10 || firstNumber > 99 || secondNumber < 10 || secondNumber > 99) {
            return false;
        }

        int firstNumberLastDigit = firstNumber % 10;
        int firstNumberFirstDigit = firstNumber / 10;

        int secondNumberLastDigit = secondNumber % 10;
        int secondNumberFirstDigit = secondNumber / 10;

        return firstNumberLastDigit == secondNumberLastDigit ||
                firstNumberLastDigit == secondNumberFirstDigit ||
                firstNumberFirstDigit == secondNumberLastDigit ||
                firstNumberFirstDigit == secondNumberFirstDigit;

    }
}
