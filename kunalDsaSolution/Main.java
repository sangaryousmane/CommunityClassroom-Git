package kunalDsaSolution;

import kunalDsaSolution.searching.LinearSearch;

import java.util.Arrays;
import java.util.List;
// Web Scrapping: https://www.youtube.com/watch?v=XVv6mJpFOb0

public class Main {
    public static void main(String[] args) {
        int[][] arr = {
                {2, 8, 7},
                {7, 11, 3},
                {14, 9, 5},
                {10, 12, 3, 10},
                {3, 40, 1, 8, 5}
        };
        int[] arr_1D = {3, 2, 4, 5, 18, 48, 10, -10};
        System.out.println(LinearSearch.evenNumberOfDigits(arr_1D));
        int[] max = {3, 4, 0, 2, 31, 100};
        int[] testArray = {-5,1,5,0,-7}; // (0, 3), (0,4), (3,4), (2,5), (5,6)
        int[] index = {0, 1, 2, 2, 1};
        int[][] testArray2 = {{1, 5}, {7, 3}, {3, 5}};
//        int result=ArraysModule.maxLength(max, max.length);
//        System.out.println(result);
//        System.out.println(ArraysModule.isPangram2("familiar"));
//        System.out.println(ArraysModule.ackermann(0,10)); // O(1)
//        int result=ArraysModule.largestAltitude2(testArray);
//        System.out.println(result);
    }
}
