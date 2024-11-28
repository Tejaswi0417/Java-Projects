package OOPs;

import java.util.Scanner;

public class SnakeAndLadder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Snakes and Ladders positions
        int[] board = new int[101];
        board[99] = 54; // Snake
        board[70] = 55; // Snake
        board[52] = 42; // Snake
        board[25] = 2;  // Snake
        board[6] = 25;  // Ladder
        board[11] = 40; // Ladder
        board[46] = 90; // Ladder
        board[60] = 85; // Ladder

        System.out.println("Welcome to the Snake and Ladder Game!");
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] players = new String[numPlayers];
        int[] positions = new int[numPlayers];

        // Get player names
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter the name of Player " + (i + 1) + ": ");
            players[i] = scanner.nextLine();
            positions[i] = 1; // Start position
        }

        System.out.println("\nAll players are ready! Press Enter to start the game.");
        scanner.nextLine();

        boolean gameOn = true;
        while (gameOn) {
            for (int i = 0; i < numPlayers; i++) {
                System.out.println("\n" + players[i] + "'s turn. Press Enter to roll the dice...");
                scanner.nextLine();

                int dice = rollDice();
                System.out.println(players[i] + " rolled: " + dice);

                if (positions[i] + dice > 100) {
                    System.out.println(players[i] + " can't move, roll again next turn.");
                    continue;
                }

                positions[i] += dice;

                // Check for snake or ladder
                if (board[positions[i]] != 0) {
                    if (positions[i] > board[positions[i]]) {
                        System.out.println("Oops! Bitten by a snake. Going down to position " + board[positions[i]]);
                    } else {
                        System.out.println("Yay! Climbed a ladder. Going up to position " + board[positions[i]]);
                    }
                    positions[i] = board[positions[i]];
                }

                System.out.println(players[i] + " is now at position: " + positions[i]);

                // Check for win condition
                if (positions[i] == 100) {
                    System.out.println("\nCongratulations! " + players[i] + " wins the game!");
                    gameOn = false;
                    break;
                }
            }
        }
        scanner.close();
    }

    static int rollDice() {
        return (int) (Math.random() * 6) + 1; // Generate a random number between 1 and 6
    }
}
