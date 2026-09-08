import java.util.Random;

public class RockPaperScissorsGame {

    static String[] moves = {"Rock", "Paper", "Scissors"};

    public static void main(String[] args) {
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int rounds = playerMoves.length;

        String[] pMoves = new String[rounds];
        String[] cMoves = new String[rounds];
        String[] results = new String[rounds];

        Random rand = new Random();
        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < rounds; i++) {
            String playerMove = playerMoves[i];
            String computerMove = moves[rand.nextInt(moves.length)];
            String result = playRound(playerMove, computerMove);

            pMoves[i] = playerMove;
            cMoves[i] = computerMove;
            results[i] = result;

            System.out.println("Round " + (i + 1) + " -> Player: " + playerMove
                    + ", Computer: " + computerMove + " => " + result);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.println("\n===== Scoreboard =====");
        System.out.printf("%-8s %-15s %-15s %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8d %-15s %-15s %-15s%n", (i + 1), pMoves[i], cMoves[i], results[i]);
        }

        double winPct = (wins * 100.0) / rounds;
        System.out.println("\nWins: " + wins + " | Losses: " + losses + " | Draws: " + draws
                + " | Win % = " + String.format("%.1f", winPct) + "%");
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        boolean playerWins =
                (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"));

        return playerWins ? "Player Wins" : "Computer Wins";
    }
}
