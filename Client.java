package Concurrency.TitTacToe;

import java.util.ArrayList;
import java.util.Scanner;

import Concurrency.TitTacToe.Controllers.GameController;
import Concurrency.TitTacToe.Models.*;
//import Concurrency.TitTacToe.Strategies.ColWinningStrategies;
import Concurrency.TitTacToe.Strategies.*;
import Concurrency.TitTacToe.Strategies.WinnigStrategy;


public class Client {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameController gameController = new GameController();

        ArrayList<Player> players = new ArrayList<>();

        Player p1 = new HumanPlayer(1L, "A", new Symbol('a'));
        Player p2 = new HumanPlayer(2L, "B", new Symbol('b'));
        Player p3 = new BotPlayer(3L, "Bot", new Symbol('X'), DifficultyLevel.EASY);

        players.add(p1);
        players.add(p2);

        ArrayList<WinnigStrategy> winnigStrategies = new ArrayList<>();
        winnigStrategies.add(new RowWinningStrategies());
        winnigStrategies.add(new ColWinningStrategies());

        Game game = gameController.startGame(3, players,winnigStrategies);

        gameController.displayBoard(game);

        while(gameController.checkStatus(game).equals(GameStatus.IN_PROGRESS)){
            gameController.makeMove(game);
            gameController.displayBoard(game);

            if(gameController.checkStatus(game).equals(GameStatus.IN_PROGRESS)){
                boolean undo = true;

                while(undo){
                    System.out.println("Do you want to undo [Y/N]:");
                    String ans = sc.nextLine();
                    if(ans.equals("Y")){
                        gameController.undo(game);
                        System.out.println("--------After undo------------");
                        gameController.displayBoard(game);
                    }else{
                        undo = false;
                    }
                }

            }

        }

        if(gameController.checkStatus(game).equals(GameStatus.DRAW)){
            System.out.println("No one wins");
        }else if(gameController.checkStatus(game).equals(GameStatus.SUCCESS)){
            System.out.println(gameController.getWinner(game)+" Wins!!");
        }else if(gameController.checkStatus(game).equals(GameStatus.NOT_STARTED)){
            System.out.println("Game is not started");
        }

    }
}
