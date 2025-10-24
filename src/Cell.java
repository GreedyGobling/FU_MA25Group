public class Cell {
    public static CellState Unreavealed = CellState.Unrevealed;
    public static CellState Revealed = CellState.Revealed;
    public static CellState Flagged = CellState.Flagged;

    private boolean isMine;
    private CellState state = Unreavealed;
    private int count = 0; // Only set on reveal

    public Cell(boolean isMine){
        this.isMine = isMine;
    }

    public boolean isMine(){
        return isMine;
    }

    public boolean isRevealed(){
        return state == Revealed;
    }

    public boolean isFlagged(){
        return state == Flagged;
    }

    public int getCount(){
        return count;
    }
}

//Cell logic