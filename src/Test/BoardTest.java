package Test;

import Board.*;
import Cube.Cube;
import Game.Player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        Jail jail = new Jail();
        Cube cube = new Cube();
        List<Player> players = new ArrayList<>();
        board = new Board(jail, cube, players);
    }

    @Test
    public void testGetSquareAt() {
        Square square = board.getSquareAt(0);
        Assertions.assertEquals("GO", square.toString());
    }

    @Test
    public void testGetCurrentSquare() {
        Player player = new Player("Mykyta");
        String input = "n\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        player.move(5, board);
        Square square = board.getCurrentSquare(player);
        Assertions.assertEquals("Reading Railroad", square.toString());
    }
}