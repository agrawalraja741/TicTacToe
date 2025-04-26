package Controller;

import Model.*;
import Validators.Validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Model.TicTacToeGame.GameBuilder;

public class GameController {


    public TicTacToeGame startGame(int size , List<Player> players  , List<WinningStrategyType> winningStrategies)
    {
        TicTacToeGame game = TicTacToeGame.getBuilder()
                .setSize(size)
                .setPlayers(players)
                .setWinningStrategyList(winningStrategies)
                .build();

        return game;

    }

    public void display(TicTacToeGame game)
    {
        game.display();
    }

    public GameStatus checkGameState(TicTacToeGame game)
    {
        return game.getGameStatus();
    }

    public void makeMove(TicTacToeGame game)
    {
        game.makeMove();
    }

    public void undo(TicTacToeGame game)
    {
        game.undo();
    }
}
