package Game;

class ListPropertiesOption extends PlayerOption{
    Player player;

    public ListPropertiesOption(Player currentPlayer){
        super("List Properties");
        player = currentPlayer;
    }

    public void action(){
        player.listProperties();
    }
}
