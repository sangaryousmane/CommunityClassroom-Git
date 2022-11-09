package chapter7arrays;

import java.util.HashMap;
import java.util.Map;

public class TeleMarketing {

    /*
    Two arrays of String datatype
    One for names and other for numbers
    User should enter first characters to search and the name matching those should be outputted
     */


    static void marketing(String userInput) throws Exception {
        Map<String, String> info = new HashMap<>();
        info.put("John Paul", "555-1785");
        if (info.containsKey(userInput))
            System.out.println(info.keySet() + " : " + info.get(userInput));
        else
            throw new Exception("Sorry, name not found in list.");
    }

    static void sumInString(String numbers){
        String[] number=numbers.split("[,]");
        int sum=0;
        for (String num: number){
            sum +=Integer.parseInt(num);
        }
        System.out.println(sum);
    }

    static void sumOfDigits(String numbers) {
        String[] number = numbers.split("");
        int sumDigit = 0;
        int lowest = 0;
        int highest = 0;
        for (int i = 0; i < number.length; i++) {
            int n = Integer.parseInt(number[i]);
            sumDigit += n;

            if (n > highest)
                highest = n;
            else
                lowest = n;
        }

        System.out.println("sum of digit is: "+sumDigit);
        System.out.println("Highest: "+highest);
        System.out.println("Lowest: "+lowest);

    }

    public static void main(String[] args) throws Exception {
        sumInString("1,5,4,3");
    }
}
