package Model;

public abstract class Player {

    private int id;
    private String Name;
    private PlayerType playerType;
    private Symbol symbol;

    public Player(int id, String name, PlayerType playerType, Symbol symbol) {
        this.id = id;
        Name = name;
        this.playerType = playerType;
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public abstract Move makeMove(Board board);

}
