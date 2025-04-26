package Factory;

import Model.WinningStrategyType;
import Strategy.ColWinningStrategy;
import Strategy.DiagWinningStrategy;
import Strategy.RowWinningStrategy;
import Strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class WinningStrategyFactory {

    public static List<WinningStrategy> getWinningStategy(List<WinningStrategyType> winningStrategyTypeList)
    {
        List<WinningStrategy>  winningStrategyList = new ArrayList<WinningStrategy>();
        if(winningStrategyTypeList != null)
        {
            if(winningStrategyTypeList.equals(WinningStrategyType.ROW))
            {
                winningStrategyList.add(new RowWinningStrategy());
            }
            else if(winningStrategyTypeList.equals(WinningStrategyType.COLUMN))
            {
                winningStrategyList.add(new ColWinningStrategy());
            }
            else if(winningStrategyTypeList.equals(WinningStrategyType.DIAGONAL))
            {
                winningStrategyList.add(new DiagWinningStrategy());
            }

            return winningStrategyList;
        }
        else
        {
            throw new NullPointerException("WinningStrategyType can not be null");
        }
    }
}
