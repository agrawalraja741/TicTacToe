package Model;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private String mobileNumber;

    public HumanPlayer(int id, String name, PlayerType playerType, Symbol symbol, String mobileNumber) {
        super(id, name, playerType, symbol);
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public  Move makeMove(Board board)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(this.getName() + " Enter move.");

        System.out.print("Enter row: ");
        int row = scanner.nextInt();

        System.out.print("Enter column: ");
        int column = scanner.nextInt();

        Move move = new Move(this, new Cell(row,column));
        return move;
    }

}
