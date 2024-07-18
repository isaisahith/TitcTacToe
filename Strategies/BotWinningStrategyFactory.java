package Concurrency.TitTacToe.Strategies;

import Concurrency.TitTacToe.Models.DifficultyLevel;

public class BotWinningStrategyFactory {
    public static BotWinningStrategy getBotWinningStrategy(DifficultyLevel difficultyLevel) {
        if(difficultyLevel == DifficultyLevel.EASY){
            return new BotWinningStrategyEasy();
        }

        return null;
    }
}
