package kunalDsaSolution.algorithm;

import java.util.*;

public class ElevenEleven {

    public static void main(String[] args) {
        answer();
    }

    private static void answer() {
        int[] arr = {8, 1, 2, 2, 3};
        int[][] arr_2D = {{3, 2, 1}, {3, 8, 9}, {5, 6, 3}};
        int[][] arr2 = {{1, 5}, {7, 3}, {3, 5}};
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    static int richestCustomerWealth(int[][] customers) {
        int max = Integer.MIN_VALUE;

        for (int person = 0; person < customers.length; person++) {
            int total = 0;
            for (int account = 0; account < customers[person].length; account++) {
                total += customers[person][account];
            }

            if (total > max) {
                max = total;
            }
        }
        return max;
    }

    static int[] concatOfArray(int[] arr) {
        int[] ans = new int[2 * arr.length];

        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
            ans[i + arr.length] = arr[i];
        }
        return ans;
    }

    static int[] runningSum(int[] arr) {
        int[] runSum = new int[arr.length];

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            runSum[i] = sum;
        }
        return runSum;
    }

    // We first find the largest candy, and then we add the extra candy to
    // the largest and if the kid is the richest.
    static List<Boolean> kidWithGreatestNumberOfCandy(int[] candies, int extraCandies) {
        int n = candies.length;
        List<Boolean> candyList = new ArrayList<>();


        int maxNumCandy = 0;
        for (int i = 0; i < n; i++) {
            if (candies[i] > maxNumCandy) {
                maxNumCandy = candies[i];
            }
        }

        for (int candy : candies) {
            if (extraCandies + candy >= maxNumCandy)
                candyList.add(true);
            else
                candyList.add(false);
        }
        return candyList;
    }

    static int numberOfIdenticalPairs(int[] nums) {
        if (nums == null)
            return -1;

        int n = nums.length;
        int goodPairs = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j])
                    goodPairs += 1;
            }
        }
        return goodPairs;
    }

    static int[] smallerThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (j != i && nums[i] > nums[j])
                    count++;
            }
            ans[i] = count;
        }
        return ans;
    }

    static int[] targetArray(int[] nums, int[] index) {
        List<Integer> tempArray = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            tempArray.add(index[i], nums[i]);
        }

        int[] target = new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
            target[j] = tempArray.get(j);
        }

        return target;
    }

    static boolean isPangram1(String word) {
        if (word == null)
            return false;

        for (int i = 97; i <= 122; i++) {
            if (word.indexOf(i) == -1)
                return false;
        }
        return true;
    }

    static boolean isPangram2(String sentence) {
        Set<Character> letters = new HashSet<>();
        for (Character index : sentence.toCharArray()) {
            letters.add(index);
        }
        return letters.size() == 26;
    }

    // Transpose matrix where rows become columns and columns become rows.
    static int[][] transposeMatrix1(int[][] matrix) {
        if (matrix == null)
            return new int[][]{{-1, -1}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }

    static int[][] transposeMatrix2(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] transposedMatrix = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                transposedMatrix[i][j] = matrix[j][i];

        return transposedMatrix;
    }

    static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }

            digits[i] = 0;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
