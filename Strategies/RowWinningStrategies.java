package Concurrency.TitTacToe.Strategies;

import Concurrency.TitTacToe.Strategies.*;
import Concurrency.TitTacToe.Models.*;
import java.util.*;

public class RowWinningStrategies implements WinnigStrategy{
    HashMap<Integer, HashMap<Symbol, Integer>> hm = new HashMap<>();
    public boolean checkWinner(Game game, Cell cell){


        if(!hm.containsKey(cell.getRow())){
            hm.put(cell.getRow(), new HashMap<>());

        }

        HashMap<Symbol, Integer> h = hm.get(cell.getRow());

        if(!h.containsKey(cell.getSymbol())){
            h.put(cell.getSymbol(), 0);
        }

        h.put(cell.getSymbol(), h.get(cell.getSymbol()) + 1);

        if(h.get(cell.getSymbol()) == game.getBoard().getSize()){
            return true;
        }



        return false;

    }

    public void handleUndo(Board board, Move move) {
        int r = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();
        hm.get(r).put(symbol, hm.get(r).get(symbol) - 1);
    }
    
}
