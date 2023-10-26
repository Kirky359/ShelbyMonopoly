package Board;

import Cube.Cube;
import Game.Player;
import Game.PlayerInput;

import java.util.ArrayList;

public class Board {
    private final Square[] field = new Square[40];
    public ArrayList<Player> players;
    private Deck deck = new Deck();
    public Cube cube;
    public Board(ArrayList<Player> players, Cube cube){
        this.players = players;
        this.cube = cube;

        for(int i = 0; i < 40; i++){
            field[i] = createSquare(i);
        }
    }

    public Square getSquare(int index){
        return field[index];
    }

    public Square getCurrentSquare(Player player){
        return field[player.getPosition()];
    }

    public void playCard(Player currentPlayer){deck.takeCard(currentPlayer);}

    private Square createSquare(int position) {
        return new Square("Square " + position);
    }
}