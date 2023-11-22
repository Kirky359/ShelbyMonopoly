package Game;

import Cube.Cube;
import Board.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private final Jail jail;
    private final Cube cube;
    private final Board board;
    private ArrayList<Player> players = new ArrayList<Player>();

    public Game(Jail jail, Cube cube, Board board, ArrayList<Player> players){
        this.jail = jail;
        this.cube = cube;
        this.board = board;
        this.players = players;
    }

    public ArrayList<Player> getPlayers (){
        return players;
    }
    //pass turn to next Player
    public void turn(Player currentPlayer){
        System.out.println("\n" + currentPlayer.getName() + "'s turn!\nMoney: $" + currentPlayer.getMoney());

        if(currentPlayer.inJail){ //if player doesn't escape jail on turn, skips to showOptions

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

    //player options after roll and land on a square
    private void showOptions(Player currentPlayer){
        List<PlayerOption> options = Arrays.asList(
                new ListPropertiesOption(currentPlayer),
                new BuyHouseOption(currentPlayer),
//                new MortgageOption(currentPlayer),
//                new PayMortgageOption(currentPlayer),
                new EndTurnOption(this, currentPlayer)
        );

        PlayerOption selectedOption = (PlayerOption) PlayerInput.selectOptions(options, "Additional Actions:");
        selectedOption.action();

        showOptions(currentPlayer); //when player does not select end turn
    }
}
