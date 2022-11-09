package kunalDsaSolution.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Steps of solving dynamic programming
/*
- Dynamic memory allocation occurs during runtime where memory is allocated during runtime
- Generally in java, memory allocation totally depends on JVM whether it can be continuous or
not. Reason 1: Objects are stored in heap memory
Reason 2: In JIS, it mentioned that heap objects aren't continuous
Reason 3: Dynamic allocation. Hence, array objects in java mayn't
be continuous(depends on JVM).



 */
public class ArrayLing {

    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7};
//        int[][] D_2 = {{1, 5}, {7, 3}, {3, 5}};
//        int[] nums = {1, 2, 3, 4, 0};
//        int[] index = {0, 1, 2, 3, 0};
        System.out.println();
    }


    // Q1 Concatenation of Array
    static int[] concatArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }

    // Q2 Running sum of an array
    static int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] running = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            running[i] = sum;
        }
        return running;
    }

    // Q3 The Richest Customer Wealth
    static int richestCustomerWealth(int[][] customer) {
        int n = customer.length;
        int max = customer[0][0];

        for (int person = 0; person < n; person++) {
            int sum = 0;
            for (int account = 0; account < customer[person].length; account++) {
                sum += customer[person][account];
            }

            if (sum > max)
                max = sum;
        }
        return max;
    }

    // Q4 Kids with the Greatest  number of Candies
    static List<Boolean> kidsWithRichestNumberCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int n = candies.length;
        int maxNumOfCandy = candies[0];


        for (int i = 0; i < n; i++) {
            int element = candies[i];
            if (element > maxNumOfCandy)
                maxNumOfCandy = element;
        }

        for (int j = 0; j < candies.length; j++) {
            if (candies[j] + extraCandies >= maxNumOfCandy)
                list.add(true);
            else
                list.add(false);
        }
        return list;

    }

    // Q5 Number of good pairs
    static int numberOfGoodPairs(int[] nums) {
        if (nums == null)
            return -1;

        int n = nums.length;
        int goodPairs = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j])
                    goodPairs++;
            }
        }
        return goodPairs;
    }

    // Q6 https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
    static int[] smallerNumThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
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

    // Q7 Create Target Array in the Given Order
    static int[] targetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            list.add(index[i], nums[i]);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    // Q8 Check if a given string is pangram
    static boolean isPangram(String value) {
        Set<Character> letters = new HashSet<>();
        for (char letter : value.toCharArray()) {
            letters.add(letter);
        }

        return letters.size() > 26;
    }

    // Q9 https://leetcode.com/problems/count-items-matching-a-rule/
    static int countMatches(List<List<String>> items, String ruleKey,
                            String ruleValue) {
        int k = -1, count = 0;

        if (ruleKey.equals("type"))
            k = 0;
        if (ruleKey.equals("color"))
            k = 1;
        if (ruleKey.equals("name"))
            k = 2;

        for (List<String> item : items) {
            if (item.get(k).equals(ruleValue))
                count++;
        }
        return count;
    }

    // Q10 https://leetcode.com/problems/flipping-an-image/
    // To invert an image/array means each 0 is replaced by 1, and each 1
    // is replaced by 0. Inverting [0,1,1] results in [1,0,0].
    // First reverse it and then invert it
    static int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int[][] flipped = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flipped[i][j] = 1 - image[i][n - j - 1];
            }
        }
        return flipped;

    }
}
