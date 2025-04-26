package Model;

import Factory.WinningStrategyFactory;
import Strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {

    private int size;
    private Board board;
    private List<Player> players;
    private List<WinningStrategy> winningStrategyList;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
    private Player winnerPlayer;

    public TicTacToeGame(int size ,List<Player> players, List<WinningStrategyType> winningStrategyTypeList, GameStatus gameStatus) {
        this.size = size;
        this.board = new Board(size);
        this.players = players;
        this.winningStrategyList = WinningStrategyFactory.getWinningStategy(winningStrategyTypeList);
        this.moves = new ArrayList<>();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.winnerPlayer = null;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<WinningStrategy> getWinningStrategyList() {
        return winningStrategyList;
    }

    public void setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
        this.winningStrategyList = winningStrategyList;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public Player getWinnerPlayer() {
        return winnerPlayer;
    }

    public void setWinnerPlayer(Player winnerPlayer) {
        this.winnerPlayer = winnerPlayer;
    }

    public void display() {

        board.displayBoard();
    }
}
