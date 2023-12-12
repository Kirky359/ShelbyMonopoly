package Option;

import Game.Player;

public class ListPropertiesOption extends PlayerOption {
    Player player;

    public ListPropertiesOption(Player currentPlayer){
        super("List Properties");
        player = currentPlayer;
    }

    @Override
    public void action(){
        player.listProperties();
    }
}
