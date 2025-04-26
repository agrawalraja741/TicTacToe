package Strategy;

import Model.Board;
import Model.Move;
import Model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {

    Map<Integer , Map<Symbol, Integer>> rowMap= new HashMap<>();

    public boolean checkWinner(Board board, Move move)
    {
        rowMap.putIfAbsent(move.getCell().getRow(), new HashMap<>());

        Map<Symbol,Integer> rowCountMap = rowMap.get(move.getCell().getRow());

        Symbol symbol = move.getPlayer().getSymbol();
        rowCountMap.putIfAbsent(symbol, 0);
        rowCountMap.put(symbol, rowCountMap.get(symbol) + 1);

        System.out.println("Hashmap value : "+rowCountMap.get(symbol));
        if(rowCountMap.get(symbol)== board.getSize())
        {
            return true;
        }

        return false;
    }

    public void undoMove(Board board, Move move)
    {
        //int val = rowMap.get(move.getCell().getRow()).get(move.getCell().getSymbol());
        Map<Symbol,Integer> rowCountMap = rowMap.get(move.getCell().getRow());
        Symbol sym = move.getPlayer().getSymbol();
        rowCountMap.put(sym, rowCountMap.get(sym) - 1);
    }
}
