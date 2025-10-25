import java.util.Random;

public class Cell {
    public int rows;
    public int cols;
    public int mines;
    public boolean[][] isMine;
    public int[][] adjacentMines;
    public double mineDensity = 0.12f;

    // COMBO OF Version 1 and 2
    public static CellState Unrevealed = CellState.Unrevealed;
    public static CellState Revealed = CellState.Revealed;
    public static CellState Flagged = CellState.Flagged;

    // function to spawn and sett // used at start
    // enum states easy to hide and show cell
    public void starting(int rowNumber, int colNumber){
        this.rows = rowNumber;
        this.cols = colNumber;
        mines = amountMines(rowNumber, colNumber);
        //this.mines = mines; // function that takes row and col make random amount of mines base of math
        System.out.printf("mines: %d\n", mines);
        //placeMines();
    }

    private int amountMines(int row, int col){
    int totalCells = row * col;
    int mines = (int) Math.round(totalCells * mineDensity);
    return mines;

    }
    // number calculator

    private void placeMines(){
        Random random = new Random();
        int minesPlaced = 0;
        while (minesPlaced < mines){
            int r = random.nextInt(rows);
            int c = random.nextInt(cols);
            if (!isMine[r][c]){
                isMine[r][c] = true;
                minesPlaced++;
            }
        }
    }

}

//Cell logic