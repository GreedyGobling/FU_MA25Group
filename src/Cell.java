public class Cell {
    public static CellState Unreavealed = CellState.Unrevealed;
    public static CellState Revealed = CellState.Revealed;
    public static CellState Flagged = CellState.Flagged;

    private boolean isMine;
    private CellState state = Unreavealed;
    private int count = 0; // set on reveal

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

    public void reveal() {
        if (state != Unreavealed) return;

        if (isMine){
            state = Revealed;
            return;
        }
        //count = getAdjacentNumber()
        state = Revealed;

    }

    public void flag(){
        if (state != Unreavealed) return;
        state = Flagged;
    }

    private int getAdjacentNumber(){
        // TODO number logic
    }
}

//Cell logic