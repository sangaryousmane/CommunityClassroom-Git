package files;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

import static documentation.Document.scanner;

public class fileWriter {

    public static void main(String[] args) throws FileNotFoundException {
        sumOfNumbers();
    }

    static void readFromFile() {
        try {
            File file = new File("prices.txt");
            scanner = new Scanner(file);

            String fileContent = scanner.nextLine();
            System.out.println(fileContent);
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter("prices.txt", true);
            PrintWriter writer = new PrintWriter(fileWriter);
            writer.print("These are prices of PCs: $3000, $4000 et al.");
            writer.print("These are prices of PCs: $3000, $4000 et al.");
            writer.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    static void readFileInput() throws FileNotFoundException {
        System.out.println("Please enter the file name: ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);


        // The hasNext() method reads the file contents until nothing is left within.
        if (file.exists()) {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String content = scanner.nextLine();
                System.out.println(content);
            }
            scanner.close();
        }
        throw new FileNotFoundException("Sorry buddy!! the file isn't found...");

    }

    static void mathTutor() {

        Random random1 = new Random();
        Random random2 = new Random();
        int number1 = random1.nextInt(100);
        int number2 = random2.nextInt(100);
        int sum = number1 + number2;
        System.out.println(number1 + " + " + number2 + " ? ");
        System.out.println();
        System.out.println("Please enter your answer: ");
        int answers = scanner.nextInt();

        while (answers != -1) {
            if (answers == sum) {
                System.out.println("That's fantastic!!! You got it right");
                System.exit(0);
            } else {
                System.out.println("Sorry!! Your answer is wrong, the correct answer is: " + sum);
                System.out.println(number1 + " + " + number2 + " ? ");
                System.out.println("Enter another answer: ");
                answers = scanner.nextInt();
            }
        }
        scanner.close();
        System.exit(0);
    }

    static void rollingDice() {
        int dice1, dice2;
        String repeat = "Y";

        Random random1 = new Random();
        Random random2 = new Random();

        while (repeat.equalsIgnoreCase("y")) {
            System.out.println("Dice rolling......");
            dice1 = random1.nextInt(6) + 1;
            dice2 = random2.nextInt(6) + 1;

            System.out.println("Their values are: ");
            System.out.println(dice1 + " " + dice2);

            System.out.println("Enter another value: ");
            repeat = scanner.nextLine();
        }


    }

    static void sumOfNumbers() {
        int sum = 0;
        System.out.println("Kindly enter a number: ");
        int input = scanner.nextInt();
        for (int i = 1; i <= input; i++) {
            sum += i;
        }
        System.out.println(sum);
    }


}
