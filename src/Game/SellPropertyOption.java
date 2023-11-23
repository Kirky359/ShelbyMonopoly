package Game;

import Board.*;

class SellPropertyOption extends PlayerOption {
    Player player;

    public SellPropertyOption(Player currentPlayer){
        super("Sell Unimproved Properties");
        player = currentPlayer;
    }

    public void action(){
        Property sellProperty = (Property) PlayerInput.selectOptions(player.getUnimprovedProperties(), "Select a property to sell");

        if(sellProperty == null){
            System.out.println("You do not have properties to sell.");
        } else {
            player.sell(sellProperty);
        }
    }
}