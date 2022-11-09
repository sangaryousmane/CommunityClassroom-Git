package oops.enumeration;
// https://www.youtube.com/c/ProgrammingTutorials1M
import static documentation.Document.scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter the day and the temperature will be disclose.");
        String name=scanner.nextLine();
        Constants monday= Constants.valueOf(name);
        for (Constants constants: Constants.values()){
            System.out.println("Day " + constants +" has ordinal of "+constants.ordinal());
        }

        switch (monday){
            case MONDAY -> System.out.println("It' Monday");
            case TUESDAY -> System.out.println("It's Tuesday ");
            case THURSDAY -> System.out.println("Thursday is 50deg");
            case SUNDAY -> System.out.println("Sunday is 40");
            case FRIDAY -> System.out.println("friday is 20");
            case SATURDAY -> System.out.println("Saturday is: 30");
            case WEDNESDAY -> System.out.println("Wednesday is 100deg");
            default -> System.out.println("Invalid input.");
        }
    }
}
