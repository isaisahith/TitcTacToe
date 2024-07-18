package Concurrency.TitTacToe.Controllers;

import Concurrency.TitTacToe.Models.Game;
import Concurrency.TitTacToe.Models.GameStatus;
import Concurrency.TitTacToe.Strategies.WinnigStrategy;
import Concurrency.TitTacToe.Models.*;
import java.util.*;

public class GameController {
    public Game game;

    public Game startGame(int size, List<Player> players, List<WinnigStrategy> winningStrategies){
        return Game.getBuilder()
        .setDimension(size)
        .setPlayers(players)
        .setWinningStrategies(winningStrategies)
        .build();
        
    }

    public void displayBoard(Game game){
       
    
        game.displayBoard();

        
        
    }

    public GameStatus checkStatus(Game game){
        return game.getGameStatus();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public String getWinner(Game game){
        return game.getWinner().getName();
    }

    public void undo(Game game){
        game.undo();
    }





}
