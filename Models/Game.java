package Concurrency.TitTacToe.Models;
import java.util.*;

import Concurrency.TitTacToe.Strategies.WinnigStrategy;
public class Game {
    private Board board;
    private List<Player> players;
    private Player winner;
    private int currentPlayerIndex;
    private GameStatus gameStatus;
    private List<WinnigStrategy> winningStrategies;
    private List<Move> moves;

    public Game(Builder builder){
        this.board = new Board(builder.dimension);
        this.players = builder.players;
        this.winner = null;
        this.currentPlayerIndex = 0;
        this.gameStatus = gameStatus.IN_PROGRESS;
        this.winningStrategies = builder.winninStrategies;
        this.moves = new ArrayList<>();
    }

    public void displayBoard(){
        this.board.display();
    }

    public boolean validateMove(Cell cell){
        int r = cell.getRow();
        int c = cell.getCol();

        if(r<0 || r >=this.getBoard().getSize() || c<0 || c >= this.getBoard().getSize()){
            return false;
        }

        if(this.board.getCells().get(r).get(c).getCellState().equals(CellState.EMPTY)){

            return true;
        }else{
            System.out.println("Inside the else statement: "+cell.getCellState());
            return false;
        }


    }

    public void checkWinner(Cell cell){
        for(WinnigStrategy w: this.getWinningStrategies() ){
            boolean flag = w.checkWinner(this, cell);
            if(flag){
                this.setGameStatus(GameStatus.SUCCESS);
                this.setWinner(this.players.get(currentPlayerIndex));
            }
        }

        if(this.moves.size()==this.getBoard().getSize()*this.getBoard().getSize()){
            this.setGameStatus(GameStatus.DRAW);
        }



    }

    public void handleUndo(Move move){
        for(WinnigStrategy w: this.getWinningStrategies()){
            w.handleUndo(this.board, move);
        }
    }


    public void makeMove(){
        
        Move move = players.get(currentPlayerIndex).makeMove(this.board);

        int r = move.getCell().getRow();
        int c = move.getCell().getCol();

        if(!validateMove(move.getCell())){
            System.out.println("This  is invalid move");
            return;

        }else{
            Cell cellToBeSet = this.getBoard().getCells().get(r).get(c);
            cellToBeSet.setCellState(CellState.OCCUPIED);
            cellToBeSet.setSymbol(this.players.get(this.currentPlayerIndex).getSymbol());
            move.setCell(cellToBeSet);
            this.moves.add(move);







        }

        checkWinner(move.getCell());

        if(gameStatus.equals(GameStatus.IN_PROGRESS)){
            this.currentPlayerIndex++;
            this.currentPlayerIndex = this.currentPlayerIndex % this.players.size();
        }


    }
    public void undo(){
        if(this.moves.size()>0){
            Move lastMove = this.moves.get(this.moves.size()-1);
            Symbol s = lastMove.getCell().getSymbol();
            this.moves.remove(this.moves.size()-1);

            lastMove.getCell().setCellState(CellState.EMPTY);
            lastMove.getCell().setSymbol(null);
            handleUndo(lastMove);
            this.currentPlayerIndex--;
            this.currentPlayerIndex = (this.currentPlayerIndex + this.players.size())% this.players.size();


        }else{
            System.out.println("No moves to Undo");
        }




    }


    public Board getBoard(){
        return this.board;
    }

    public List<Player> getPlayers(){
        return this.players;
    }

    public Player getWinner(){
        return this.winner;
    }

    public void setWinner(Player winner){
        this.winner = winner;
    }

    public int getCurrentPlayerIndex(){
        return this.currentPlayerIndex;
    }

    public GameStatus getGameStatus(){
        return this.gameStatus;
    }
    public void setGameStatus(GameStatus gameStatus){
        this.gameStatus= gameStatus;
    }

    public List<WinnigStrategy> getWinningStrategies(){
        return this.winningStrategies;
    }

    public List<Move> getMoves(){
        return this.moves;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        private int dimension;
        private List<Player> players;
        private List<WinnigStrategy> winninStrategies;

        public Builder setDimension(int dimension){
            this.dimension = dimension;
            return this;
        }



        public Builder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinnigStrategy> winningStrategies){
            this.winninStrategies = winningStrategies;
            return this;
        }

        public void validateDimesion(){
            if (this.dimension-1 != this.players.size()) {
                throw new RuntimeException("Incorrect number of players");
            }
        }



        public void validateNumberOfBots(){
            int botCount = 0;
            for (Player player : this.players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount++;
                }
                if (botCount > 1) {
                    throw new RuntimeException("Game cannot have more than 1 bot");
                }
            }
        }

        public void validateSymbols(){
            HashSet<Symbol> playerSymbols = new HashSet<>();

            for (Player player : this.players) {

                if(player.getSymbol().equals('_')){
                    throw new RuntimeException("Player cannot choose '_' symbol");
                }
                if (playerSymbols.contains(player.getSymbol())) {
                    throw new RuntimeException("No two players cannot have same symbol");
                }

                playerSymbols.add(player.getSymbol());
            }
        }

        public void validate(){
            validateDimesion();;
            validateNumberOfBots();
            validateSymbols();
        }

        public Game build(){
            
            validate();
            Game g = new Game(this);

            return g;

        }
    }


}
