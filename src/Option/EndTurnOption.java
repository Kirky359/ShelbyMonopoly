package Option;
import Game.*;

import Game.Game;

public class EndTurnOption extends PlayerOption {
    Game game;
    Player player;

    public EndTurnOption(Game game, Player currentPlayer){
        super("End Turn");
        this.game = game;
        player = currentPlayer;
    }

    @Override
    public void action(){
        game.endTurn(player);
    }
}
