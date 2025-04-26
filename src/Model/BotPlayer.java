package Model;

import Strategy.BotPlayingStrategy;

public class BotPlayer extends Player {

    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public BotPlayer(int id, String name, PlayerType playerType, Symbol symbol , BotDifficultyLevel botDifficultyLevel , BotPlayingStrategy botPlayingStrategy) {
        super(id, name , playerType, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = botPlayingStrategy;
    }

    public Move makeMove(Board board)
    {
        System.out.println( "Bot is making move");
        Cell cell = botPlayingStrategy.makeMove(board);

        return new Move(this, cell);
    }



}
