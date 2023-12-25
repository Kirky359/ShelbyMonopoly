package Game;

import Cube.Cube;
import Board.*;
import Option.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private final Jail jail;
    private final Cube cube;
    private final Board board;
    private List<Player> players = new ArrayList<Player>();

    private final PlayerOptionFactory optionFactory;

    public Game(Jail jail, Cube cube, Board board, List<Player> players){
        this.jail = jail;
        this.cube = cube;
        this.board = board;
        this.players = players;
        this.optionFactory = new PlayerOptionFactory();
    }

    public List<Player> getPlayers (){
        return players;
    }

    public void turn(Player currentPlayer){
        System.out.println("\n" + currentPlayer.getName() + "'s turn!\nMoney: $" + currentPlayer.getMoney());

        if(currentPlayer.isInJail()){ //if player doesn't escape jail on turn, skips to showOptions

            if(!jail.jailTurn(currentPlayer, cube, board)) {
                showOptions(currentPlayer);
            }
        } else { //if player is not in jail
            System.out.println("Position: " + board.getCurrentSquare(currentPlayer));
            int numDoubles = 0;

            do{
                currentPlayer.move(cube.rollCube(), board);
                numDoubles++;

                if(numDoubles == 3){
                    jail.sendPlayerToJail(currentPlayer);
                }
            } while (numDoubles < 3 && cube.isDouble());
        }

        showOptions(currentPlayer);
    }

    public void endTurn(Player currentPlayer){
        int currentIndex = players.indexOf(currentPlayer);
        if(currentIndex + 1 == players.size()){
            turn(players.get(0));
        } else {
            turn(players.get(currentIndex + 1));
        }
    }
    private void showOptions(Player currentPlayer) {
        List<PlayerOption> options = Arrays.asList(
                optionFactory.createPlayerOption(OptionType.LIST_PROPERTIES, this, currentPlayer, board, cube),
                optionFactory.createPlayerOption(OptionType.BUY_HOUSE, this, currentPlayer, board, cube),
                optionFactory.createPlayerOption(OptionType.MORTGAGE, this, currentPlayer, board, cube),
                optionFactory.createPlayerOption(OptionType.PAY_MORTGAGE, this, currentPlayer, board, cube),
                optionFactory.createPlayerOption(OptionType.END_TURN, this, currentPlayer, board, cube)
        );

        PlayerOption selectedOption = (PlayerOption) PlayerInput.selectOptions(options, "Additional Actions:");
        selectedOption.action();

        showOptions(currentPlayer);
    }
    public GameMemento saveGame(Player currentPlayer) {
        int currentPlayerIndex = players.indexOf(currentPlayer);
        return new GameMemento(players, currentPlayerIndex);
    }

    public void restoreGame(GameMemento memento, Player currentPlayer) {
        players = memento.getPlayers();
        int currentPlayerIndex = memento.getCurrentPlayerIndex();
        currentPlayer = players.get(currentPlayerIndex);
    }
}