package Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int size;

    public Board(int size)
    {
        this.size = size;
        board = new ArrayList<>();
        for(int i=0; i<size; i++)
        {
            board.add( i,new ArrayList<>());
            for(int j =0; j<size; j++)
            {
                board.get(i).add(new Cell(i,j));
            }
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void displayBoard()
    {
        for(int i=0; i<size; i++)
        {
            for(int j =0; j<size; j++)
            {
                board.get(i).get(j).display();
            }
            System.out.println();

        }
    }
}
