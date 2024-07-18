package Concurrency.TitTacToe.Models;

public class Move {
    private Cell cell;
    private Player player;

    public Move(Cell cell, Player player){
        this.cell = cell;
        this.player = player;
    }

    public void setCell(Cell cell){
        this.cell = cell;
    }
    
    public Cell getCell(){
        return this.cell;
    }



    public void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return this.player;
    }
}
