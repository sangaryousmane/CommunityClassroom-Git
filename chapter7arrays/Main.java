package chapter7arrays;
import java.util.Arrays;

import static documentation.Document.scanner;

public class Main {

    public static void main(String[] args) {
        driversExam();
    }

    static void testRainFall() {
        double[] months = {30, 31, 40, 1, 2, 34, 4, 5, 6, 15, 33, 100};

        Rainfall rainfall = new Rainfall(months);
        System.out.println(" The index of the month is: " + rainfall.averageYearlyRainfall());
    }

    static void largerThanN(int[] arr, int n) {
        if (arr.length == 0)
            System.out.println(-1);

        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if (element > n) {
                System.out.println(element);
            }
        }
    }

    static void driversExam() {
        char[] studentAnswers = new char[20];
        System.out.println("*************************************************");
        System.out.println("Driver's lesson exam ");
        System.out.println("Total is 20 questions, please answer in A,B,C,D ");
        System.out.println("*************************************************");

        System.out.println("Please enter the answer of the following questions: ");
        for (int i = 0; i < studentAnswers.length; i++) {
            System.out.print((i + 1) + ": ");
            studentAnswers[i] = scanner.nextLine().charAt(0);
        }

        // Initialize Object
        DriverExam exam = new DriverExam(studentAnswers);
        System.out.println("*************************************************");
        System.out.println("RESULTS: ");
        System.out.println("Total correct answers: " + exam.totalCorrect());
        System.out.println("Total incorrect answers: " + exam.totalInCorrect());

        int[] missed = exam.questionsMissed();
        if (missed.length != 0)
            System.out.println("The following has incorrect answers" + Arrays.toString(missed));
        else
            System.out.println("All the answers are correct: ");


        System.out.println("The passing mark is at 65% ");
        if (exam.hasPassed())
            System.out.println("Congrats, you have passed the exam.😎😎😎");
        else
            System.out.println("Sorry! you failed.");
    }
}
