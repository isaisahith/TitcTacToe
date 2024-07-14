package Concurrency.TitTacToe.Models;
import java.util.*;
public class Game {
    private Board board;
    private List<Player> players;
    private Player winner;
    private int currentPlayerIndex;
    private GameStatus gameStatus;
    private List<WinningStartegies> winningStrategies;
    private List<Move> moves;


    public Board getBoard(){
        return this.board;
    }

    
}
