import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] moves = { "Rock", "Paper", "Scissors" };

        System.out.println("Welcome to Rock Paper Scissors!\nAvailable moves : (Rock, Paper, Scissors)");

        boolean running = true;
        while (running) {
            // Gather an input
            System.out.print("Your move is: ");
            String userChoice = sc.nextLine();
            for (String move : moves) {
                if (userChoice.toLowerCase().equals(move.toLowerCase()) || (userChoice.length() == 1 && userChoice.toLowerCase().equals(Character.toString(move.toLowerCase().charAt(0))))) {
                    userChoice = move;
                    break;
                }
            }

            // Random a move for the opponent
            Random rand = new Random();
            String computerChoice = moves[rand.nextInt(moves.length)];
            System.out.println("Player 2: " + computerChoice);

            //Judging
            if (userChoice == computerChoice) {
                System.out.println("It's a tie!, Nice game.\n");
            } else {
                switch (userChoice.toLowerCase()) {
                    case "rock":
                        if (computerChoice.toLowerCase().equals("scissors"))
                            System.out.println("You win!, Good sense.\n");
                        else
                            System.out.println("Too bad!, Try again next time.\n");
                        break;
                    case "paper":
                        if (computerChoice.toLowerCase().equals("rock"))
                            System.out.println("You win!, Good sense.\n");
                        else
                            System.out.println("Too bad!, Try again next time.\n");
                        break;
                    case "scissors":
                        if (computerChoice.toLowerCase().equals("paper"))
                            System.out.println("You win!, Good sense.\n");
                        else
                            System.out.println("Too bad!, Try again next time.\n");
                        break;
                    case "end":
                        System.out.println("See you next time!\n");
                        running = false;
                        sc.close();
                        break;
                    default:
                        System.out.println("Can't determine for the winner.\nPlease make sure you spelled correctly.\n");
                        break;
                }
            }
        }
    }
}
