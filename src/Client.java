import Controller.GameController;
import Model.*;
import Validators.Validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe!");

        Board board = new Board(3);
        Player player1 = new HumanPlayer(0,"Raja", PlayerType.HUMAN, new Symbol('X'),"8989898989");
        Player player2 = new HumanPlayer(1,"Aman", PlayerType.HUMAN, new Symbol('O'),"6767676767");

        List<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);

        GameController gameController = new GameController();
        TicTacToeGame game = gameController.startGame
                (3, players ,List.of(WinningStrategyType.ROW,WinningStrategyType.COLUMN,WinningStrategyType.DIAGONAL) );

        gameController.display(game);


    }
}