package Strategy;

import Model.Board;
import Model.Move;
import Model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagWinningStrategy implements WinningStrategy {

    Map<Symbol, Integer> diaMap1= new HashMap<>();
    Map<Symbol, Integer> diaMap2= new HashMap<>();

    public boolean checkWinner(Board board, Move move)
    {
        int row = move.getCell().getRow();
        int column = move.getCell().getColumn();

        if(row == column)
        {
            Symbol symbol = move.getPlayer().getSymbol();
            diaMap1.putIfAbsent(symbol, 0);
            diaMap1.put(symbol, diaMap1.get(symbol) + 1);

            if(diaMap1.get(symbol)== board.getSize())
            {
                return true;
            }
        }
        if (row+column+1 == board.getSize()) {
            Symbol symbol = move.getPlayer().getSymbol();
            diaMap2.putIfAbsent(symbol, 0);
            diaMap2.put(symbol, diaMap2.get(symbol) + 1);

            if (diaMap2.get(symbol) == board.getSize()) {
                return true;
            }
        }
        return false;
    }

    public void undoMove(Board board, Move move)
    {
        int row = move.getCell().getRow();
        int column = move.getCell().getColumn();
        Symbol sym = move.getPlayer().getSymbol();
        if(row == column) {
            diaMap1.put(sym, diaMap1.get(sym) - 1);
        }
        if (row+column+1 == board.getSize()) {
            diaMap2.put(sym, diaMap2.get(sym) - 1);
        }
    }
}
