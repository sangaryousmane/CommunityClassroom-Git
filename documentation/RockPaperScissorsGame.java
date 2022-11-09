package documentation;

import java.util.Random;

public class RockPaperScissorsGame {
    private static Random random = new Random();
    private static final int rand = random.nextInt(3);

    public static void main(String[] args) {
        scissorsDisplay();
    }

    static String computerChoice() {
        String str = "";
        switch (rand) {
            case 1 -> str = "rock";
            case 2 -> str = "paper";
            case 3 -> str = "scissors";
            default -> str = "none";
        }
        return str;

    }

    static String userChoice(int n) {
        String str = "";
        for (int i = 0; i <= n; i++) {
            switch (i) {
                case 1 -> str = "rock";
                case 2 -> str = "paper";
                case 3 -> str = "scissors";
                default -> str = "none";
            }
        }
        return str;
    }

    static void scissorsDisplay() {

        if (userChoice(1).equals("paper") && computerChoice().equals("scissors")) {
            System.out.println("Rock wins and it smashes the scissors");
        }
        if (computerChoice().equals("paper") && userChoice(1).equals("rock")) {
            System.out.println("Scissors wins and scissors cut the paper.");
        }
        if (userChoice(2).equals("rock") && computerChoice().equals("scissors")) {
            System.out.println("Paper wins and paper wraps rock");
        }
        if (userChoice(1).equals("rock") && computerChoice().equals("rock")) {
            System.out.println("Score tie.");
        }else {
            System.out.println("Vlah Vlah!!");
        }
    }


}
