import java.util.Scanner;

// Entry point of the game
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Rules.showWelcome(); // Welcome screen
        Rules.show();        // Game instructions

        System.out.print("Choose difficulty (1-3): ");
        String choiceInput = sc.nextLine().trim();
        int choice = choiceInput.isEmpty() ? 1 : Integer.parseInt(choiceInput);

        int rows, cols;
        switch (choice) {
            case 1 -> { rows = 6; cols = 6; }
            case 2 -> { rows = 8; cols = 8; }
            case 3 -> { rows = 10; cols = 10; }
            default -> { rows = 6; cols = 6; }
        }

        Board board = new Board(rows, cols);
        Game game = new Game(board);
        game.start(); // Start the game

        sc.close();
    }
}
