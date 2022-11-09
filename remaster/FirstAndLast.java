package remaster;

import java.util.Arrays;

public class FirstAndLast {

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int[] result = firstAndLast(arr, 8);
        System.out.println(Arrays.toString(result));
    }

    // Step 1
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    static int[] firstAndLast(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = firstOccurence(nums, target);
        result[1] = lastOccurence(nums, target);
        return result;
    }

    static int firstOccurence(int[] nums, int target) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (nums[middle] < target)
                start = middle + 1;
            else if (nums[middle] > target)
                end = middle - 1;
            else {
                ans = middle;
                end = middle - 1;
            }
        }
        return ans;
    }

    static int lastOccurence(int[] nums, int target) {
        int ans = -1;
        int end = nums.length - 1;
        int start = 0;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (nums[middle] < target)
                start = middle + 1;
            else if (nums[middle] > target)
                end = middle - 1;
            else {
                ans = middle;
                start = middle + 1;
            }
        }
        return ans;
    }

    // Step 2
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    static int[] firstAndLastOccurence(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = searchRange(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = searchRange(nums, target, false);
        }
        return ans;
    }


    static int searchRange(int[] nums, int target,
                           boolean findStartIndex) {
        int ans = -1;

        int start = 0;
        int end = nums.length - 1;


        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (target < nums[middle])
                end = middle - 1;
            else if (target > nums[middle])
                start = middle + 1;
            else {
                // potential answer is found
                ans = middle;

                // check first and last occurence
                if (findStartIndex)
                    end = middle - 1;
                else
                    start = middle + 1;
            }

        }
        return ans;
    }

}
