package remaster;

// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
public class InfiniteArray {

    public static void main(String[] args) {
        System.out.println(ans());
    }

    static int ans() {
        int[] arr = {2, 5, 7, 9, 10, 12, 15, 16, 18, 20, 24, 28, 32, 35};
        int target = 35;
        return infinite(arr, target);
    }

    // Find the position of an element in a sorted infinite array
    static int infinite(int[] arr, int target) {
        int start = 0, end = 1;

        while (target > arr[end]) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2; // Compound the array by two steps
            start = temp;
        }
        return positionInfiniteArray(arr, target, start, end);
    }

    static int positionInfiniteArray(int[] array, int target, int start, int end) {

        while (start <= end) {
            int middle = start + (end - start) / 2;


            if (target < array[middle])
                end = middle - 1;
            else if (target > array[middle])
                start = middle + 1;
            else
                return middle;
        }
        return -1;
    }
}
