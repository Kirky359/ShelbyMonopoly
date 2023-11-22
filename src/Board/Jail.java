package Board;

import java.util.Arrays;
import java.util.List;
import Game.Game;
import Game.Player;
import Cube.Cube;

public class Jail{
    private Game game;

    public void setGame(Game game){
        this.game = game;
    }

    public void sendPlayerToJail(Player jailedPlayer){
        jailedPlayer.inJail = true;
        System.out.println("You are now in Jail for the next 3 turns");
        game.endTurn(jailedPlayer);
    }

    public boolean jailTurn(Player currentPlayer, Cube cube, Board board){
        currentPlayer.turnsInJail++;
        System.out.print("Turn " + currentPlayer.turnsInJail);

        if(currentPlayer.turnsInJail == 3){
            currentPlayer.inJail = false;

            int roll = cube.rollCube();;

            currentPlayer.move(roll, board);
        }

        return currentPlayer.inJail;
    }
}
