import java.util.Scanner;

// Entry point of the game
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain) {
            Rules.showWelcome(); // Welcome screen

            //Rules.show();        // Game instructions

            System.out.print("Choose difficulty (1-3): ");
            String choiceInput = sc.nextLine().trim();
            int choice = choiceInput.isEmpty() ? 1 : Integer.parseInt(choiceInput);

            int rows, cols;
            switch (choice) {
                case 1 -> {
                    rows = 6;
                    cols = 6;
                }
                case 2 -> {
                    rows = 8;
                    cols = 8;
                }
                case 3 -> {
                    rows = 10;
                    cols = 10;
                }
                default -> {
                    rows = 6;
                    cols = 6;
                }
            }


            Cell cell = new Cell();
            cell.initialize(rows, cols); // Initialize cell with chosen size
            Board board = new Board(rows, cols);
            Game game = new Game(board, sc);
            Rules.show();// Game instructions

           try {
                Thread.sleep(3000); // Pause for half a second before starting
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            game.start(); // Start the game

            System.out.print("\nDo you want to play again? (yes/no): ");
            String answer = sc.nextLine().trim().toLowerCase();
            if (!answer.equals("yes") && !answer.equals("y")) {
                playAgain = false;
                System.out.println("Thanks for playing! Goodbye!");
            }

        }
        sc.close();

    }
}
