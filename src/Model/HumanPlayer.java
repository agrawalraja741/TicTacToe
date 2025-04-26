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

    public  void makeMove(TicTacToeGame game)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print(game.get +"Enter move row details: ");
    }

}
