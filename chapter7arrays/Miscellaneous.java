package chapter7arrays;

import java.util.Arrays;

public class Miscellaneous {

    public static void main(String[] args) {
        char[] n={'A','B','C','D'};
        System.out.println(wordCounter("Please bro allow me code in peace"));
        System.out.println(mostFrequent("Cheese was bought by jensen render"));
    }

    static int wordCounter(String n){
        String[] a=n.split(" ");
        return a.length;
    }

    static String arrayToString(char[] arr){
        return String.valueOf(arr);
    }

    static char mostFrequent(String value){
        int N=value.length();
        int[] ints=new int[256];

        for (int i=0; i<N; i++){
            int m=value.charAt(i);
            ints[m]++;
        }
        int max=-1;
        char result=' ';
        for (int i=0; i<N; i++){
            int m=ints[value.charAt(i)];
            if (max < m)
                max=m;
            result=value.charAt(i);
        }
        return result;
    }
}
