package chapter7arrays;

public class D_2Arrays {
    private int[][] nums;

    public D_2Arrays(int[][] nums) {
        this.nums = nums;
    }

    public int getTotal() {
        int total = 0;
        for (int[] row : nums) {
            for (int col : row) {
                total += col;
            }
        }
        return total;
    }

    public double getAverage() {
        return (double) getTotal() / nums.length;
    }

    // Sum in a given row
    public int getRowTotal(int[][] rows, int subscript) {
        int n = rows.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += rows[subscript][i];
        }
        return total;
    }

    // Sum in a given column
    public int getColumnTotal(int[][] col, int subscript) {
        int n = col.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += col[i][subscript];
        }
        return total;
    }

    public int getHighestInRow(int[][] arr, int subscript) {
        int highest = arr[0][0];

        for (int row = 0; row < nums.length; row++) {
            if (nums[subscript][row] > highest)
                highest = nums[subscript][row];
        }
        return highest;

    }

    public int getLowestInRow(int[][] arr, int subscript) {
        int lowest = arr[0][0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[subscript][i] < lowest)
                lowest = arr[subscript][i];
        }
        return lowest;
    }

    public static void main(String[] args) {
        int[][] arr =
                {{2, 1, 1},
                        {3, 13, 2},
                        {1, 2, 3}};
        D_2Arrays d_2Arrays = new D_2Arrays(arr);
        System.out.println(d_2Arrays.getLowestInRow(arr, 1));
    }

}
