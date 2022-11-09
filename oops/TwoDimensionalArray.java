package oops;

public class TwoDimensionalArray {

    public static void main(String[] args) {
//        int[][] array = {{3, 2, 6, 4}, {15, 30, 20}};
//        int [][][] cinema=new int[50][10][25];
//        int[][][] array = {{{3, 2, 6, 4}, {15, 30, 20}, {1, 2, 3}}};

        int[] print={100, 29};
        varg(print);
//        array2D(array);

//        for (int[][] i: array)
//            for (int[] j: i)
//                for (int k: j)
//                    System.out.println(k);

    }

    static void array2D(int[][] array) {

        for (int rows = 0; rows < array.length; rows++) {
            for (int cols = 0; cols < array[rows].length; cols++) {
                System.out.println(array[rows][cols] + " ");
            }
        }
    }

    static int sumOf2DArray(int[][] array) {
        int total = 0;

        for (int[] inner : array) {
            for (int outer : inner) {
                total += outer;
            }
        }
        return total;
    }

    static void varg(int... array){
        int total=0;

        for (int n: array){
            total +=n;
        }
        System.out.println(total);
    }
}
