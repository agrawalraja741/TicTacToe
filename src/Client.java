import Controller.GameController;
import Validators.Validators;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        GameController gameController = new GameController();
        gameController.startGame();
    }
}