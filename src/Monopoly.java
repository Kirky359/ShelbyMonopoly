import java.util.ArrayList;

public class Monopoly {
    public static void main(String[] args){
        Cube cube = new Cube();
        ArrayList<Player> players = createPlayers(2);
        Board board = new Board(players, cube);

        Game game = new Game(players, board, cube);


        game.turnPlayer(players.get(0));
    }

    static ArrayList<Player> createPlayers(int numPlayers){
        ArrayList<Player> players = new ArrayList<>();

        for(int i = 1; i <= numPlayers; i++){
            System.out.print("Player " + i + " name: ");
            players.add(new Player(PlayerInput.read()));
        }

        return players;
    }
}
