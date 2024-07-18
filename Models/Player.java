package Concurrency.TitTacToe.Models;

import java.util.Scanner;

public abstract class Player {
    private long id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private Scanner sc = new Scanner(System.in);

    public Player(int id, String name, Symbol symbol){
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    public Move makeMove(Board borad){
        System.out.println(this.name+", your turn now.");
        System.out.println("Enter the row: ");
        int r = sc.nextInt();
        System.out.println("Enter the column: ");
        int c = sc.nextInt();

        return new Move(new Cell(r, c), this);
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSymbol(Symbol symbol){
        this.symbol = symbol;
    }

    public Symbol getSymbol(){
        return this.symbol;
    }

    public void setPlayerType(PlayerType playerType){
        this.playerType = playerType;
    }

    public PlayerType getPlayerType(){
        return this.playerType;
    }
}
