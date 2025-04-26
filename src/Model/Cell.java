package Model;

public class Cell {

    private int row;
    private int column;
    private CellState cellState;
    private Symbol symbol;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.cellState = CellState.EMTPY;
        this.symbol = null;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void display()
    {
        if(this.cellState.equals(CellState.EMTPY))
        {
            System.out.print("| - |");
        }
        else if(this.cellState.equals(CellState.FILLED))
        {
            System.out.print("| "+ this.symbol +" |");
        }
    }
}
