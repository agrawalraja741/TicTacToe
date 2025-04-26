package Model;

public class BotPlayer extends Player {

    private BotDifficultyLevel botDifficultyLevel;

    public BotPlayer(int id, String name, PlayerType playerType, Symbol symbol , BotDifficultyLevel botDifficultyLevel) {
        super(id, name , playerType, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public Move makeMove(Board board)
    {
        throw new RuntimeException("need to implement BotPlayer");
    }



}
