package exceptionhandlings;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlers1 {
    public static void main(String[] args) {
        recoverFromMErrors();
    }

    static void simpleOutOfBoundError() {
        int[] arr = {3, 10, 8, 6, 5, 6, 6};
        int sum = 0;

        try {
            for (int i : arr) {
                sum += i;
            }
            int result = sum / 0;
            System.out.println(result);
        } catch (Exception e) { // Polymorphic references to exceptions...
            System.out.printf("The error thrown by this exception is: %s ", e.getMessage());
        }
    }

    static void recoverFromMErrors() {
        int months = 0;
        String fileName = "salesData.txt";
        double oneMonth, averageTotalSales, totalSales = 0.0;

        Scanner scanner = openFile(fileName);

        while (scanner == null) {
            fileName = JOptionPane.showInputDialog(null,
                    "Sorry!! " + " the filename " + fileName + " can't be found." +
                            " Please enter another filename");
            scanner = openFile(fileName);
        }

        while (scanner.hasNext()) {
            try {
                oneMonth = scanner.nextDouble();
                totalSales += oneMonth;
                months++;
            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null, " Show non-numeric " +
                        "input shown in the file. The invalid record will be skipped.");
                scanner.nextLine();
            }
        }
        scanner.close();

        averageTotalSales = totalSales / months;
        JOptionPane.showMessageDialog(null,
                String.format("Number of months: %d , total sales: %,.2f" +
                        " average sales: %,.2f", months, totalSales, averageTotalSales));

        System.exit(0);

    }

    private static Scanner openFile(String fileName) {
        Scanner scan;

        try {
            File file = new File(fileName);
            scan = new Scanner(file);
        } catch (FileNotFoundException | NullPointerException e) {
            scan = null;
        }
        return scan;
    }
}
