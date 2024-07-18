package Concurrency.TitTacToe.Models;

import Concurrency.TitTacToe.Strategies.BotWinningStrategy;
import Concurrency.TitTacToe.Strategies.BotWinningStrategyFactory;

public class BotPlayer extends Player{
    private PlayerType playerType;
    private DifficultyLevel difficultyLevel;
    public BotPlayer(long id, String name, Symbol symbol, DifficultyLevel difficultyLevel){
        super(0, name, symbol);
        playerType = PlayerType.BOT;
        this.difficultyLevel = difficultyLevel;
    }

    public void setPlayerType(PlayerType playerType){
        this.playerType = playerType;
    }

    public PlayerType getPlayerType(){
        return this.playerType;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel){
        this.difficultyLevel = difficultyLevel;
    }

    public DifficultyLevel getDifficultyLevel(){
        return this.difficultyLevel;
    }

    public Move makeMove(Board board){

        BotWinningStrategy strategy = BotWinningStrategyFactory.getBotWinningStrategy(this.difficultyLevel);
        Cell cell = strategy.makeMove(board);
        System.out.println("----------------------------------");
        return new Move(cell, this);

    }
    
}
