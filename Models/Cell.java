package Concurrency.TitTacToe.Models;

public class Cell {
    private int row;
    private int col;
    private Symbol symbol;
    private CellState cellState;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.symbol = null;
        this.cellState = CellState.EMPTY;
    }

    public void setRow(int row) {
        this.row = row;

    }

    public int getRow() {
        return this.row;
    }

    public void setCol(int col) {
        this.col = col;

    }

    public int getCol() {
        return this.col;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;

    }

    public Symbol getSymbol() {
        return this.symbol;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;

    }

    public CellState getCellState() {
        return this.cellState;
    }

}
