package Game;

class EndTurnOption extends PlayerOption{
    Game game;
    Player player;

    public EndTurnOption(Game game, Player currentPlayer){
        super("End Turn");
        this.game = game;
        player = currentPlayer;
    }

    public void action(){
        game.endTurn(player);
    }
}
