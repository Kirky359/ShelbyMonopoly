package Option;

import Game.Player;
import Board.*;

import java.util.List;


public class ListPropertiesOption extends PlayerOption {
    Player player;

    public ListPropertiesOption(Player currentPlayer){
        super("List Properties");
        player = currentPlayer;
    }

    @Override
    public void action(){
        List<Square> ownedProperties = player.listProperties();

        if (ownedProperties.isEmpty()) {
            System.out.println("You do not own any properties");
        } else {
            for (Square ownedProperty : ownedProperties) {
                System.out.println(ownedProperty);
            }
        }
    }
}
