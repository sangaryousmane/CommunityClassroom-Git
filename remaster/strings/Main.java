package remaster.strings;

public class Main {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 8};
        int target = 6;
        System.out.println(Algo.insertPositionLinear(arr, target));
    }

    /*
    In a sorted array, return the smallest element that is greater or equal to target.
    In order words, find the ceiling of a number in a sorted array
     */
    static int ceiling(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;

        // If the target element is greater than the greatest number in an array
        if (target > A[end])
            return -1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (target < A[middle])
                end = middle - 1;
            else if (target > A[middle])
                start = middle + 1;
            else return middle;
        }
        return start;
    }

    /*
    In an array, find the smallest of the numbers that is less than or equal to the target.
    In order words, find the floor of a number in a sorted array
     */
    static int floor(int[] A, int target) {
        int n = A.length, start = 0, end = n - 1;


        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (target < A[middle]) end = middle - 1;
            else if (target > A[middle]) start = middle + 1;
            else return middle;
        }
        return end;
    }

    //https://leetcode.com/problems/find-smallest-letter-greater-than-target/submissions/832635262/
    // Much like ceiling of a number, but we wrap around this time
    static char nextGreaterLetter(char[] letters, int target) {
        int start = 0, n = letters.length, end = n - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (target < letters[middle]) end = middle - 1;
            else start = middle + 1;

        }
        return letters[start % n];
        // The start remainder length is usually equal start
        // let length =4, start=3 start%4 = 3.
        // Therefore, start % length = start
    }


    static char[] charSpace(char[] a, int start, int length) {
        if (length < 0 || start < 0 || start + length - 1 >= a.length)
            return null;

        char[] result = new char[length];
        for (int i = start, j = 0; j < length; i++, j++) {
            result[j] = a[i];
        }
        return result;
    }


    static int sum(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += (i * i * i);
        }
        return sum; // 9+ 27 +
    }

    static int factorial(int n) {

        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }


    // This is the maximum subarray problem using kadence's rule
    static int maxSumSubArray(int[] arr) {
        int local_max = 0;
        int global_max = Integer.MIN_VALUE;

        for (int j : arr) {
            local_max = Math.max(j, (j + local_max));

            if (local_max > global_max) {
                global_max = local_max;
            }
        }
        return global_max;
    }

    // Using the euclidean algorithm to find GCD
    static int euclideanGcD(int m, int n) {

        while (n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }
}
