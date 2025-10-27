import java.util.Random;

public class Cell {
    private int rows;
    private int cols;
    private int mines;
    private boolean[][] isMine;
    private int[][] adjacentMines;
    private double mineDensity = 0.12; // default 0.12
    private CellState[][] states;

    // function to spawn and sett // used at start
    // enum states easy to hide and show cell
    public void initialize(int rowNumber, int colNumber) {
        this.rows = rowNumber;
        this.cols = colNumber;
        mines = amountMines(rowNumber, colNumber);
        isMine = new boolean[rows][cols];
        adjacentMines = new int[rows][cols];

        states = new CellState[rows][cols];
        for (int r = 0; r < rows; r++) { // set all cells to unrevealed state
            for (int c = 0; c < cols; c++) {
                states[r][c] = CellState.Unrevealed;
            }
        }
        placeMines();
        calculateAdjacent();
    }



    private int amountMines(int row, int col) {
        int totalCells = row * col;
        int mines = (int) Math.round(totalCells * mineDensity);
        return mines;
    }
    // number calculator

    private void placeMines() {
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

    private void calculateAdjacent() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (isMine[r][c]) {
                    adjacentMines[r][c] = -1; // it's a trap
                } else {
                    int count = 0;
                    for (int dr = -1; dr <= 1; dr++) {
                        for (int dc = -1; dc <= 1; dc++) {
                            int nr = r + dr;
                            int nc = c + dc;
                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                                if (isMine[nr][nc]) {
                                    count++;
                                }
                            }
                        }
                    }
                    adjacentMines[r][c] = count;
                }
            }
        }
    }

    public boolean[][] getIsMine(){
        return isMine;
    }

    public int[][] getAdjacentMines(){
        return adjacentMines;
    }

    public CellState[][] getStates(){
        return states;
    }
}

//Cell logic