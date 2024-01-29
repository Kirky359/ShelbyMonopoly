package Monopoly;

import Board.Board;
import Cube.Cube;
import Game.Game;
import Game.Player;
import Game.PlayerInput;
import Board.Jail;
import Option.*;

import java.util.ArrayList;
import java.util.List;

public class Monopoly {
    public static void main(String[] args){
        Cube cube = new Cube();
        Jail jail = new Jail();
        int numPlayers = getNumberOfPlayers();
        List<Player> players = createPlayers(numPlayers);
        Board board = new Board(jail, cube, players);

        Game game = new Game(jail, cube, board, players);
        jail.setGame(game);

        game.turn(players.get(0));
    }

    public static List<Player> createPlayers(int numPlayers){
        List<Player> players = new ArrayList<>();

        for(int i = 1; i <= numPlayers; i++){
            System.out.print("Player " + i + " name: ");
            players.add(new Player(PlayerInput.read()));
        }

        return players;
    }

    private static int getNumberOfPlayers() {
        int numPlayers = 0;

        while (numPlayers <= 0 || numPlayers > 6) {
            System.out.print("Enter the number of players: ");

            try {
                numPlayers = Integer.parseInt(PlayerInput.read());

                if (numPlayers <= 0) {
                    System.out.println("Please enter a valid number of players (greater than 0).");
                } else if (numPlayers > 6) {
                    System.out.println("Please enter a valid number of players (less than 6).");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        return numPlayers;
    }
}