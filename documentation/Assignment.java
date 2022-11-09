package documentation;

public class Assignment {

    public static void main(String[] args) {
        System.out.println(isArmstrong(370));

        for (int i = 100; i < 1000; i++) {
            if (isArmstrong(i))
                System.out.println(i + " ");
        }

    }

    static {
        System.out.println("Hello world..");
    }

    static void evenOrOdd(int number) {
        if (number % 2 == 0)
            System.out.println(number + " is even.");
        else
            System.out.println(number + " is odd.");
    }

    public static double simpleInterest(int P, int R, int T) {
        return (P * R * T) / 100.0;
    }

    static void largest(int a, int b) {
        if (a > b)
            System.out.println(a + " is larger than " + b);
        else
            System.out.println(b + " is larger than " + a);
    }

    static boolean isPalindromic(String value) {
        int left = 0, right = value.length() - 1;

        while (left < right) {
            if (value.charAt(left) != value.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // A rhombus is a polygon, who's all four sides is equal in length and opposite side is parallel.
    static double areaOfRhombus(double d1, double d2) {
        // area = d1*d2/2;
        return (d1 * d2) / 2.0;
    }

    static boolean isArmstrong(int number) {
        int sum = 0;
        int original = number;

        while (number > 0) {
            int remainder = number % 10;
            number /= 10;
            sum += cube(remainder);
        }
        return sum == original;
    }

    static int cube(int a) {
        return a * a * a;
    }
}
