import java.util.LinkedList;
import java.util.Queue;

public class Board {
    private final Cell cellData = new Cell();
    private boolean[][] revealed;
    private boolean[][] flagged;
    private boolean[][] isMine;
    private int[][] adjacentMines;
    private int rows;
    private int cols;

    //constructiors //
    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        cellData.initialize(rows, cols);

//get data from cells
        this.isMine = cellData.getIsMine();
        this.adjacentMines = cellData.getAdjacentMines();

        this.revealed = new boolean[rows][cols];
        this.flagged = new boolean[rows][cols];
    }

  //getters
    public int getRows() { return rows; }
    public int getCols() { return cols; }

   //flag logic
    public void toggleFlag(int row, int col) {
        if (revealed[row][col]) {
            System.out.println(" You can’t flag an already revealed cell!");
            return;
        }
        flagged[row][col] = !flagged[row][col];
    }

    //reveal cell
    public boolean revealCell(int row, int col) {
        if (revealed[row][col] || flagged[row][col]) {
            System.out.println("️Cell already revealed or flagged.");
            return false;
        }

        revealed[row][col] = true;

        if (isMine[row][col]) {
            return true; // 💣 träff
        }

       //open other if no mines around
        if (adjacentMines[row][col] == 0) {
            floodReveal(row, col);
        }

        return false;
    }

    //open empty cells
    private void floodReveal(int startRow, int startCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    int nr = r + dr;
                    int nc = c + dc;

                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                    if (revealed[nr][nc] || flagged[nr][nc]) continue;

                    revealed[nr][nc] = true;
                    if (adjacentMines[nr][nc] == 0 && !isMine[nr][nc]) {
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }

    //    check  win
    public boolean allSafeCellsRevealed() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!isMine[r][c] && !revealed[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    //write board
    public void print(boolean revealAll) {
        System.out.print("   ");
        for (int c = 1; c <= cols; c++) {
            System.out.print(c + " ");
        }
        System.out.println();

        for (int r = 0; r < rows; r++) {
            System.out.print((char) ('a' + r) + "  ");
            for (int c = 0; c < cols; c++) {
                if (revealAll) {
                    // Visa allt (vid förlust eller vinst)
                    if (isMine[r][c]) System.out.print("💣 ");
                    else System.out.print(adjacentMines[r][c] + " ");
                } else {
                    if (flagged[r][c]) System.out.print(" red flag ");
                    else if (!revealed[r][c]) System.out.print("⬜ ");
                    else if (isMine[r][c]) System.out.print("💣 ");
                    else {
                        int adj = adjacentMines[r][c];
                        System.out.print(adj == 0 ? "  " : adj + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}
