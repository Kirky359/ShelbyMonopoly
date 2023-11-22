//package Test;
//
//import Board.*;
//import Cube.Cube;
//import Game.Player;
//import Monopoly.*;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import static org.junit.Assert.*;
//
//public class BoardTest {
//
//    @Test
//    public void TestWorkOfBoard() {
//        ArrayList<Player> players = new ArrayList<>();
//        Cube cube = new Cube();
//        Board board = new Board(players, cube);
//
//        assertNotNull(board.players);
//        assertEquals(players, board.players);
//        assertNotNull(board.cube);
//        assertEquals(cube, board.cube);
//
//        assertNotNull(board.getField());
//        assertEquals(40, board.getField().length);
//        for (int i = 0; i < 40; i++) {
//            assertNotNull(board.getSquare(i));
//            assertEquals("Square" + i, board.getSquare(i).getName());
//        }
//    }
//}