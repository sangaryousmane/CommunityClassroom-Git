package kunalDsaSolution;
// https://www.youtube.com/watch?v=fAAZixBzIAI

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArraysModule {

    // 1. https://leetcode.com/problems/build-array-from-permutation/
    static int buildArray() {
        return 1;
    }

    // 2. https://leetcode.com/problems/concatenation-of-array/
    static int[] concatOfArrays(int[] array) {
        int n = array.length;
        int[] answer = new int[2 * n];

        for (int i = 0; i < array.length; i++) {
            answer[i] = array[i];
            answer[i + n] = array[i];
        }
        return answer;
    }

    // 3. https://leetcode.com/problems/running-sum-of-1d-array/
    static int[] runningSumOf1DArray(int[] arr) {

        int sum = 0;
        int[] runningSum = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            runningSum[i] = sum;
        }
        return runningSum;
    }

    // 4. https://leetcode.com/problems/richest-customer-wealth/
    static int richesCustomerWealth(int[][] accounts) {
        int maxWealth = accounts[0][0];

        for (int person = 0; person < accounts.length; person++) {
            int sumOfWealth = 0;
            for (int account = 0; account < accounts[person].length; account++) {
                sumOfWealth += accounts[person][account];
            }
            if (sumOfWealth > maxWealth)
                maxWealth = sumOfWealth;
        }
        return maxWealth;
    }

    // 5. https://leetcode.com/problems/shuffle-the-array/
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2 * n];

        for (int i = 0; i < nums.length / 2; i++) {
            arr[2 * i] = nums[i];
            arr[2 * i + 1] = nums[i + nums.length / 2];
        }
        return arr;

    }

    // 6. https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/submissions/
    public static List<Boolean> kidsWithTheGreatestNumberOfCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();

        int maxNumOfCandy = candies[0];
        for (int j : candies) {
            if (j > maxNumOfCandy) {
                maxNumOfCandy = j;
            }
        }

        for (int candy : candies) {
            if (candy + extraCandies >= maxNumOfCandy)
                list.add(true);
            else
                list.add(false);
        }
        return list;
    }


    static List<Boolean> richKids(int[] candies, int extra) {
        List<Boolean> kids = new ArrayList<>();

        int max = candies[0];
        for (int candy = 0; candy < candies.length; candy++) {
            int element = candies[candy];
            if (element > max)
                max = element;
        }
        for (int index = 0; index < candies.length; index++) {
            if (candies[index] + extra >= max)
                kids.add(true);
            else
                kids.add(false);
        }
        return kids;
    }

    // 7. https://leetcode.com/problems/number-of-good-pairs/
    static int numberOfGoodPairs(int[] array) {
        if (array == null)
            return -1;

        int numbOfGoodPairs = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j])
                    numbOfGoodPairs++;
            }
        }
        return numbOfGoodPairs;
    }

    static int pairs(int[] array) {
        if (array.length == 0)
            return -1;

        int pairs = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                boolean isPairs = array[i] == array[j] && j > i;
                if (isPairs)
                    pairs++;
            }
        }
        return pairs;
    }

    // 8. https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/discuss/2597577/Simple-Java-Solution
    static int[] smallerThanCurrent(int[] nums) {
        int count = 0;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            int num = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                if (nums[j] < num) {
                    count += 1;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    // This is hard
    // 9. https://leetcode.com/problems/max-value-of-equation/
    static int findMaxValueOfEquation(int[][] points, int k) {
        return 1;
    }

    // 10. https://leetcode.com/problems/two-sum/
    static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int element = nums[i] + nums[j];
                if (element == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;
    }

    // Recursive Multiplication
    // The goal is: for x to be added to itself y times.
    // eg: x = 5, y=3. 5+5+5 =15
    static int recursiveMultiplication(int x, int y) {

        if (y == 0)
            return 0;
        else if (y < 0)
            return -(x - recursiveMultiplication(x, y + 1));
        else
            return x + recursiveMultiplication(x, y - 1);
    }

    static int recur(int a, int b) {
        if (b == 0)
            return 0;
        else if (b < 0)
            return -(a - recur(a, b + 1));
        else
            return a + recur(a, b - 1);
    }


    // Write a recursive method that accepts a string as its argument and prints the string in reverse order
    static void stringReverse(String text) {

        if (text.length() == 0) {
            System.out.println(text);
        } else {
            int endIndex = text.length() - 1;
            System.out.print(text.charAt(endIndex));
            stringReverse(text.substring(0, endIndex));
        }
    }

    // Write a method named maxElement using recursion, which returns the largest value in an array that is passed as an argument
    static int maxLength(int[] arr, int length) {
        if (length == 1) {
            return arr[0];
        } else {
            return Math.max(arr[length - 1], maxLength(arr, length - 1));
        }
    }

    // Write a boolean method that uses recursion to determine whether a String argument is a palindrome
    static boolean isPal(String value, int start, int end) {
        if (start == end)
            return true;

        if (value.charAt(0) != value.charAt(value.length() - 1))
            return false;

        if (start < end + 1)
            return isPal(value, start + 1, end - 1);

        return true;
    }

    static boolean isPalindrome(String text) {
        if (text.length() == 0) {
            return true;
        } else {
            return isPal(text, 0, text.length() - 1);
        }
    }

    // Given a string calculate length of the string using recursion.
    static int lengthOfString(String value) {
        if (value.equals(""))
            return -1;
        return lengthOfString(value.substring(1)) + 1;
    }

    // Write a method that uses recursion to raise a number to a power. The method should accept two arguments.
    static int power(int base, int exponent) {
        if (exponent != 0)
            return base * power(base, exponent - 1);
        return 1;
    }

    // Write a method that accepts an integer argument and returns the sum of all the integers
    // from 1 up to the number passed as an argument
    static int sumOfNumber(int number) {

        if (number <= 1)
            return number;
        return number + sumOfNumber(number - 1);
    }

    // Iterative sum of numbers
    static int sum(int number) {
        int sum = 0;
        int index = 0;
        while (index <= number) {
            sum += index;
            index++;
        }
        return sum;
    }

    // Ackermann's functions
    // One tends to go DOWN THE RABBIT HOLE as the input of the program increases..
    static int ackermann(int m, int n) {
        if (m == 0)
            return n + 1;
        if (n == 0)
            return ackermann(m - 1, 1);
        return ackermann(m - 1, ackermann(m, n - 1));
    }

    /*
     ackermann's function. Pseudocode
     Let A(M,N)
     if M=0 then return N+1
     if N=0 then return ackerman(M-1,1)
     if M>0 && N>0 then return ackerman(M-1, ackerman(M, N-1))
     */
    static void towerOfHanoi(int num, int fromPeg, int toPeg, int temPeg) {

        if (num > 0) {
            towerOfHanoi(num - 1, fromPeg, temPeg, toPeg); // 1,2,3
            System.out.println("Move disk " + num + " from Peg " + fromPeg + " to Peg " + toPeg);
            towerOfHanoi(num - 1, temPeg, toPeg, fromPeg); // 2, 3, 1
        }
    }

    // factorial
    static int factorial(int n) {
        if (n == 0)
            return 1;

        return n * factorial(n - 1);
    }

    // 11. https://leetcode.com/problems/create-target-array-in-the-given-order/
    static int[] targetArray(int[] nums, int[] index) {
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            temp.add(index[i], nums[i]);
        }
        int[] target = new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
            target[j] = temp.get(j);
        }
        return target;
    }

    // 12. https://leetcode.com/problems/check-if-the-sentence-is-pangram/
    // Solution #1 Using set
    // Sets takes valid contents only.
    static boolean isPangram1(String text) {
        Set<Character> alphabet = new HashSet<>();
        for (char i : text.toCharArray()) {
            alphabet.add(i);
        }
        return alphabet.size() == 26;
    }

    // Solution #2 using
    // The ASCII letters for lower case range from 97-122
    static boolean isPangram2(String sentence) {

        for (int index = 97; index <= 122; index++) {
            if (sentence.indexOf((char) index) == -1)
                return false;
        }
        return true;
    }

    // Print all even numbers in an array
    static void evenNumbers(int[] arr) {
        if (arr == null)
            throw new NullPointerException("Sorry, array can't be null.");


        System.out.println("Even numbers below: ");
        for (int i : arr) {
            if (i % 2 == 0)
                System.out.println(i + " ");
        }
        System.out.println();
        System.out.println("Odd Numbers below");
        for (int j : arr) {
            if (j % 2 != 0)
                System.out.println(j + " ");
        }
    }

    // 13. https://leetcode.com/problems/find-the-highest-altitude/
    static int largestAltitude(int[] gain) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < gain.length; i++) {
            sum = sum + gain[i];
            if (sum > max)
                max = sum;
        }
        return max;
    }

    static int largestAltitude2(int[] gain) {
        int current = 0;
        int max = 0;
        for (int i = 0; i < gain.length; i++) {
            current += gain[i];
            if (current > max)
                max = current;
        }
        return max;
    }

    // 14. https://leetcode.com/problems/flipping-an-image/submissions/
    public int[][] flipAndInvertImage(int[][] image) {
        int c = image[0].length;

        for (int[] row : image) {
            for (int i = 0; i < (c + 1) / 2; ++i) {
                int temp = row[i];
                row[i] = 1 - row[c - 1 - i];
                row[c - 1 - i] = 1 - temp;
            }
        }
        return image;
    }
}
