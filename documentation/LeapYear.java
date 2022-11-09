package documentation;

import java.util.Scanner;

import static documentation.Document.scanner;

public class LeapYear {

//    private static Scanner scanner1=new Scanner(System.in);


    public static boolean isLeapYear(int year) {

        boolean isLeap = false;
        boolean param = year >= 1 && year <= 9999;

        if (param) {
            if (year % 4 == 0) {
                if (year % 100 != 0)
                    isLeap = year % 400 == 0;
                else
                    isLeap = true;
            }
        }
        return isLeap;
    }

    // Compare doubles if equal by three decimal places.
    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        if (num1 < 0 && num2 < 0) {
            double one = Math.ceil(num1 * 1000) / 1000;
            double two = Math.ceil(num2 * 1000) / 1000;
            return one == two;
        } else if (num1 > 0 && num2 > 0) {
            double one = Math.floor(num1 * 1000) / 1000;
            double two = Math.floor(num2 * 1000) / 1000;
            return one == two;
        } else
            return num1 == num2;
    }

    public static boolean hasEqualSum(int num1, int num2, int num3) {
        return num1 + num2 == num3;
    }

    public static boolean hasTeen(int teen1, int teen2, int teen3) {
        boolean isTeen = false;
        if (isTeen(teen1)) {
            isTeen = true;
        } else if (isTeen(teen2)) {
            isTeen = true;
        } else isTeen = isTeen(teen3);
        return isTeen;
    }

    public static boolean isTeen(int teen) {
        return teen >= 13 && teen <= 19;
    }

    public static double area(double radius) {
        if (radius < 0)
            return -1.0;
        else
            return Math.PI * (radius * radius);
    }

    public static double area(double x, double y) {
        if (x < 0 || y < 0)
            return -1.0;
        else
            return x * y;
    }

    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
        } else {
            long years = (minutes / (365 * 24 * 60));
            long remainingDays = ((minutes / (60 * 24)) % 365);
            System.out.println(minutes + " min = " + years + " y and " + remainingDays + " d");
        }
    }

    public static void printEqual(int param1, int param2, int param3) {
        if (param1 < 0 || param2 < 0 || param3 < 0) {
            System.out.println("Invalid Value");
        } else if (param2 == param3 && param1 == param2) {
            System.out.println("All numbers are equal");
        } else if (param1 == param2 || param2 == param3 || param3 == param1) {
            System.out.println("Neither all are equal or different");
        } else {
            System.out.println("All numbers are different");
        }
    }

    // TODO: This is extremely confusing!! I will come back to it.
    public static boolean isCatPlaying(boolean summer, int temperature) {
        if (temperature >= 25 && temperature <= 35) {
            return true;
        } else
            return (summer) && temperature >= 25 && temperature <= 45;
    }


    private static int readInteger(){
        Scanner scanner1=new Scanner(System.in);
        System.out.println("Enter a number: ");
        scanner1.nextLine();
        return scanner1.nextInt();
    }

    private static int[] readElements(int read){
        int[] array=new int[read];
        for (int i=0; i<array.length; i++){
            int integer = readInteger();
            array[i]=integer;
        }
        return array;
    }
    private static int[] readInts(int counts) {

        int[] array = new int[counts];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter a number ");
            int number = scanner.nextInt();
            scanner.nextLine();
            array[i] = number;
        }
        return array;
    }

    private static int findMin(int[] array) {
        int lowest = array[0];
        for (int i : array) {
            if (i < array[i])
                lowest = array[i];
        }
        return lowest;
    }
}
