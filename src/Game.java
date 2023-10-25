import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private int sizeBoard = 40;

    private Cube cube;
    private Board board;
    private ArrayList<Player> players = new ArrayList<Player>();

    public Game( ArrayList<Player> players, Board board, Cube cube) {
        this.cube = cube;
        this.players = players;
        this.board = board;
    }

    // Pass the turn to the next player in the game
    private void turnPlayer(Player currentPlayer){
        System.out.println("\n" + currentPlayer.getName() + "'s turn!\n");
        System.out.println("\nCash :" + currentPlayer.getMoney());
        System.out.println("\nPosition: " + currentPlayer.getPosition());

        currentPlayer.move(cube.rollCube());

        showPlayerOptions(currentPlayer);
    }

    private void showPlayerOptions(Player currentPlayer){

    }
}
