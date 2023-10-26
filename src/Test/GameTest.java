package Test;

import Board.Board;
import Cube.Cube;
import Game.Game;
import Game.Player;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
public class GameTest {

    private Game game;
    private ArrayList<Player> players;
    @Before
    // створює об'єкти, які будуть використовуватися в подальших тестах
    public void setUp() {
        Cube cube = new Cube();
        Player player1 = new Player("Player Nik");
        Player player2 = new Player("Player Misha");
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        Board board = new Board(players, cube);
        this.game = new Game(players, board, cube);
        this.players = players;
    }
    @Test
    // перевіряє, чи метод isCardPosition визначає позиції клітинок з карточками правильно
    public void testIsCardPosition() {
        assertTrue(game.isCardPosition(2)); // Позиція 2 є картою
        assertTrue(game.isCardPosition(7)); // Позиція 7 є картою
        assertTrue(game.isCardPosition(17)); // Позиція 17 є картою
        assertTrue(game.isCardPosition(22)); // Позиція 22 є картою
        assertTrue(game.isCardPosition(33)); // Позиція 33 є картою
        assertTrue(game.isCardPosition(36)); // Позиція 36 є картою
        assertFalse(game.isCardPosition(5)); // Позиція 5 не є картою
        assertFalse(game.isCardPosition(8)); // Позиція 8 не є картою
        assertFalse(game.isCardPosition(12)); // Позиція 12 не є картою
        assertFalse(game.isCardPosition(19)); // Позиція 19 не є картою
        assertFalse(game.isCardPosition(26)); // Позиція 26 не є картою
        assertFalse(game.isCardPosition(39)); // Позиція 39 не є картою
    }
    @Test
    // перевіряє, чи метод turnPlayer працює, і чи гравець дійсно змінює свою позицію після виклику методу.
    public void testTurnPlayer() {
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int initialPosition = players.get(0).getPosition();

        game.turnPlayer(players.get(0));
        assertNotEquals(initialPosition, players.get(0).getPosition());
    }
}
