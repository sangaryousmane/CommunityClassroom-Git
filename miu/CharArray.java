package miu;

import java.util.Arrays;

public class CharArray {

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c'};
        int[] array={1,2,3,4};
        System.out.println(Arrays.toString(runningSumOfArray(array)));
    }

    static char[] char1(char[] array, int start, int length) {

        if (length + start - 1 >= array.length || length < 0 || start < 0) {
            return null;
        }
        char[] sub = new char[length];
        for (int a = start, j = 0; j < length; a++, j++) {
            sub[j] = array[a];
        }
        return sub;
    }

    // factorial using loops
    static int factorial1(int number){

        if (number==1)
            return 1;

        int accumulator=1;
        for (int index=1; index<=number; index++){
            accumulator *=index;
        }
        return accumulator;
    }

    // Factorial using recursion
    static int factorial2(int number){
        if (number == 1)
            return 1;

        return number * factorial2(number - 1);
    }

    static boolean isPalindrome(int n){
        int reverse=0;
        while (n !=0){
            int remainder= n % 10;
            reverse = (reverse*10) +remainder;
            n /=10;
        }
        return n == reverse;
    }

    static int sumOfNaturalNums(int num){
        int sum=0;

        for (int i=0; i<=num; i++){
            sum +=i;
        }
        return sum;
    }

    static void primeRange(int start, int end){
        boolean isPrime;

        for (int i=start; i<=end; i++){
            if (i==1 || i ==0)
                continue;
            isPrime=true;

            for (int j=2; j<= i /2; ++j){
                if (i % j==0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
                System.out.println(i);
        }
    }

    /*
    Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    Return the running sum of nums.
    1. initialize the sum variable with 0
    2. create new array that's equal to the length of the parameter array
    3. transverse the parameter array and get the total sum of all the elements
    4. assign the total element to the new array created.
    5. return the new array with its new content.
     */
    static int[] runningSumOfArray(int[] nums){
        int sum=0;
        int[] retSum=new int[nums.length];
        for (int index=0; index<nums.length; index++){
            sum +=nums[index];
            retSum[index]=sum;
        }
        return retSum;
    }
}
