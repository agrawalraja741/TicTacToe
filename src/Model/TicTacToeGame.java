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

    private boolean validMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();

        if(row<0 || row>=size || col<0 || col>=size || move.getCell().getCellState().equals(CellState.FILLED)){
            System.out.println("Invalid move");
            return false;
        }

        return true;
    }

    public void makeMove() {

        Player currentPlayer = players.get(this.getNextPlayerIndex());

        Move move;
        do
        {
            move = currentPlayer.makeMove(board);
        }
        while(!validMove(move));

        //Update the cell on the board
        Cell cellToUpdate = board.getBoard().get(move.getCell().getRow()).get(move.getCell().getColumn());
        cellToUpdate.setCellState(CellState.FILLED);
        cellToUpdate.setSymbol(currentPlayer.getSymbol());

        //Add move to move history
        moves.add(move);

        //Check the winner or if draw
        if(checkWinner(move)){
            setGameStatus(GameStatus.SUCCESS);
            setWinnerPlayer(currentPlayer);
        }else if(moves.size() == board.getSize() * board.getSize()){
            setGameStatus(GameStatus.DRAW);
        }
        //Increment the next player index
        nextPlayerIndex++;
        nextPlayerIndex = nextPlayerIndex % players.size();
    }

    public boolean checkWinner(Move move)
    {
        for(WinningStrategy winningStrategy : getWinningStrategyList())
        {
            if(winningStrategy.checkWinner(board,move))
            {
                return true;
            }

        }
        return false;
    }

    public void undo()
    {
        //remove last move from move list
        Move removeMove = moves.get(moves.size()-1);
        Player currentPlayer = removeMove.getPlayer();
        moves.remove(moves.size()-1);

        //mark empty cell
        Cell newCell = new Cell(removeMove.getCell().getRow(), removeMove.getCell().getColumn());
        newCell.setCellState(CellState.EMTPY);
        board.getBoard().get(removeMove.getCell().getRow()).set(removeMove.getCell().getColumn(), newCell);

        //remove data from hashmap - strategy classes

        this.UndoWinningStrategy(removeMove);

        // set correct nextplayerIndex
        nextPlayerIndex--;
        nextPlayerIndex = (nextPlayerIndex + players.size())% players.size();
    }

    public void UndoWinningStrategy(Move move)
    {
        for(WinningStrategy winningStrategy : getWinningStrategyList())
        {
            winningStrategy.undoMove(board,move);
        }

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
