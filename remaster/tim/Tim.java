package remaster.tim;

import java.util.Arrays;

public class Tim {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 7, 11, 9, 15};
        System.out.println("Array: " + Arrays.toString(arr));
        reverse(arr);
        System.out.println("Reversed array: " + Arrays.toString(arr));
    }

    private static void reverse(int[] array) {
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;

        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }
    }

}
