package Game;

import Board.PropertyColors;

class BuyHouseOption extends PlayerOption{
    Player player;

    public BuyHouseOption(Player currentPlayer){
        super("Buy Houses");
        player = currentPlayer;
    }

    public void action(){
        PropertyColors houseProperty = (PropertyColors) PlayerInput.selectOptions(player.getHouseableProperties(), "Select property to purchase house on: ");

        if(houseProperty == null){
            System.out.println("You do not have any properties to place a house on");
        } else {
            houseProperty.addHouse();
        }
    }
}
