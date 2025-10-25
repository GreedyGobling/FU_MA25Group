import java.util.Scanner;

// Handles the game loop, player input, and win/loss conditions
public class Game {
    private final Board board;
    private boolean gameOver = false;

    public Game(Board board) {
        this.board = board;
    }

    public void start() {
        Scanner scan = new Scanner(System.in);

        while (!gameOver) {
            board.print(false); // Show board
            System.out.print("\nWhich cell do you want to reveal? (e.g., b2 or 'flag b2'): ");
            String input = scan.nextLine().trim().toLowerCase();

            if (input.equals("quit")) {
                System.out.println("Game ended.");
                break;
            }

            boolean flagAction = input.startsWith("flag ");
            String position = flagAction ? input.substring(5).trim() : input;

            if (position.length() < 2) {
                System.out.println("Invalid input!");
                continue;
            }

            int row = position.charAt(0) - 'a';
            int col = Character.getNumericValue(position.charAt(1)) - 1;

            if (row < 0 || row >= board.getRows() || col < 0 || col >= board.getCols()) {
                System.out.println("Invalid cell!");
                continue;
            }

            if (flagAction) {
                board.toggleFlag(row, col);
                continue;
            }

            boolean hitBomb = board.revealCell(row, col);

            if (hitBomb) {
                board.print(true); // Reveal all cells
                Rules.showGameOverMessage(position);
                gameOver = true;
            } else if (board.allSafeCellsRevealed()) {
                board.print(true); // Reveal all cells
                Rules.showWinMessage();
                gameOver = true;
            }
        }

        scan.close();
    }
}
