package Option;

import Board.*;
import Game.*;
import Cube.*;

public class PlayerOptionFactory {

    public PlayerOption createPlayerOption(OptionType optionType, Game game, Player currentPlayer, Board board, Cube cube) {
        PlayerOption toReturn = null;
        switch (optionType) {
            case LIST_PROPERTIES:
                toReturn = new ListPropertiesOption(currentPlayer);
                break;
            case BUY_HOUSE:
                toReturn = new BuyHouseOption(currentPlayer);
                break;
            case MORTGAGE:
                toReturn = new MortgageOption(currentPlayer);
                break;
            case PAY_MORTGAGE:
                toReturn = new PayMortgageOption(currentPlayer);
                break;
            case END_TURN:
                toReturn = new EndTurnOption(game, currentPlayer);
                break;
            case ROLL_OPTION_JAIL:
                toReturn = new RollOptionJail(cube, currentPlayer, board);
                break;
            case PAY_BAIL_OPTION:
                toReturn = new PayBailOption(cube, currentPlayer, board);
                break;
            case SELL_OPTION:
                toReturn = new SellPropertyOption(currentPlayer);
                break;
            default:
                throw new IllegalArgumentException("Invalid option type: " + optionType);
        }
        return toReturn;
    }
}
