public class Game {
    private int sizeBoard = 40;
    Player[] players;
    Square[] board = new Square[sizeBoard];

    public Game(int amountPlayers) {
        players = new Player[amountPlayers];
        rollDice();
    }

    // Rolls two dice and returns the sum of the results
    private int rollDice() {
        int roll1;
        int roll2;

        roll1 = (int) (Math.random() * 6 + 1);
        roll2 = (int) (Math.random() * 6 + 1);

        System.out.println("The dice have the values " + roll1 + " and " + roll2 + " on them");
        return roll1 + roll2;
    }

    // Pass the turn to the next player in the game
    private void turn(Player currentPlayer){
        System.out.println("\n" + currentPlayer.getName() + "'s turn!\n");
    }
}
