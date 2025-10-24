public class Cell {
    public static CellState Unreavealed = CellState.Unrevealed;
    public static CellState Revealed = CellState.Revealed;
    public static CellState Flagged = CellState.Flagged;

    private boolean isMine;
    private CellState state = Unreavealed;
    private int count = 0; // Only set on reveal

}

//Cell logic