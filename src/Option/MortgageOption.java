package Option;
import Board.*;
import Game.Player;
import Game.PlayerInput;

public class MortgageOption extends PlayerOption {
    Player player;

    public MortgageOption(Player currentPlayer){
        super("Mortgage Properties");
        player = currentPlayer;
    }

    public void action(){
        Property mortgageProperty = (Property) PlayerInput.selectOptions(player.getUnimprovedProperties(), "Select an unimproved property");

        if(mortgageProperty == null){
            System.out.println("You do not have any unimproved properties to mortgage");
        } else {
            player.mortgage(mortgageProperty);
        }
    }
}
