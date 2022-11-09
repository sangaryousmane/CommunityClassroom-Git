package documentation;

import static documentation.Document.scanner;

public class Quote {

    private static final double PRICE = 99.0;

    public static void main(String[] args) {
//        printMegaBytesAndKiloBytes(-1024);
//        System.out.println(shouldWakeUp(true, 8));
//        System.out.println(leapYear(2000));
        System.out.println(LeapYear.isCatPlaying(true, 10));

    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else {
            int megabytes = kiloBytes / 1024;
            int remainingBytes = kiloBytes % 1024;
            System.out.println(kiloBytes + " KB = " + megabytes + " MB and " + remainingBytes + " KB");
        }
    }

    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {

        if (hourOfDay < 8 || hourOfDay > 22) {
            barking = true;
        }
        if (hourOfDay < 0 || hourOfDay > 23) {
            barking = false;
        }
        return barking;
    }

    static void magicDate(int month, int day, int year) {
        boolean isMagic = (month * day) == year;
        if (isMagic) {
            System.out.println("The year is magic.");
        } else {
            System.out.println("Not magic year.");
        }

    }

    static double square(double number) {
        return number * number;
    }

    static void bmi(double weight, double height) {
        // BMI = weight * 703 /square(height);
        double bodyMass = weight * (703 / square(height));

        if (bodyMass >= 18.5 && bodyMass <= 25) {
            System.out.println("You have an optimal weight.");
        } else if (bodyMass < 18.5) {
            System.out.println("You're underweight.");
        } else if (bodyMass > 25) {
            System.out.println("Overweight.");
        } else {
            System.out.println("Please consult your doctor.");
        }
    }

    static void testScoreAverage() {

        System.out.println("Enter grade 1: ");
        double grade1 = scanner.nextDouble();

        System.out.println("Enter grade 2: ");
        double grade2 = scanner.nextDouble();

        System.out.println("Enter grade 3: ");
        double grade3 = scanner.nextDouble();

        double average = (grade1 + grade2 + grade3) / 3;

        System.out.println("Test Score              Average");
        System.out.println("_______________________________");

        if (average >= 90 && average <= 100) {
            System.out.println("90-100               A");
        } else if (average >= 80 && average <= 89) {
            System.out.println("80-89                B");
        } else if (average >= 70 && average <= 79) {
            System.out.println("70-79                C");
        } else if (average >= 60 && average <= 69) {
            System.out.println("60-69                D");
        } else {
            System.out.println("Below 60             F");
        }
    }

    static void sortedNames() {
        System.out.println("Enter name 1: ");
        String name1 = scanner.nextLine();

        System.out.println("Enter name 2: ");
        String name2 = scanner.nextLine();

        System.out.println("Enter name 3: ");
        String name3 = scanner.nextLine();

        System.out.println();
    }

    static double sales(double quantity) {
        return (quantity * PRICE) - (quantity * PRICE * (PRICE / 100));
    }

    static double discount(double quantity) {
        return (quantity / 100) * PRICE;
    }

    static void softwareSales(double quantity) {

        if (quantity >= 10 && quantity < 20) {
            System.out.println("Total sales is " + sales(quantity) + " Quantity is: " + discount(quantity));
        }
        if (quantity >= 20 && quantity < 49) {
            System.out.println("Total sales is " + sales(quantity) + " Quantity is: " + discount(quantity));
        }
        if (quantity >= 50 && quantity < 99) {
            System.out.println("Total sales is " + sales(quantity) + " Quantity is: " + discount(quantity));
        }
        if (quantity > 100) {
            System.out.println("Total sales is " + sales(quantity) + " Quantity is: " + discount(quantity));
        }


    }

    static void testingSentinels() {
        int points; // This is the individual point
        int totalPoints = 0; // This is the Accumulator

        System.out.println("""
                Enter the number of points your team has earned,
                enter -1 when finished.""");
        System.out.println();

        System.out.println("Enter first point or -1 to terminate.");
        points = scanner.nextInt();

        while (points != -1) {
            totalPoints += points;

            System.out.println("Enter game point or -1 to terminate.");
            points = scanner.nextInt();
        }

        System.out.println("The total Points is: " + totalPoints);
    }

    /*
    An inner loop goes through all of its operation for each iteration of an outer loop.
     */

    static void clock() {
        for (int hours = 1; hours <= 12; hours++) {
            for (int minutes = 0; minutes <= 59; minutes++) {
                for (int seconds = 0; seconds <= 59; seconds++) {
                    System.out.printf("%02d:%02d:%02d\n", hours, minutes, seconds);
                }
            }
        }
        System.exit(0);
    }

    public static boolean leapYear(int year) {
        boolean isLeapYear = false;

        boolean param = year >= 1 && year <= 9999;
        if (param) {
            if (year % 4 == 0) {
                if (year % 100 != 0) {
                    isLeapYear = year % 400 == 0;
                } else {
                    isLeapYear = true;
                }
            }
        }
        return isLeapYear;
    }
}


/*
The brute force solution is simply to calculate the total distance
for every possible route and then select the shortest one.
 */
