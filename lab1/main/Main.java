package main;

import game.Game;
import game.Hero;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new Hero("Anastasia"));
        try
        {
            game.start();
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }
    }
}
