package Concurrency.TitTacToe.Strategies;

import Concurrency.TitTacToe.Models.*;

public interface WinnigStrategy {
    public  void handleUndo(Board board, Move move);
    public boolean checkWinner(Game game, Cell cell);
}
