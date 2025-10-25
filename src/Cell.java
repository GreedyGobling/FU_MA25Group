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

    }
    // spawn mines

    // number calculator

    //
}

//Cell logic