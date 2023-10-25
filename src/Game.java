import java.util.ArrayList;

public class Game {
    private final Cube cube;
    private final Board board;
    private ArrayList<Player> players = new ArrayList<Player>();

    public Game( ArrayList<Player> players, Board board, Cube cube) {
        this.cube = cube;
        this.players = players;
        this.board = board;
    }

    // Pass the turn to the next player in the game
   public void turnPlayer(Player currentPlayer){
        System.out.println("\n" + currentPlayer.getName() + "'s turn!\n");
        System.out.println("\nCash :" + currentPlayer.getMoney());
        System.out.println("\nPosition: " + currentPlayer.getPosition());

        currentPlayer.move(cube.rollCube());

        showPlayerOptions(currentPlayer);
    }
    public void endTurn(Player currentPlayer){
        int currentIndex = players.indexOf(currentPlayer);
        if(currentIndex + 1 == players.size()){
            turnPlayer(players.get(0));
        } else {
            turnPlayer(players.get(currentIndex + 1));
        }
    }

    private void showPlayerOptions(Player currentPlayer){
        System.out.println("Enter 1 to buy property\n Enter 2 to end your turn ");
        if(PlayerInput.selectOptions() == 1) {
            System.out.println("Property was bought");
        } else if(PlayerInput.selectOptions() == 2) {
            System.out.println( currentPlayer.getName() + "'s turned!");
            endTurn(currentPlayer);
        } else {
            System.out.println("Invalid input");
            showPlayerOptions(currentPlayer);

        }
    }
}
