public class Game {
    private int sizeBoard = 40;
    Player[] players;
    Square[] board = new Square[sizeBoard];

    public Game(int amountPlayers) {
        players = new Player[amountPlayers];
        new Cube().rollCube();
    }

    // Pass the turn to the next player in the game
    private void turn(Player currentPlayer){
        System.out.println("\n" + currentPlayer.getName() + "'s turn!\n");
    }
}
