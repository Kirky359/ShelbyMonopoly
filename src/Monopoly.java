import java.util.ArrayList;
public class Monopoly {
    public static void main(String[] args){
        int amountPlayers = 2;
        Dice dice = new Dice();
        Jail jail = new Jail();
        ArrayList<Player> players = createPlayers(amountPlayers);
        Board board = new Board(players, dice, jail);
        Game game = new Game(players, board, dice, jail);
    }
    static ArrayList<Player> createPlayers(int numPlayers){
        ArrayList<Player> players = new ArrayList<>();
        return players;
    }
}

