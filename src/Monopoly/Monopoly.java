package Monopoly;

import Board.Board;
import Cube.Cube;
import Game.Game;
import Game.Player;
import Game.PlayerInput;
import Board.Jail;

import java.util.ArrayList;

public class Monopoly {
    public static void main(String[] args){
        Cube cube = new Cube();
        Jail jail = new Jail();
        ArrayList<Player> players = createPlayers(2);
        Board board = new Board(players, cube);

        Game game = new Game(jail, cube, board, players);
        jail.setGame(game);

        game.turn(players.get(0));
    }

    public static ArrayList<Player> createPlayers(int numPlayers){
        ArrayList<Player> players = new ArrayList<>();

        for(int i = 1; i <= numPlayers; i++){
            System.out.print("Player " + i + " name: ");
            players.add(new Player(PlayerInput.read()));
        }

        return players;
    }
}