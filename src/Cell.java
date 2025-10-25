import java.util.Random;

public class Cell {
    private int rows;
    private int cols;
    private int mines;
    private boolean[][] isMine;
    private int[][] adjacentMines;
    private double mineDensity = 0.12;
    private CellState[][] states;

    // function to spawn and sett // used at start
    // enum states easy to hide and show cell
    public Cell(int rowNumber, int colNumber){
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