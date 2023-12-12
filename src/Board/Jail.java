package Board;

import java.util.Arrays;
import java.util.List;
import Game.*;
import Cube.Cube;
import Option.*;

public class Jail{
    private Game game;
    private PlayerOptionFactory optionFactory;

    public void setGame(Game game){
        this.game = game;
        this.optionFactory = new PlayerOptionFactory();
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

            int roll = cube.rollCube();
            if(!cube.isDouble()){
                currentPlayer.addMoney(-50);
            }

            currentPlayer.move(roll, board);
        }

        List<PlayerOption> jailOptions = Arrays.asList(
                optionFactory.createPlayerOption(OptionType.ROLL_OPTION_JAIL, game, currentPlayer, board, cube),
                optionFactory.createPlayerOption(OptionType.PAY_BAIL_OPTION, game, currentPlayer, board, cube)
        );

        PlayerOption selectedOption = (PlayerOption) PlayerInput.selectOptions(jailOptions, "Roll a double or pay $50 to escape");
        selectedOption.action();

        return currentPlayer.inJail;
    }
}
