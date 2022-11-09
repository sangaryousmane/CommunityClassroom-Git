

public class play {

    public static void main(String[] args) {
//        swapTwoNumbers(50,10);
        System.out.println(sumOfDigits(5));
    }

    static int sumOfDigits(int number) {
        int sum = 0;

        for (int i=0; i<=number; i++){
            sum +=i;
        }
        return sum;
    }

    static int reverseInt(int n) {
        int sign = 1;
        if (n < 0) {
            sign = -1;
            n = -n;
        }
        int reverse = 0;
        while (n != 0) {
            reverse = (reverse * 10) + (n % 10);
            n /= 10;
        }
        return sign * reverse;
    }

    static void swapTwoNumbers(int a, int b) {

        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = "+a + " b= "+b);
    }

}
