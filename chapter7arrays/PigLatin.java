package chapter7arrays;

public class PigLatin {


    public static String pigLatin(String userInput) {
        int n = userInput.length();
        int index = -1;

        for (int i = 0; i < n; i++) {
            char letter = userInput.charAt(i);
            if (isVowel(letter)) {
                index = i;
                break;
            }
        }
        if (index == -1)
            return "-1";

        String firstVowels = userInput.substring(index);
        return firstVowels.concat(userInput.substring(0, index) + "ay");

    }
    public static boolean isVowel(char vowel) {
        return vowel == 'A' || vowel == 'a' || vowel == 'e' || vowel == 'E' || vowel == 'i' || vowel == 'I'
                || vowel == 'o' || vowel == 'O' || vowel == 'u' || vowel == 'U';
    }

    public static void printLatin() {
        String plstring1 = pigLatin("chutter");
        String plstring2 = pigLatin("apple");

        if (plstring1.equals("-1"))
            System.out.println("Sorry Impossible");
        System.out.println(plstring1 + " , " + plstring2);
    }

    public static void main(String[] args) {
        printLatin();
    }

}
