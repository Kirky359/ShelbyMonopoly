package Option;

import Board.PropertyColors;
import Game.Player;
import Game.PlayerInput;

public class BuyHouseOption extends PlayerOption {
    Player player;

    public BuyHouseOption(Player currentPlayer){
        super("Buy Houses");
        player = currentPlayer;
    }

    @Override
    public void action(){
        PropertyColors houseProperty = (PropertyColors) PlayerInput.selectOptions(player.getHouseableProperties(), "Select property to purchase house on: ");

        if(houseProperty == null){
            System.out.println("You do not have any properties to place a house on");
        } else {
            houseProperty.addHouse();
        }
    }
}
