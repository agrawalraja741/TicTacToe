package Strategy;

import Model.Board;
import Model.Cell;
import Model.CellState;
import Model.Move;

public class NextCellBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Cell makeMove(Board board) {
        int size = board.getSize();
        for(int i =0; i<size; i++){
            for(int j =0; j<size; j++) {
                if (board.getBoard().get(i).get(j).getCellState().equals(CellState.EMTPY))
                {
                    return new Cell(i,j);
                }
            }
        }

        return null;
    }
}
