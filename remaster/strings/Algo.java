package remaster.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Algo {


    // Output these words in ascending order
    static String[] ascendingOrder(String[] names) {
        int n = names.length;
        String temp;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (names[i].compareTo(names[j]) > 0) {
                    temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
        return names;
    }

    static int sumOfNumbers(int n) {
        int i = 1;
        int sum = 0;

        while (i <= n) {
            sum += i;
            i += 1;
        }
        return sum;


        /*
        Method two:
        for(int i=0; i<=n; i++){
           sum +=i;
        }
        return sum;
         */
    }

    static int letterCount(String word, char target) {
        int counter = 0;
        for (char letter : word.toCharArray()) {
            if (letter == target)
                counter++;
        }
        return counter;

    }

    static char showChar(String word, int i) {
        char letter = 'a';

        for (char index : word.toCharArray()) {
            if (word.charAt(i) == index)
                letter = index;
        }
        return letter;
    }

    static int[] greaterThanN(int[] nums, int N) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > N)
                temp[i] = nums[i];
        }

        return temp;
    }

    static String backward(String word) {
        StringBuilder builder = new StringBuilder(word);
        builder.reverse();
        return builder.toString();
    }

    static String backward2(String word) {
        String reverse = "";

        for (int i = 0; i < word.length(); i++) {
            char index = word.charAt(i);
            reverse = index + reverse;

        }
        return reverse;
    }

    static int wordsCount(String sentence) {
        String[] words = sentence.split(" ");
        return words.length;
    }

    static Map<Integer, Integer> numberOfVowelsAndConsonants(String word) {
        int vowel = 0, consonant = 0;

        Map<Integer, Integer> list = null;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'o'
                    || word.charAt(i) == 'i' || word.charAt(i) == 'u') {
                vowel += 1;
            } else {
                consonant += 1;
            }
            list = new HashMap<>();
            list.put(vowel, consonant);
        }
        return list;
    }

    static int sumOfAllNumbersInString(String num) {
        String[] nums = num.split(",");
        int sum = 0;

        for (String index : nums) {
            int value = Integer.parseInt(index);
            sum += value;
        }
        return sum;
    }

    static int sumOfDigitsInString(String num) {
        int sum = 0;
        for (String i : num.split("")) {
            sum += Integer.parseInt(i);
        }
        return sum;
    }

    static boolean searchAValue(int[] arr, int element) {
        for (int j : arr) {
            if (j == element)
                return true;
        }
        return false;
    }

    static int searchInSortedArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (arr[middle] > target)
                end = middle - 1;
            else if (arr[middle] < target)
                start = middle + 1;
            else
                return middle;
        }
        return -1;
    }

    // Recursion to find the power of two numbers
    static int productOfTwoRecur(int x, int y) {
        if (y != 0)
            return x + productOfTwoRecur(x, y - 1);
        return -1;
    }

    // Recursion to find the minimum element in an element
    static int minimumRecur(int[] A, int n) {
        int endIndex = A[n - 1];
        // If the array's length is 1, return the element(first element)
        if (n == 1)
            return A[0];

        return min(endIndex, minimumRecur(A, n - 1));
    }

    // Recursion to find the maximum element in an element
    static int maximumRecur(int[] A, int n) {
        if (n == 1)
            return A[0];

        return max(A[n - 1], maximumRecur(A, n - 1));
    }

    static int min(int a, int b) {
        if (a < b)
            return a;
        return b;
    }

    static int max(int a, int b) {
        if (a > b)
            return a;
        return b;
    }

    // Find the power a number raise to another #
    static int recursivePower(int base, int exponent) {
        if (exponent != 0)
            return base * recursivePower(base, exponent - 1);
        return 1;
    }

    // This is a recursive function that computes the sum of all natural #s
    // The number keeps reducing until a desire result is met.
    static int recurSum(int number) {
        if (number != 0)
            return number + recurSum(number - 1);
        return number;
    }

    static int ackerman(int M, int N) {

        // Executes this when M is 0
        if (M == 0) {
            return N + 1;
        }

        // Do this when N is 0
        if (N == 0) {
            return ackerman(M - 1, 1);
        }

        // Do this when both N and M are greater than 0
        return ackerman(M - 1, ackerman(M, N - 1));

    }

    // https://leetcode.com/problems/valid-perfect-square/
    static boolean validPerfectSquare(int number) {
        int start = 0;
        int end = number;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            int perfectSquare = (middle * middle);

            if (perfectSquare == number)
                return true;
            else if (perfectSquare > number)
                end = middle - 1;
            else
                start = middle + 1;
        }
        return false;
    }


    // https://leetcode.com/problems/arranging-coins/description/
    static int arrangeCoins(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n - count;
        }
        return n < 0 ? count - 1 : count;
    }

    // https://leetcode.com/problems/search-insert-position/
    // Binary Search
    static int insertPosition(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (target < nums[middle])
                end = middle - 1;
            else if (target > nums[middle])
                start = middle + 1;
            else
                return middle;
        }
        return start;
    }

    // Linear Search
    static int insertPositionLinear(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= target)
                return i;
        }
        return n;
    }

    // https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
    static int specialArray(int[] nums) {
        int start = 0;
        int end = nums.length;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            int count = 0;

            for (int i : nums) {
                if (i >= middle)
                    count++;
            }
            if (middle == count)
                return middle;
            else if (middle > count)
                end = middle - 1;
            else
                start = middle + 1;
        }
        return -1;
    }

    // https://leetcode.com/problems/check-if-n-and-its-double-exist/
    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int i : arr) {
            if (seen.contains(2 * i) || i % 2 == 0 && seen.contains(i / 2))
                return true;
            seen.add(i);
        }
        return false;
    }

    // https://leetcode.com/problems/peak-index-in-a-mountain-array/
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int middle = start + (end - start) / 2;

            if (arr[middle] > arr[middle + 1])
                end = middle;
            else
                start = middle + 1;
        }
        return end;
    }

    // https://leetcode.com/problems/find-peak-element/
    static int findPeakElement(int[] nums){
        int start=0;
        int end=nums.length-1;

        while (start < end){
            int middle=start+(end-start)/2;

            if (nums[middle] > nums[middle+1])
                end=middle;
            else
                start=middle+1;
        }
        return start; // U can return either start or end, dou keyi
    }
}