package documentation;

public class Palindrome {

    public static void main(String[] args) {
        if (isPalindrome(707))
            System.out.println("It's palindrome");
        else
            System.out.println("It's not palindrome");
    }
    public static boolean isPalindrome(int number) {
        int reverse = 0;
        int num = number;

        while (number != 0) {
            int lastDigit = number % 10;
            reverse = (reverse * 10) + lastDigit;
            number /= 10;
        }
        return num == reverse;
    }
}
