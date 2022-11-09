package kunalDsaSolution.searching;

// Aditya Verma
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int[] array = {-8, -6, 10, 15};
        int target = 45;
        System.out.println(BinarySearch.agnostic(arr, target));

//        Arrays.sort(arr);
//        System.out.println(Arrays.binarySearch(arr, target));

//        if (simpleBinarySearch(arr,target) == isNotFound())
//            System.out.println("Sorry, the element can't be found.");
//        else
//            System.out.println("The element is found: ");
    }


    static int isNotFound() {
        return -1;
    }


    /*
    Return the index of the element if found, otherwise return -1
     */
    static int simpleBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {

            // Find the middle element
            int middle = start + (end - start) / 2;

            // compare the target with both start and end index..
            if (target < arr[middle]) { // -4 <=4
                end = middle - 1; // Go to the left if the target is less than the middle index
            } else if (target > arr[middle]) {
                start = middle + 1; // Go to the right if the target is greater than middle index.
            } else {
                // answer found
                return middle;
            }
        }
        // if element can't be found, return -1.
        return -1;
    }

    // Same as Above but using different type of loop
    static int binaryUsingForLoop(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        for (int i = start; i <= end; i++) {
            int middle = start + (end - start) / 2;

            if (target < arr[middle])
                end = middle - 1;
            else if (target > arr[middle])
                start = middle + 1;
            else
                return middle;
        }
        return -1;
    }

    // 1. Assuming that the array a[] contains N integers,
    // our task is to find the maximum among the counts of positive and negative integers in the array a[].
    static int findMaximum(int[] arr, int size) {
        int negative = 0;
        int positive = size - 1;

        while (negative <= positive) {
            int middle = negative + (positive - negative) / 2;

            // Compare the index of the middle element if positive or negative
            if (arr[middle] < 0)
                negative = middle + 1;
            else if (arr[middle] > 0)
                positive = middle - 1;
        }
        // Return the max among the count of negative and positive ints
        return Math.max(negative, size - negative);
    }

    // Order Agnostic Binary Search
    static int orderAgnosticBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // Find whether the array is sorted in ascending or descending order..
        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            int middle = start + (end - start) / 2;

            // Check if the target element is equal to the middle element index
            if (arr[middle] == target) {
                return middle;
            }

            // If the array is in ascending order, perform this.
            if (isAsc) {
                if (target < arr[middle])
                    end = middle - 1;
                else
                    start = middle + 1;
            }
            // If the array is in descending, perform this.
            else {
                if (target > arr[middle])
                    end = middle - 1;
                else
                    start = middle + 1;
            }
        }
        return -1;
    }

    static int agnostic(int[] arr, int target){
        int start=0;
        int end=arr.length - 1;

        // Check whether array is in descending or ascending order
        boolean isAsc=arr[start] < arr[end];

        for (int i=start; i<=end; i++){
            int middle=start + (end-start)/2;

            if (arr[middle]==target)
                return middle;

            // Ascending order
            if (isAsc){
                if (target < arr[middle])
                    end=middle -1;
                else
                    start=middle+1;
            }

            // Descending order
            else {
                if (target >arr[middle])
                    end = middle -1;
                else
                    start=middle+1;
            }
        }
        return -1;
    }
}
