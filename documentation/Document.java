/**
 * The Customary and effective usage of the java programming language
 * EXTREME PROGRAMMING
 * - A cross-reference is a note in a book which tells you that there is relevant
 * or more detailed information in another part of the book
 * - Package-Private
 * - A Programmer who writes a program that contains API is
 * regarded as a user of that API.
 * - A Class whose implementation uses an API is a client of that
 * API.
 * - Classes, interfaces, constructors, members, and serialized forms are collectively known as API elements.
 */
package documentation;

import javax.swing.*;
import java.util.Scanner;

public class Document {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        testingSwitch();
    }


    static int OddArray(int[] array) {
        if (array.length % 2 == 0) {
            return 0;
        }

        int midIndex = array.length / 2;
        int middleElement = array[midIndex];

        for (int i = 0; i < array.length; i++) {
            if (i != array[i] && middleElement >= array[i]) {
                return 0;
            }
        }
        return 1;
    }

    public static void percentage() {
        double speed = 20, time = 10, distance;
        distance = speed * time;
        System.out.println("Distance is: " + distance);
    }

    static double percent(double number) {
        return number / 100;
    }

    // At times, some stores always have promos, hence, discounts on items
    static double discountSalesPrice(double regularPrice, double salesPromo) {
        double discount = percent(salesPromo) * regularPrice;
        return discount - regularPrice;
    }

    static void scannerTrial() {
        String firstName, lastName, another;

        System.out.println("What is your given name?");
        firstName = scanner.nextLine();

        System.out.println("What is your surname?");
        lastName = scanner.nextLine();

        System.out.println("Full Name: " + firstName + " " + lastName);

        System.out.println("Do you wanna continue? (Y = YES, N=NO)");
        another = scanner.nextLine();
        char unit = another.charAt(0);
        if (unit == 'Y') {
            scannerTrial();
        } else {
            scanner.close();
            System.exit(0);
        }

    }

    static void playingWithDialogs() {
        String input = JOptionPane.showInputDialog("Price ?");
        double hourlyPayRate = Double.parseDouble(input);

        JOptionPane.showMessageDialog(null,
                "Your daily wage in 10hrs is: " + hourlyPayRate * 10.0);
        System.exit(0);
    }

    static void nameIntDouble() {
        System.out.println("Please enter your age:");
        int age = scanner.nextInt();

        System.out.println("Please enter your annual income:");
        double annualIncome = scanner.nextDouble();

        scanner.nextLine();

        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();

        System.out.println("My name is: " + name + " My age is: " + age +
                " and I hope to earn " + annualIncome + " per year.");

    }

    static void eastCoastSales() {
        double percentage = (46000000.0) * 62.0 / 100;
        double inSales = 46000000.0 - percentage;
        System.out.println(inSales);

    }

    static void landCalculation() {
        long acreOfLand = 43560L, acreInTrack = 389767L;
        System.out.println("The Number of acre is: " + acreInTrack / acreOfLand);
    }

    static void decisionStructure(int salary, int yearOnJob) {
        if (salary >= 30000) {
            if (yearOnJob > 2)
                System.out.println("You're qualify");
            else
                System.out.println("You're not qualify");
        } else {
            System.out.println("You must earn at least 30,0000 per year to qualify");
        }
    }

    static void greaterOfThem(int a, int b) {
        if (a > 10) {
            if (b > 20) {
                if (a > b)
                    System.out.println(a);
                else
                    System.out.println(b);
            }


        } else {
            System.exit(0);
        }
    }

    static void comparison(String greet) {
        if ("hello".equals(greet)) {
            System.out.println("They're same");
        } else {
            System.out.println("They're different");
        }
    }

    static void initial() {
        String firstName = "Ousmane",
                middleName = "Laye",
                lastName = "Sangary";
        char firstInitial = firstName.charAt(0);
        char middleInitial = middleName.charAt(0);
        char lastInitial = lastName.charAt(0);
        System.out.println(middleInitial + "." + firstInitial + " " + lastInitial);
    }

    static void pattern(int n) {

        Patterns.star(n);

    }

    static void restaurantBill(double mealCharge) {

        if (mealCharge <=0){
            System.out.println("Mula finish");
        }
        else {
            double tax = mealCharge - (6.75 / 100);
            double tip = mealCharge + (double) (20 / 100);

            System.out.println("Total Bill: " + Math.round(tax + tip));
            System.out.println("Tax amount: $" + Math.round(tax));
            System.out.println("Tip amount: $" + Math.round(tip));
        }
    }

    static void madLip(){

        System.out.println("ENTER YOUR NAME: ");
        String NAME=scanner.nextLine();

        System.out.println("ENTER YOUR AGE: ");
        int AGE=scanner.nextInt();

        scanner.nextLine();

        System.out.println("ENTER YOUR COLLEGE: ");
        String COLLEGE=scanner.nextLine();

        System.out.println("Enter your profession: ");
        String PROFESSION=scanner.nextLine();

        System.out.println("Enter your animal: ");
        String ANIMAL=scanner.nextLine();

        System.out.println("Enter your pet name: ");
        String PETNAME=scanner.nextLine();

        System.out.println("Enter your city: ");
        String CITY=scanner.nextLine();


        System.out.println("There once was a person named "+ NAME+" who lived in "+CITY+". At the age of "+AGE+",\n" +
                NAME+" went to college at "+COLLEGE+". "+NAME+" graduated and went to work as a\n" +
                PROFESSION+". Then, "+NAME+" adopted a(n) "+ANIMAL+" named "+PETNAME+". They both lived\n" +
                "happily ever after!");
        scanner.close();
        System.exit(0);
    }

    static void testingSwitch(){
        System.out.println("Enter any number: ");
        int testCase=scanner.nextInt();

        switch (testCase){
            case 1 -> System.out.println("You entered 1");
            case 2 -> System.out.println("You entered 2");
            case 3 -> System.out.println("You entered 3");
            case 4 -> System.out.println("You entered 4");
            case 5 -> System.out.println("You entered 5");
            default -> System.out.println("Invalid input or number not available.");
        }
        scanner.close();
    }

}
