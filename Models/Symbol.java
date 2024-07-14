package Concurrency.TitTacToe.Models;

public class Symbol {
    private char symbol;

    public Symbol(char symbol){
        this.symbol = symbol;
    }

    public void setSymbol(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol(){
        return this.symbol;
    }
}
