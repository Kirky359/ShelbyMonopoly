package Test;
import Cube.Cube;
import Board.Board;
import Game.Player;
import Monopoly.Monopoly;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void TestWorkOfBoard(){
        Cube cube = new Cube();
        ArrayList<Player> players = Monopoly.createPlayers(2);
        Board board = new Board(players, cube);
    }
}
