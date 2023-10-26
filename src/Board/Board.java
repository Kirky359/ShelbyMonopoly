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

    private Square createSquare(int position){
        switch(position){
            case 0:
                return new Square("GO");
            case 1:
                return new Square("Mediterranean Avenue");
            case 2:
            case 7:
            case 17:
            case 22:
            case 33:
            case 36:
                return new Square("Card square");
            case 3:
                return new Square("Baltic Avenue");
            case 4:
                return new Square("INCOME TAX");
            case 5:
                return new Square("Reading Railroad");
            case 6:
                return new Square("Oriental Avenue");
            case 8:
                return new Square("Vermont Avenue");
            case 9:
                return new Square("Connecticut Avenue");
            case 10:
                return new Square("Just Visiting Jail");
            case 11:
                return new Square("St. Charles Place");
            case 12:
                return new Square("Electric Company");
            case 13:
                return new Square("States Avenue");
            case 14:
                return new Square("Virginia Avenue");
            case 15:
                return new Square("Pennsylvania Railroad");
            case 16:
                return new Square("St. James Place");
            case 18:
                return new Square("Tennessee Avenue");
            case 19:
                return new Square("New York Avenue");
            case 20:
                return new Square("Free Parking");
            case 21:
                return new Square("Kentucky Avenue");
            case 23:
                return new Square("Indiana Avenue");
            case 24:
                return new Square("Illinois Avenue");
            case 25:
                return new Square("B&O Railroad");
            case 26:
                return new Square("Atlantic Avenue");
            case 27:
                return new Square("Ventnor Avenue");
            case 28:
                return new Square("Water Works");
            case 29:
                return new Square("Marvin Gardens");
            case 30:
                return new Square("Ostapa Mazura JAIL");
            case 31:
                return new Square("Pacific Avenue");
            case 32:
                return new Square("North Carolina Avenue");
            case 34:
                return new Square("Pennsylvania Avenue");
            case 35:
                return new Square("Short Line");
            case 37:
                return new Square("Park Place");
            case 38:
                return new Square("LUXURY TAX");
            case 39:
                return new Square("Boardwalk");
            default:
                return null;
        }
    }
}