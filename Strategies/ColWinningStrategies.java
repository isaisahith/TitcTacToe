package Concurrency.TitTacToe.Strategies;

import Concurrency.TitTacToe.Models.Cell;
import Concurrency.TitTacToe.Models.Game;
import Concurrency.TitTacToe.Models.*;

import java.util.HashMap;

public class ColWinningStrategies implements WinnigStrategy{
    HashMap<Integer, HashMap<Symbol, Integer>> hm = new HashMap<>();
    public boolean checkWinner(Game game, Cell cell){


        if(!hm.containsKey(cell.getCol())){
            hm.put(cell.getCol(), new HashMap<>());

        }

        HashMap<Symbol, Integer> h = hm.get(cell.getCol());

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
        int c = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        hm.get(c).put(symbol, hm.get(c).get(symbol) - 1);
    }
}
