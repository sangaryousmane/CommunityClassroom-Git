package documentation;

import java.util.Arrays;

import static documentation.Document.scanner;

/**
 * - All Computer systems consist of similar hardware devices and software components
 * - The hardware components refer to the physical components that a computer is made of.
 * - A computer isn't an individual device but a system and devices
 * - (The CPU, Main Memory(RAM), output and input devices, Secondary Storage Devices).
 */
public class Basics {

    private static final int COOKIES = 40;

    public static void main(String[] args) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//        for (int i = 0; i < days.length; i++) {
//            System.out.println("Month " + (i + 1) + " has " + days[i] + " days.");
//        }

//        int[] numbers=new int[5];
//        getArray(numbers);
//        System.out.println("The array of numbers entered are: ");
//        showArray(numbers);
//        average(days);
        sort();
    }

    static void formattedString(int n) {
//        System.out.printf("Hello bro, %s\n", " Ousmane");
//        System.out.printf("The price was %,.2f back then ", 3000000.45);

//        String name=String.format("Your name is %s ", "Laye");
//        System.out.println(name);

        double number = 1234567.456;
        int isDouble = n < 1000000 ? 1 : 2;

        System.out.printf("%,.2f ", number);
    }

    static void primitiveTypes() {
        int max = Integer.MAX_VALUE;
        byte maxByte = Byte.MAX_VALUE;
        short maxShort = Short.MAX_VALUE;
        char maxChar = Character.MAX_VALUE;
        boolean maxBool = Boolean.TYPE.isPrimitive();
        float maxFloat = Float.MAX_VALUE;
        double maxDouble = Double.MAX_VALUE;

        System.out.println("MAX_INT: " + max);
        System.out.println("MAX_BYTE: " + maxByte);
        System.out.println("MAX_SHORT: " + maxShort);
        System.out.println("MAX_CHAR: " + maxChar);
        System.out.println("MAX_BOOLEAN: " + maxBool);
        System.out.println("MAX_FLOAT: " + maxFloat);
        System.out.println("MAX_DOUBLE: " + maxDouble);
    }

    static void romanNumeral(int n) {

        switch (n) {
            case 1 -> System.out.println("I");
            case 2 -> System.out.println("II");
            case 3 -> System.out.println("III");
            case 4 -> System.out.println("IV");
            case 5 -> System.out.println("V");
            case 6 -> System.out.println("VI");
            case 7 -> System.out.println("VII");
            case 8 -> System.out.println("VIII");
            case 9 -> System.out.println("IX");
            case 10 -> System.out.println("X");
            default -> System.out.println("Out of Range.");

        }
    }

    /**
     * The magic date is acquired by multiplying the month and day
     * which result will be equivalent to the year - two digit.
     */
    static void magicDates() {
        System.out.println("Enter a two digit month: ");
        int month = scanner.nextInt();

        System.out.println("Enter day: ");
        int day = scanner.nextInt();

        System.out.println("Enter year: ");
        int year = scanner.nextInt();

        if ((month * day) == year) {
            System.out.println("The date is magic");
        } else {
            System.out.println("The date isn't magic");
        }
    }

    static void pattern() {
        int length = 5;

        for (int i = 1; i <= length; i++) {
            for (int j = i; j <= length; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower triangle
        for (int i = length - 1; i >= 1; i--) {
            for (int j = length; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    static void numberOfCookieCalorie() {
        System.out.println("Enter number of Cookie: ");
        int userCookies = scanner.nextInt();
        int totalCookie = COOKIES / 10;
        int numberOfCalories = 300 * 10;
        int totalNumberOfCalories = (numberOfCalories * totalCookie) / userCookies;
        System.out.println("Number of Calorie is: " + totalNumberOfCalories + " calories");
    }

    static void milesPerGallon() {
        System.out.println("Enter miles driven: ");
        int miles = scanner.nextInt();

        System.out.println("Enter gallon of gas: ");
        int gallonOfGas = scanner.nextInt();

        System.out.println("The car's MPG is: " + (miles / gallonOfGas));
    }

    static double circuitBoardProfit() {
        System.out.println("Please enter the retail price: ");
        double retailPrice = scanner.nextDouble();

        return (40.0 / 100) * retailPrice;
    }

    /*
    Write a program that asks the user for the number of males and the number of females registered in a class.
    The program should display the percentage of males and females in the class. total student is 20.
     */
    static void studentPercentage(int males, int females) {
        double malesPercent = (males / 20.0) * 100;
        double femalesPercent = (females / 20.0) * 100;

        System.out.println("Males Percentage is: " + malesPercent + "%");
        System.out.println("Females Percentage is: " + femalesPercent + "%");

    }

    /*
    A soft drink company recently surveyed 12,467 of its customers and found that
    approximately 14 percent of those surveyed purchase one or more energy drinks per week. Of those
    customers who purchase energy drinks, approximately 64 percent of them prefer citrus flavored energy drinks.
    Write a program that displays the following:
    • The approximate number of customers in the survey who purchase one or more energy drinks per week
    • The approximate number of customers in the survey who prefer citrus-flavored energy drinks
     */
    static void energyDrinksConsumption() {
        double percentOf14 = (14.0 / 100);
        double percentOf64 = (64.0 / 100);
        int totalNumberOfCustomers = 12467;
        double customersWhoBuyDrinks = (percentOf14 * totalNumberOfCustomers);

        System.out.println("Customers purchase per week: " + Math.round(customersWhoBuyDrinks));
        System.out.println("Customers who preferred citrus juice is: " +
                Math.round(percentOf64 * customersWhoBuyDrinks));
    }

    static void massWeight(double mass) {
        double weight = mass / 9.8;

        if (weight > 100) {
            System.out.println("Too heavy.");
        } else if (weight < 10) {
            System.out.println("Too light.");
        } else {
            System.out.println("Portable.");
        }
    }

    static void ascending() {
        System.out.println("Enter name 1: ");
        String name1 = scanner.nextLine();

        System.out.println("Enter name 1: ");
        String name2 = scanner.nextLine();

        System.out.println("Enter name 1: ");
        String name3 = scanner.nextLine();

        String[] names = {name1, name2, name3};
        String start;

        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {

                if (names[i].compareTo(names[j]) > 0) {
                    start = names[i];
                    names[i] = names[j];
                    names[j] = start;
                }
            }
        }
        System.out.println("Names after swapping is: ");
        System.out.println(Arrays.asList(names));

    }

    static void asc() {
        String[] names = {"Zainab", "Hassan", "Peter", "Paul", "Priyanka", "Guma", "Alkalina", "Bruce"};
        String temp;
        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {

                if (names[i].compareTo(names[j]) > 0) {
                    temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
        System.out.println("Names in ascending: ");
        for (String name : names) {
            System.out.println(name);
        }

    }

    static void getArray(int[] values) {
        System.out.println("Enter a series of " + values.length + " numbers");

        for (int i = 0; i < values.length; i++) {
            System.out.println("Enter " + (i + 1));
            values[i] = scanner.nextInt();
        }
    }

    static void showArray(int[] array) {
        for (int j : array) {
            System.out.println(j + " ");
        }
        System.exit(0);
    }

    static void average(int[] array) {
        double total = 0.0;
        for (int i : array) {
            total += i;
        }
        double average = total / array.length;
        System.out.println("The average of this array: " + Arrays.toString(array) + " is: ");
        System.out.println(average);
    }

    // Algorithm for finding the highest element in an array.
    static void highest(int[] array) {
        int highest = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > highest) {
                highest = array[i];
            }
        }
        System.out.println("The highest number is: " + highest);
    }

    // Algorithm for finding the lowest element in an array.
    static void lowest(int[] array) {
        int lowest = array[0];
        for (int i: array)
            if (i < lowest)
                lowest =i;
        System.out.println("The lowest element is: " + lowest);
    }

    static int sum(int[] array) {
        int total = 0;
        for (int i : array)
            total += i;
        return total;
    }

    static void sortedNames() {
        String[] names = {"Andy", "Charlie", "Leslie"};
        String start;

        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].compareTo(names[j]) > 0) {
                    start = names[i];
                    names[i] = names[j];
                    names[j] = start;
                }
            }
        }
        System.out.println("Sorted Below: ");
        System.out.println(Arrays.toString(names));
    }

    static void sort() {
        String[] names = {"Andy", "Charlie", "Leslie"};
        String start;
        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].compareTo(names[j]) > 0) {
                    start = names[i];
                    names[i] = names[j];
                    names[j] = start;
                }
            }
        }
        System.out.println("Sorted Name List is: ");
        System.out.println(Arrays.asList(names));
    }

    public static int sumFirstAndLastDigit(int number) {
        if (number < 0)
            return -1;

        int lastDigit = number % 10;
        while (number >= 10) {
            number /= 10;
        }
        return number + lastDigit;
    }

    public static int getEvenDigitSum(int number) {
        if (number < 0)
            return -1;

        int sumOfEven = 0;
        int check;
        while (number != 0) {
            check = number % 10;
            if (check % 2 == 0)
                sumOfEven += check;
            number /= 10;
        }
        return sumOfEven;
    }
    // 252

    static boolean isLeap(int year){
        boolean leap=false;

        if (year % 4==0){
            if (year %100 !=0){
                if (year % 400==0){
                    leap=true;
                }
            }
            else {
                leap=true;
            }
        }
        return leap;
    }
}
