package remaster.tim;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice;
        printInstruction();

        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0 -> printInstruction();
                case 1 -> groceryList.printGroceryList();
                case 2 -> addItem();
                case 3 -> modifyItem();
                case 4 -> removeItem();
                case 5 -> searchForItem();
                case 6 -> {
                    quit = true;
                    System.out.println("Bye!!!");
                }
            }
        }
    }

    private static void searchForItem() {
        System.out.println("Item to search for: ");
        String searchItem = scanner.nextLine();

        if (groceryList.findItem(searchItem) != null)
            System.out.println("Found " + searchItem + " in our grocery list");
        else
            System.out.println(searchItem + " is not in the shopping list");
    }

    private static void removeItem() {
        System.out.println("Enter item number: ");
        int itemNo = scanner.nextInt();
        scanner.nextLine();
        groceryList.removeGroceryItem(itemNo);
    }

    private static void modifyItem() {
        System.out.println("Enter item number: ");
        int itemNo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter replacement item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo - 1, newItem); // we subtract 1 from user input
    }

    private static void addItem() {
        System.out.print("Please enter the grocery item: ");
        groceryList.addGroceryList(scanner.nextLine());
    }

    private static void printInstruction() {
        System.out.println("\n Press ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");
    }
}
