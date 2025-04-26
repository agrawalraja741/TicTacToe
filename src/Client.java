import Controller.GameController;
import Model.*;
import Strategy.NextCellBotPlayingStrategy;
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
        //Player player2 = new HumanPlayer(1,"Aman", PlayerType.HUMAN, new Symbol('O'),"6767676767");
        Player player2 = new BotPlayer(1,"Bot", PlayerType.BOT, new Symbol('O') , BotDifficultyLevel.EASY , new NextCellBotPlayingStrategy());
        List<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);

        List<WinningStrategyType> winningStrategyTypeList = new ArrayList<>();
        winningStrategyTypeList.add(WinningStrategyType.ROW);
        winningStrategyTypeList.add(WinningStrategyType.COLUMN);
        winningStrategyTypeList.add(WinningStrategyType.DIAGONAL);

        GameController gameController = new GameController();
        TicTacToeGame game = gameController.startGame
                (3, players , winningStrategyTypeList);

        gameController.display(game);

        while(game.getGameStatus().equals(GameStatus.IN_PROGRESS))
        {
            gameController.makeMove(game);
            gameController.display(game);

            if(game.getMoves().get(game.getMoves().size()-1).getPlayer().getPlayerType().equals(PlayerType.HUMAN))
            {
                System.out.println("Do you want to undo? Press 1 to continue and 2 to undo");
                int undo = scanner.nextInt();

                if(undo == 2){
                    gameController.undo(game);
                }
            }
        }

        if(gameController.checkGameState(game) == GameStatus.SUCCESS){
            System.out.println(game.getWinnerPlayer().getName() + " is the Winner!");
        }else if(gameController.checkGameState(game) == GameStatus.DRAW){
            System.out.println("Game is draw!");
        }


    }
}