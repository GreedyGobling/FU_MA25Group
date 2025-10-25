import java.util.Random;

public class Cell {
    public int rows;
    public int cols;
    public int mines;
    public boolean[][] isMine;
    public int[][] adjacentMines;

    // COMBO OF Version 1 and 2
    public static CellState Unrevealed = CellState.Unrevealed;
    public static CellState Revealed = CellState.Revealed;
    public static CellState Flagged = CellState.Flagged;

    // function to spawn and sett // used at start
    // enum states easy to hide and show cell
    public void starting (int rowNumber, int colNumber){
        this.rows = rowNumber;
        this.cols = colNumber;
        this.mines = mines;

        placeMines();
    }
    // spawn mines

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