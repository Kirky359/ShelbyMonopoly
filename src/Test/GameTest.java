package Test;

import Game.*;
import Board.*;
import Cube.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test; // Add this import statement

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class GameTest {

    private Jail jail;
    private Cube cube;
    private Board board;
    private List<Player> players;
    private Game game;

    @BeforeEach
    void setUp() {
        // Create instances of Jail, Cube, Board, and List<Player> for testing
        jail = new Jail();
        cube = new Cube();
        players = new ArrayList<>();
        board = new Board(jail, cube, players);

        // Add at least one player for testing
        players.add(new Player("Player1"));

        // Initialize the game before each test

        game = new Game(jail, cube, board, players, playerInputMock);
    }

    @Test
    void testGetPlayers() {
        // Check that the getPlayers method returns the correct list of players
        List<Player> retrievedPlayers = game.getPlayers();
        assertEquals(players, retrievedPlayers);
    }

    @Test
    void testTurn() {
        // Create a mock PlayerInput
        PlayerInput playerInputMock = new PlayerInput() {
            @Override
            public Object selectOptions(List<? extends Object> options, String prompt) {
                return options.get(0); // Return the first option for testing
            }
        };

        // Initialize the game with the PlayerInput mock
        game = new Game(jail, cube, board, players, playerInputMock);

        // Create a player and check that the turn is executed without errors
        Player currentPlayer = players.get(0);
        assertDoesNotThrow(() -> game.turn(currentPlayer));
    }

    @Test
    void testEndTurn() {
        // Create a player and check that the endTurn method switches the turn to the next player
        Player currentPlayer = players.get(0);
        game.endTurn(currentPlayer);

        // Check that the turn is now with the next player
        Player nextPlayer = players.get(1);
        assertEquals(nextPlayer, game.getCurrentPlayer(currentPlayer));
    }

    // Add other tests according to your requirements
}