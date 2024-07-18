package Concurrency.TitTacToe.Strategies;


import Concurrency.TitTacToe.Models.*;

public interface BotWinningStrategy {
    public Cell makeMove(Board board);
}
