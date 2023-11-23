package Game;

import Game.*;
import Cube.*;
import Board.*;

public class RollOptionJail extends PlayerOption {
    Cube cube;
    Player player;
    Board board;

    public RollOptionJail(Cube cube, Player currentPlayer, Board board){
        super("Roll");
        this.cube = cube;
        player = currentPlayer;
        this.board = board;
    }

    public void action(){
        int roll = cube.rollCube();

        if(cube.isDouble()){
            player.inJail = false;
            player.move(roll, board);
        }
    }
}