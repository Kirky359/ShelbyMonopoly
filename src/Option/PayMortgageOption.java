package Option;
import Board.*;
import Game.Player;
import Game.PlayerInput;

public class PayMortgageOption extends PlayerOption {
    Player player;

    public PayMortgageOption(Player currentPlayer){
        super("Pay Mortgage");
        player = currentPlayer;
    }

    @Override
    public void action(){
        Property payMortProperty = (Property) PlayerInput.selectOptions(player.getMortgagedProperties(), "Select a property to pay off mortgage");

        if(payMortProperty == null){
            System.out.println("You do not have any mortgaged properties");
        } else {
            player.payMortgage(payMortProperty);
        }
    }
}