package remaster.tim;

import java.util.ArrayList;

public class GroceryList {
    private int[] myNumbers = new int[50];
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryList(String item) {
        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " item in your " +
                "grocery");

        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery Item " + (position + 1) + " has been modified.");
    }

    public void removeGroceryItem(int position) {
        groceryList.remove(groceryList.get(position));
    }

    public String findItem(String searchItem) {
        int position = groceryList.indexOf(searchItem);

        if (position >= 0)
            return groceryList.get(position);
        return null;
    }
}

