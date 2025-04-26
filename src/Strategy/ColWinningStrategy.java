package Strategy;

import Model.Board;
import Model.Move;
import Model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy {
    Map<Integer , Map<Symbol, Integer>> ColMap= new HashMap<>();

    public boolean checkWinner(Board board, Move move)
    {
        ColMap.putIfAbsent(move.getCell().getColumn(), new HashMap<>());

        Map<Symbol,Integer> ColCountMap = ColMap.get(move.getCell().getColumn());

        Symbol symbol = move.getPlayer().getSymbol();
        ColCountMap.putIfAbsent(symbol, 0);
        ColCountMap.put(symbol, ColCountMap.get(symbol) + 1);

        if(ColCountMap.get(symbol)== board.getSize())
        {
            return true;
        }

        return false;
    }
}
