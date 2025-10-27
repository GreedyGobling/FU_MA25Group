// Handles messages, instructions, and constants for the game
public class Rules {
    public static final double DEFAULT_MINE_DENSITY = 0.12;

    // Show welcome message
    public static void showWelcome() {
        System.out.println("""
        ==========================================
                      💣 MINESWEEPER
        ==========================================
        Welcome to a classic text-based Minesweeper!

        Choose a difficulty level:
          1. Easy  (6x6)
          2. Medium  (8x8)
          3. Hard  (10x10)

        Press Enter for default settings.
        """);
    }

    // Show instructions
    public static void show() {
        System.out.println("==========================================");
        System.out.println("          🎯 GAME RULES                   ");
        System.out.println("==========================================");
        System.out.println("""
        Objective:
           Reveal all safe cells without hitting a bomb!

        Commands:
           b2         -> reveal cell
           flag b2    -> toggle flag
           quit       -> exit the game

        Tips:
           Cells with 0 adjacent mines are revealed automatically.
        """);
        System.out.println("==========================================");
    }

    // Show win message
    public static void showWinMessage() {
        System.out.println("🎉 Congratulations! / You have cleared all the safe cells without exploding!");
    }

    // Show game over message
    public static void showGameOverMessage(String cellName) {
        System.out.println("💥 Game Over! / PANG! Cell " + cellName + " contained a bomb!");
    }
}
