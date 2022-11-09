package documentation;

import java.util.InputMismatchException;

/**
 * Dynamic memory allocation means: memory is allocated during runtime.
 * and declaration is done during compile time.
 * JLS => Java Language Specification.
 * In java, heap objects aren't continuous unlike C and C++.
 * Array objects may not be continuous depending on the JVM.
 * 1. Array object or any objects are stored in the heap memory.
 * <p>
 *     https://www.geeksforgeeks.org/searching-algorithms/
 * HEAP MEMORY:
 * Java heap is used to allocate memory for objects and JRE classes.
 * Creating a new object also occurs on the heap. This is where the
 * garbage collector works: it frees up memory by deleting objects that
 * aren't referenced. Any object created on the heap has global access
 * and can be referenced from any part of the application.
 * <p>
 * STACK MEMORY:
 * Stack memory in java works according to the LIFO scheme. Whenever
 * a method is called, a new block is created in the stack's memory that
 * contains primitives and references to other objects in the method.
 * Once the method finishes, the block is also no longer in use, thereby
 * granting access to the next method. The stack memory size is much smaller
 * than the amount of memory on the heap. Whenever an object is created,
 * it is always stored on the heap, and the stack memory contains a reference
 * to it. Stack memory contains only variables of primitive types and
 * references to object on the heap.
 * StackOverFlowError -> is thrown if the stack memory is fully occupied during runtime.
 * OutOfMemoryError -> is thrown if the heap memory is full.
 * The stack memory size is much smaller than the memory on the heap. Because of the ease of
 * memory allocation(s), stack memory is much faster than the heap. LIFO.
 * <p>
 * Numbers that aren't divisible by 2 and generates a remainder of 1 is called an odd number....
 * A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
 */
public class MyArray {

    public static void main(String[] args) {

        int[] arrays = {3, 9, 5, 2, 6, 10, 12, 4};


//        showChar("New York", 2);

        System.out.println(letterCounterInRange("Petter", 0, 2, 't'));



    }

    // count the number of a given letter in a text
    static int letterCounterInRange(String value,int start, int end, char letter){
        int counter=0;

        for (int index=start; index<=end; index++){
            if (letter==value.charAt(index))
                counter ++;
        }
        return counter;
    }

    // Factorial of n is the product of all positive descending integers. Factorial of n is denoted by n!
    // Using loops
    static int factorialLoops(int number) {
        int start = 1;

        if (number == 1)
            return 1;

        for (int i = 1; i <= number; i++) {
            start *= i;
        }
        return start;
    }

    // Program to find sum of first n natural numbers
    static int sumOfNaturalNumbers(int number) {
        int sum = 0;

        for (int i = 0; i <= number; i++) {
             sum += i;
        }
        return sum;
    }

    static boolean isPalindrome(int number) {

        int reverse = 0;

        int ans=number;
        while (number != 0) {
            int remainder = number % 10;
            reverse = (reverse * 10) + remainder;
            number /= 10;
        }

        return ans== reverse;
    }

    // Using Recursion
    static int factorialRecursion(int number) {

        if (number == 0)
            return 1;
        return number * factorialRecursion(number - 1);
    }

    static String gradesAccordingToUserInput(int number) {

        if (number <= 100 && number >= 91)
            return "A";
        else if (number <= 90 && number >= 81)
            return "AB";
        else if (number <= 80 && number >= 71)
            return "BB";
        else if (number <= 70 && number >= 61)
            return "BC";
        else if (number <= 60 && number >= 51)
            return "CD";
        else if (number <= 50 && number >= 41)
            return "DD";
        else
            return "Fail";

    }

    // Calculate the area of a circumference. 2*PI*r
    static double areaOfCircumference(int radius) {
        return 2 * (Math.PI * radius);
    }

    // Calculate the area of a circle PI*r*r
    static double areaOfCircle(int radius) {
        return Math.PI * (radius * radius);
    }

    static boolean isEligibleToVote(int age) {
        return age >= 18;
    }

    static int sumOfTwoNumbers(int a, int b) {

        if (a < 0 && b < 0)
            return -1;
        return a + b;
    }

    static int productOfTwoNumbers(int a, int b) {
        return a * b;
    }

    static void checkIfEvenOrOdd(int number) {

        if (number % 2 == 0)
            System.out.printf("%d is even ", number);
        else
            System.out.printf("%d is odd ", number);
    }

    // Write a Program to find the Minimum of the Given Three Numbers.
    static int minOfThreeNums(int a, int b, int c) {
        int smallest = a;
        if (b < smallest)
            smallest = b;
        else if (c < smallest)
            smallest = c;
        return smallest;
    }

    // Write a Program to find the Maximum and Minimum of the Given Three Numbers.
    static int maxOfThreeNums(int a, int b, int c) {
        int largest = a;

        if (b > largest) {
            largest = b;
        } else if (c > largest) {
            largest = c;
        }
        return largest;
    }

    // Use two pointers method and reverse an array using the swap() func.
    // This reverses both even and odd numbers in an array.....
    static void reverse(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }

    static int minRange(int[] array, int start, int end) {
        int minVal = array[0];
        for (int i = start; i <= end; i++) {
            if (array[i] < minVal) {
                minVal = array[i];
            }
        }
        return minVal;
    }

    // Return the maximum value between certain range of numbers.....
    static int maxRange(int[] arr, int start, int end) {
        int max = arr[start];

        for (int i = start; i <= end; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static double average(int[] array) {
        int sum = 0;

        if (array == null)
            return -1.0;

        for (int j : array) {
            sum += j;
        }
        return Math.round((double) sum / array.length);
    }

    static int sum(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    static int max(int[] array) {

        if (array.length == 0)
            return -1;

        int maximum = array[0];
        for (int i : array) {
            if (i > maximum) {
                maximum = i;
            }
        }
        return maximum;
    }

    static int min(int[] array) {

        if (array.length == 0)
            return -1;

        int minimum = array[0];

        for (int i : array) {
            if (i < minimum) {
                minimum = i;
            }
        }
        return minimum;
    }

    static void swap(int[] array, int start, int end) {
        int tempVal=array[start];
        array[start]=array[end];
        array[end]=tempVal;
    }

    static void colNotFixed(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    static int sumOfPositiveInts(int num){
        int sum=0;

        for (int i=0; i<=num; i++){
            sum +=i;
        }
        return sum;
    }

    static void rectangularPattern(int base){

        if (base >15){
            throw new InputMismatchException("Sorry!! Please enter a number less than 15 ");
        }

        for (int row=0; row<base; row++){
            for (int col=0; col<base; col++){
                System.out.print("#");
            }
            System.out.println();
        }
    }

    static void showChar(String value, int number){
        char letter=value.charAt(number);

        System.out.println(value);
        System.out.printf("The letter at index %d  is %s",number, letter);

    }
}
