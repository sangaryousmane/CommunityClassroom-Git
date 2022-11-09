package chapter7arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class Month {
    private int monthNumber;

    public Month() {
        this.monthNumber = 1;
    }

    public Month(int monthNumber) {
        this.monthNumber = monthNumber;

        if (monthNumber < 0 || monthNumber > 12)
            this.monthNumber = 1;
    }

    public Month(String name) {
        switch (name) {
            case "January" -> this.monthNumber = 1;
            case "February" -> this.monthNumber = 2;
            case "March" -> this.monthNumber = 3;
            case "April" -> this.monthNumber = 4;
            case "May" -> this.monthNumber = 5;
            case "June" -> this.monthNumber = 6;
            case "July" -> this.monthNumber = 7;
            case "August" -> this.monthNumber = 8;
            case "September" -> this.monthNumber = 9;
            case "October" -> this.monthNumber = 10;
            case "November" -> this.monthNumber = 11;
            case "December" -> this.monthNumber = 12;
        }
    }

    public String getMonthName() {
        String name = "";
        switch (this.monthNumber) {
            case 1 -> name = "January";
            case 2 -> name = "February";
            case 3 -> name = "March";
            case 4 -> name = "April";
            case 5 -> name = "May";
            case 6 -> name = "June";
            case 7 -> name = "July";
            case 8 -> name = "August";
            case 9 -> name = "September";
            case 10 -> name = "October";
            case 11 -> name = "November";
            case 12 -> name = "December";
        }
        return name;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    @Override
    public String toString() {
        return "Month{" +
                "monthNumber=" + monthNumber +
                '}';
    }

    public boolean equals(Month month) {
        return this.monthNumber == month.monthNumber;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public boolean greaterThan(Month monthNumber) {
        return monthNumber.monthNumber > this.monthNumber;
    }

    public boolean lessThan(Month month) {
        return month.monthNumber < this.monthNumber;
    }

    public static void reverse(String word) {
//        StringBuilder builder = new StringBuilder(word);
//        builder.reverse();
//        System.out.println(builder);

        String reverse = "";
        // Another
        for (int i = word.length() - 1; i >= 0; i--) {
            reverse = reverse + word.charAt(i);
        }
        System.out.println(reverse);
    }

    static void sentenceCapitalizer(String sentence) {
        char[] charset = sentence.toCharArray();
        boolean isFound = true;

        for (int i = 0; i < charset.length; i++) {
            if (Character.isLetter(charset[i])) {
                if (isFound) {
                    charset[i] = Character.toUpperCase(charset[i]);
                    isFound = false;
                }
            }
            else
                isFound = true;
        }
        sentence = String.valueOf(charset);
        System.out.println(sentence);
    }

    static void wordCounter(String sentence) {
        String[] words = sentence.split(" ");
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            counter++;
        }
        System.out.println(counter);
    }

    static void vowelsAndConsonant(String value){
        char[] a=value.toCharArray();
        Set<Character> vowels=new HashSet<>();
        Set<Character> consonants=new HashSet<>();

        for (int i=0; i<a.length; i++){
            if (a[i]=='a'|| a[i]=='e' || a[i]=='i' || a[i]=='o' || a[i]=='u')
                vowels.add(a[i]);
            else
                consonants.add(a[i]);
        }
        System.out.println("Total vowel is: "+vowels.size()+" and they're "+ vowels);
        System.out.println("Total consonant is :"+consonants.size()+" and they're "+consonants);
    }



    public static void main(String[] args) {
        Password password = new Password("jjsn43");
//        vowelsAndConsonant("The scar is shining brightly");
        System.out.println(password.isValid());
    }


    static class Password{
        private String password;

        public Password(String password) {
            this.password=password;
        }

        public boolean isValid(){
            return hasUpperCase.and(hasLowerCase).and(hasAtLeastOneDigit)
                    .and(isLengthMoreThan6).test(this.password);
        }

        Predicate<String> hasAtLeastOneDigit=new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.chars().anyMatch(Character::isDigit);
            }
        };

        Predicate<String> hasLowerCase=new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.chars().anyMatch(Character::isLowerCase);
            }
        };

        Predicate<String> hasUpperCase=new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.chars().anyMatch(Character::isUpperCase);
            }
        };

        Predicate<String> isLengthMoreThan6 = new Predicate<String>() {
            public boolean test(String s) {
                return s.length() >= 6;
            }
        };
    }


}


