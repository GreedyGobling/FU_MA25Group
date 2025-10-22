import java.util.Random;

public class Cell {
    public int rows;
    public int cols;
    public int mines;
    public boolean[][] isMine;
    public int[][] adjacentMines;
    public int revealedCells;
    public int minesLeft;

    public void takeInput(int rowInput, int colInput){
        System.out.println("Input taken: " + rowInput + ", " + colInput);
    }

    public void MineSweeperGame(int rowNumber, int colNumber, int mines){
        this.rows = rowNumber;
        this.cols = colNumber;
        this.mines = mines;
        this.isMine = new boolean[rows][cols];
        this.adjacentMines = new int[rows][cols];
        System.out.println("MineSweeper Game initialized with rows: " + rows + " and cols: " + cols);

        placeMines();
    }

    public void placeMines(){
        Random random = new Random();
        int minesPlaced = 0;
        while (minesPlaced < mines) {
            int r = random.nextInt(rows);
            int c = random.nextInt(cols);
            if (!isMine[r][c]) {
                isMine[r][c] = true;
                minesPlaced++;
            }
        }
    }
}