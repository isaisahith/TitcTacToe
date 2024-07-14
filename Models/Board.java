package Concurrency.TitTacToe.Models;
import java.util.*;


public class Board {
    private int size;
    private ArrayList<ArrayList<Cell>> cells;

    public Board(int size){
        this.size = size;

        ArrayList<ArrayList<Cell>> c = new ArrayList<ArrayList<Cell>>();

        for(int i=0; i<size; i++){
            ArrayList<Cell> rows = new ArrayList<Cell>();
            for(int j=0; j<size; j++){
                Cell cl = new Cell(i, j);
                rows.add(cl);
            }
            c.add(rows);
        }
        this.cells = c;
    }

    public void setSize(int size){
        this.size = size;
    }

    public int getSize(){
        return this.size;
    }

    public void setCells(ArrayList<ArrayList<Cell>> cells){
        this.cells = cells;
    }

    public ArrayList<ArrayList<Cell>> getCells(){
        return this.cells;
    }

}
