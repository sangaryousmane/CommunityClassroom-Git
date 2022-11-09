package kunalDsaSolution.searching;

public class LinearSearch {

    // Find how many digits is in a number....
    /*
    // Check if num  is negative
        // Check if num is equal to 0
        // initialize the counter to 0
        // Use a while loop until num > 0
        // increment the counter variable by one during each iteration
        // divide the num by 10 as the loop progresses
        // Returns the total number of counts.

     */
    static int numOfDigits(int number) {
        if (number < 0)
            number *= -1;

        if (number == 0)
            return 1;

        int counter = 0;
        while (number > 0) {
            counter++;
            number /= 10;
        }
        return counter;
    }

    // Find the reverse of an integer number.
    public static int reverse(int x) {
        long result = 0;

        while (x != 0) {
            result = (result * 10) + (x % 10);
            x /= 10;
        }
        if (result >= Integer.MIN_VALUE && result <= Integer.MAX_VALUE) {
            return (int) result;
        }
        return 0;
    }

    // https://leetcode.com/problems/richest-customer-wealth/
    static int wealthOfRichestCustomer(int[][] array) {
        int ans = array[0][0];

        for (int[] person : array) {
            int total = 0;
            for (int account : person) {
                total += account;
            }

            if (total > ans)
                ans = total;
        }
        return ans;
    }

    static int richestCustomer(int[][] arr) {
        int richestCustomer = 0;

        for (int i = 0; i < arr.length; i++) {
            int totalRichest = 0;
            for (int j = 0; j < arr[i].length; j++) {
                totalRichest += arr[i][j];
            }
            if (totalRichest > richestCustomer)
                richestCustomer = totalRichest;
        }
        return richestCustomer;
    }


    // Find minimum number in the array
    static int minimum(int[] array) {
        int minimum = array[0];

        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            if (element < minimum) {
                minimum = element;
            }
        }
        return minimum;
    }

    // Search the maximum number in the range of array
    static int maxRange(int[] array, int start, int end) {
        int max = array[0];

        for (int i = start; i <= end; i++) {
            int element = array[i];
            if (element > max)
                max = element;
        }
        return max;
    }


    // Linearly search for an element in a 2D array, return the index if found
    // Otherwise return negative index like: {-1, -1}
    static int[] search2D(int[][] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Search whether a specific element is found in an array...
    static boolean isFoundIn2D(int[][] array, int target) {
        if (array == null)
            return false;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target)
                    return true;
            }
        }
        return false;
    }

    // Find the minimum number in a 2D array
    static int min2D(int[][] array) {
        int minVal = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < minVal)
                    minVal = array[i][j];
            }
        }
        return minVal;
    }

    // Find the minimum number in a 2D array. Enhanced form.
    static int minOf2D(int[][] arr) {
        int minVal = arr[0][0];
        for (int[] outer : arr) {
            for (int inner : outer) {
                if (inner < minVal)
                    minVal = inner;
            }
        }
        return minVal;
    }

    // Given an array nums of integers, return how many of them contain an even number of digits.
    public static int evenNumberOfDigits(int[] arr) {

        if (arr.length == 0)
            return -1;

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (numberOfDigits1(arr[i]) % 2 == 0) {
                count += 1;
            }
        }
        return count;
    }

    //
//    // Is the number of digits even or not? true:false;
    static boolean isEvenDigits(int number) {
        return numberOfDigits1(number) % 2 == 0;
    }

    // Count the number of digits in a number with all checks set.
    static int numberOfDigits1(int number) {

        if (number < 0)
            number *= -1;

        if (number == 0)
            return 1;

        int counter = 0;

        while (number > 0) {
            counter++;
            number /= 10;
        }
        return counter;
    }

    // Most enhanced way...
    static int numberOfDigits2(int number) {
        if (number < 0)
            number *= -1;

        if (number == 0)
            return 1;

        return (int) Math.log10(number) + 1;
    }

    // Find the maximum number in a 2D array:
    static int maxOf2D(int[][] arr) {
        int maxVal = arr[0][0];

        for (int[] array : arr) {
            for (int i : array) {
                if (i > maxVal) {
                    maxVal = i;
                }
            }
        }
        return maxVal;
    }

    // Even counter
    static boolean isEven(int num) {
        return num % 2 == 0;
    }

    // Check if number is prime or not
    static boolean isPrime(int number) {

        if (number <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Calculate the object in motion (Kinetic energy) KE = ½ mv2
    static double kineticEnergy(int mass, int velocity) {
        return 0.5 * mass * doubleTime(velocity);
    }

    // convert from meters to kilometers
    static double showKilometers(int meters) {
        return meters * 0.001;
    }

    // convert from meters to inches
    static double showInches(int meters) {
        return meters * 39.37;
    }

    // Convert from meters to feet
    static double showFeet(int meters) {
        return meters * 3.281;
    }

    static int doubleTime(int time) {
        return time * time;
    }

    static double fallingDistance(int time) {
        return (1 / 2.0 * 9.8) * doubleTime(time);
    }

    // Check if the number is palindrome or not....
    static boolean isPalindrome(int number) {
        int reverse = 0;
        int realNumber = number;

        while (number != 0) {
            int lastDigit = number % 10;
            reverse = (reverse * 10) + lastDigit;
            number /= 10;
        }
        return realNumber == reverse;
    }

    // Search for the index of an element and return it if found, otherwise return -1;
    static int linearSearchIndexOfElement(int[] arr, int target) {

        if (arr == null || arr.length == 0)
            return -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    // Search between the range of start and end element if target exist.
    // Return the index if exist otherwise return -1;
    static int searchInRange(int[] arr, int target, int start, int end) {

        for (int index = start; index <= end; index++) {
            int element = arr[index];

            if (element == target) {
                return index;
            }
        }
        return -1;
    }


    // Linearly kunalDsaSolution.searching elements to check if it's found.
    static boolean hasFound(int[] arr, int target) {
        if (arr == null)
            return false;

        for (int index : arr) {
            if (index == target)
                return true;
        }
        return false;
    }

    static boolean searchString(String value, char target) {
        boolean isFound = false;
        for (int i = 0; i < value.length(); i++) {
            if (target == value.charAt(i)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    static boolean searchInText(String text, String word) {
        if (text == null)
            return false;

        String[] tokens = text.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals(word))
                return true;
        }
        return false;
    }

    static int middleElement(int[] array) {
        if (array == null || array.length % 2 == 0)
            return -1;

        int midIndex = array.length / 2;
        return array[midIndex];

    }
}
