package Game;
import Board.*;
import Cube.*;

public class PayBailOption extends PlayerOption{
    Cube cube;
    Player player;
    Board board;

    public PayBailOption(Cube cube, Player currentPlayer, Board board){
        super("Pay $50");
        this.cube = cube;
        player = currentPlayer;
        this.board = board;
    }

    public void action(){
        player.addMoney(-50);
        player.inJail = false;
        player.move(cube.rollCube(), board);
    }
}