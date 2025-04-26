package Model;

import Factory.WinningStrategyFactory;
import Strategy.WinningStrategy;
import Validators.Validators;

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

    public TicTacToeGame(GameBuilder gameBuilder) {
        this.size = gameBuilder.getSize();
        this.board = new Board(size);
        this.players = gameBuilder.getPlayers();
        this.winningStrategyList = gameBuilder.getWinningStrategyList();
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

    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public static class GameBuilder
    {
        private int size;
        private List<Player> players;
        private List<WinningStrategy> winningStrategyList;

        public List<Player> getPlayers() {
            return players;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<WinningStrategy> getWinningStrategyList() {
            return winningStrategyList;
        }

        public GameBuilder setWinningStrategyList(List<WinningStrategyType> winningStrategyTypeList) {
            this.winningStrategyList = WinningStrategyFactory.getWinningStategy(winningStrategyTypeList);
            return this;
        }

        public int getSize() {
            return size;
        }

        public GameBuilder setSize(int size) {
            this.size = size;
            return this;
        }

        private void validate() {
            Validators.validateGridSize(this.size);
            Validators.validatePlayerNo(this.size, this.players.size());

        }

        public TicTacToeGame build()
        {
            this.validate();
            return new TicTacToeGame(this);
        }
    }
}
