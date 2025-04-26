package Strategy;

import Model.Board;
import Model.Cell;
import Model.Move;

public interface BotPlayingStrategy {

    public Cell makeMove(Board board);
}
