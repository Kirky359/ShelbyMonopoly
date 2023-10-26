package Board;

import Cube.Cube;
import Game.Player;
import java.util.ArrayList;

public class Board {
    private final Square[] field = new Square[40];
    public ArrayList<Player> players;
    private Deck deck = new Deck();
    public Cube cube;
    public Board(ArrayList<Player> players, Cube cube){
        this.players = players;
        this.cube = cube;

        //creating all squares on the board
        for(int i = 0; i < 40; i++){
            field[i] = new Square();
        }
    }

    public Square getSquareAt(int position){
        return field[position];
    }

    public Square getCurrentSquare(Player player){
        return getSquareAt(player.getPosition());
    }

}
