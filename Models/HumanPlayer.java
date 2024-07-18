package Concurrency.TitTacToe.Models;

public class HumanPlayer extends Player {
    private PlayerType playerType;
    public HumanPlayer(long id, String name, Symbol symbol){
        super(0, name, symbol);
        this.playerType = PlayerType.HUMAN;
    }

    public void setPlayerType(PlayerType playerType){
        this.playerType = playerType;
    }

    public PlayerType getPlayerType(){
        return this.playerType;
    }
}
