import Cube.Cube;

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
            field[i] = new Square();
        }
    }

    public Square getSquare(int index){
        return field[index];
    }

    public Square getCurrentSquare(Player player){
        return field[player.getPosition()];
    }
}
