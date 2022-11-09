package kunalDsaSolution;

public class LinearSearchModule {

    public static void main(String[] args) {
        int[] arr_1D = {3, 2, 4, 18, 48, 10, -10};
        int[][] arr_2D = {{3, 2}, {0, 2}, {10, 12}};
        int result_1D = LinearSearchModule.middleElement(arr_1D);
        int[] result_2D = LinearSearchModule.search2D(arr_2D, 0);
        boolean found = LinearSearchModule.wordIfFound("Hello there world", "there");
        System.out.println();
//        LinearSearchModule.maxMin(arr_2D);
        answers();
    }

    // Method for answers
    static void answers() {
        int number = 9;
        int[] arr = {2, 7, 11, 15};

        System.out.println((1922));
    }

    // Find the middle Element in the array
    static int middleElement(int[] arr) {
        if (arr == null || arr.length % 2 == 0) return -1;

        int n = arr.length;

        int midIndex = n / 2;
        return arr[midIndex];

    }

    // Find how many digits is in a number
    static int numberOfDigits(int number) {
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

    // Find the reverse of a given integer number
    static int intReverse(int number) {
        long result = 0;
        int sign = 1;

        if (number < 0) {
            sign = -1;
            number = -number;
        }

        while (number != 0) {
            int remainder = number % 10;
            result = (result * 10) + (remainder);
            number /= 10;
        }
        if (result >= Integer.MIN_VALUE && result < Integer.MAX_VALUE) {
            return sign * (int) result;
        }
        return 0;
    }

    // Find the wealth of the richest customer in a given array
    static int wealthOfRichestCustomer(int[][] accounts) {
        int richestCustomer = accounts[0][0];


        for (int person = 0; person < accounts.length; person++) {
            int sumOfWealth = 0;
            for (int account = 0; account < accounts[person].length; account++) {
                sumOfWealth += accounts[person][account];
            }

            if (sumOfWealth > richestCustomer) richestCustomer = sumOfWealth;
        }
        return richestCustomer;
    }

    // Find the minimum element in the array
    static int minimumElement(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    // Find the maximum number in the range of a given array
    static int maxRange(int[] arr, int start, int end) {
        int max = arr[0];
        for (int index = start; index <= end; index++) {
            int element = arr[index];
            if (element > max)
                max = element;
        }
        return max;
    }

    // Find the minimum number in the range of a given array
    static int minRange(int[] arr, int start, int end) {
        int min = arr[0];

        for (int i = start; i <= end; i++) {
            int element = arr[i];
            if (element < min)
                min = element;
        }
        return min;
    }

    // Find a given element in a given 2D array
    static int[] search2D(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int element = arr[i][j];
                if (target == element)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, 1};
    }

    // Search if an element is found in a given 2D array return true, otherwise, return false.
    static boolean isFoundIn2D(int[][] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int element = arr[i][j];
                if (target == element) {
                    return true;
                }
            }
        }
        return false;
    }

    // Find the minimum and maximum number in a given 2D array
    static void maxMin(int[][] arr) {
        int min = arr[0][0];
        int max = arr[0][0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int element = arr[i][j];
                if (element < min)
                    min = element;
                else
                    max = element;
            }
        }
        System.out.println("The minimum is: " + min);
        System.out.println("The maximum is: " + max);
    }

    // Given an array nums of integers, return how many of them contain an even number of digits.
    static int evenNumberOfDigits(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (isEven(arr[i]))
                count += 1;
        }
        return count;
    }

    // Check if the number of digit is even or not.
    static boolean isEven(int number) {
        return numberOfDigits(number) % 2 == 0;
    }

    // Number of digits, most enhanced.
    static int numberOfDigitsEnhance(int n) {
        if (n < 0)
            n *= -1;
        if (n == 0)
            return 1;

        return (int) Math.log10(n) + 1;
    }

    // Check if the number is even
    static boolean isEvenNumber(int n) {
        return n % 2 == 0;
    }

    // Check if the number is palindrome
    static boolean isPalindrome(int n) {
        int realNumber = n;
        int reverse = 0;
        while (n != 0) {
            int lastDigit = n % 10;
            reverse = (reverse * 10) + lastDigit;
            n /= 10;
        }
        return realNumber == reverse;

    }

    // search for the index of an element and return true when found, otherwise, return false.
    static int indexFound(int[] arr, int target) {
        if (arr == null || arr.length == 0)
            return -1;

        for (int index = 0; index < arr.length; index++) {
            int element = arr[index];
            if (target == element)
                return index;
        }
        return -1;
    }

    // Search between the range of start and end element if target exist.
    // Return the index if exist otherwise return -1;
    static int searchRange(int[] arr, int start, int end, int target) {

        for (int index = start; index <= end; index++) {
            int element = arr[index];
            if (target == element)
                return index;
        }
        return -1;
    }

    // Search for a letter in a given word.
    static boolean isLetterFound(String word, char letter) {
        boolean isFound = false;

        for (int index = 0; index < word.length(); index++) {
            if (letter == word.charAt(index)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    // Search for a word in a given sentence
    static boolean searchForWord(String sentence, String word) {
        String[] tokens = sentence.split(" ");
        boolean isFound = false;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals(word)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    static boolean wordIfFound(String phrase, String word) {
        String[] words = phrase.split(" ");
        for (int i = 0; i < words.length; i++) {
            String wordIndex = words[i];
            if (wordIndex.equals(word))
                return true;
        }
        return false;
    }

    // 1. https://leetcode.com/problems/sqrtx/description/
    // There are a lot of casting to avoid integer overflow error
    static int mySqrt(int number) {
        long low = 1, high = number, sqrt = 0;

        while (low <= high) {
            long middle = low + (high - low) / 2;

            if ((middle * middle) <= number) {
                sqrt = middle;
                low = middle + 1;
            } else
                high = middle - 1;
        }
        return (int) sqrt;
    }

    static int sqrt(int n) {
        long start = 1, end = n, ans = 0;

        while (start <= end) {
            long middle = start + (end - start) / 2;

            if ((middle * middle) <= n) {
                ans = middle;
                start = middle + 1;
            } else
                end = middle - 1;
        }
        return (int) ans;
    }


    // 2 https://leetcode.com/problems/guess-number-higher-or-lower/description/
    // 3. https://leetcode.com/problems/first-bad-version/description/

    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    static int[] twoSum1(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int sum = nums[start] + nums[end];

            if (sum == target)
                return new int[]{start + 1, end + 1};
            else if (sum < target)
                start++;
            else
                end--;
        }
        return null;
    }

    // https://leetcode.com/problems/valid-perfect-square
    static boolean isPerfectSquare(int number) {
        long start = 0, end = number;

        while (start <= end) {
            long middle = start + (end - start) / 2;
            long sqrt = middle * middle;

            if (sqrt == number) {
                return true;
            } else if (sqrt > number)
                end = middle - 1;
            else
                start = middle + 1;

        }
        return false;
    }
}

