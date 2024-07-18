package Concurrency.TitTacToe.Strategies;

import Concurrency.TitTacToe.Models.Board;
import Concurrency.TitTacToe.Models.Cell;
import Concurrency.TitTacToe.Models.CellState;
import Concurrency.TitTacToe.Models.*;

public class BotWinningStrategyEasy implements BotWinningStrategy{
    @Override
    public Cell makeMove(Board board) {

        int r=-1;
        int c = -1;

        for(int i=0; i<board.getSize(); i++){
            for(int j=0; j<board.getSize(); j++){
                if(board.getCells().get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    c = j;
                    r = i;
                    break;
                }
            }
        }



        return new Cell(r,c);
    }
}
